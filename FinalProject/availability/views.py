import datetime
from django.core.urlresolvers import reverse_lazy
from django.views.generic.edit import FormView
from django.db import transaction
from django.http import HttpResponseRedirect
from django.shortcuts import render_to_response
from django.template import RequestContext
from customd.forms import *
from .models import *
import datetime
from couchdbkit import *

SERVER = Server('http://localhost:5984/')
db=SERVER['docs']





def PlaceOrder(request):
    greet = None
    if request.POST:
        form = OrderForm3(request.POST)
    if form.is_valid():
        greet = form.save()  
    else:
        form = OrderForm3()


    #greetings = Greeting.view("greeting/all")

    return render_to_response("placedcustomdesgin.html", {
            "form": form,
            "greet": greet,
            #“greetings”: greetings
    }, context_instance=RequestContext(request)
    
    
    
#    
#    if request.method == 'POST':
#        form = OrderForm2(request.POST)
#        if form.is_valid():
#            henna=form.save(commit=False)
#            henna.save()
#            locations = list(Availability.objects.all())
#            ordr= locations[-1]
#            context = {'order': ordr}
#            customer = {'customer': form.cleaned_data['customer'],'order':ordr}
#            return render_to_response('resorder.html', customer ,context_instance=RequestContext(request))
#        else:
#           
#            customer = {'artist': form.cleaned_data['artist'],'start_time':form.cleaned_data['start_time'],'end_time':form.cleaned_data['end_time']
#                        ,'start_date':form.cleaned_data['start_date']}
#            return render_to_response('notavalplacedorder.html', customer ,context_instance=RequestContext(request))
#    
#    else:
#                form = OrderForm2()
#                context = {'form': form}
#                return render_to_response('res.html', context, context_instance=RequestContext(request))    
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
today = datetime.datetime.now()
encoded = json.dumps(today, cls=DjangoJSONEncoder)


 
def order(request):
    result=db.query(func_str)
    des=[]
    for i in result:
           des.append(i.key['name'])

    if request.method == "POST":
        name = request.POST['name'].replace(' ','')
        address = request.POST['address'].replace(' ','')
        _id=name+address
        #docs[_id] = {'name':request.POST['name'] ,'address': request.POST['address'] ,'type':"customer",'order':[request.POST['item_id'], encoded]}
        #row=docs[_id]

    try:
        #name = request.POST['name'].replace(' ','')
        #address = request.POST['address'].replace(' ','')
        #_id=name+address
        db[_id] = {'name':request.POST['name'] ,'address': request.POST['address'] ,'type':"customer",'order':[[request.POST['item_id'], encoded]]}
            row=db[_id]
        # return HttpResponseRedirect(u"/doc/%s%s/" % (title, title) )
            return render_to_response('placedordercouch.html',{'row':row},context_instance=RequestContext(request))
            #return HttpResponseRedirect(u"/doc/%s/" % (_:id) )
        except ResourceConflict:
        this= db.get(name+address)
        this['order'].append([request.POST['item_id'], encoded])
        db.save(this)
        return render_to_response('placedordercouch.html',{'row':this},context_instance=RequestContext(request))
        #return render_to_response('index.html',{'rows':docs,'des':result})

    return render_to_response('ordercouch.html',{'rows':db,'des':result},context_instance=RequestContext(request))

def detail(request,id):
    #docs = settings.SERVER['docs']
    try:
        doc = db[id]
    
    except ResourceNotFound:
        raise Http404
    if request.method =="POST":
    doc['address'] = request.POST['address']
    doc['name'] = request.POST['name']
        db[id] = doc
    return render_to_response('detail.html',{'row':doc})
            
            
            
            
'''
def generate_ranges(dates):
    # takes a list of dates
    # returns a list of two-tuples corresponding to start and end dates

    ranges = []
    if len(dates)==1:
        start_date = end_date = dates[0]
        ranges.append((start_date, end_date))

    elif len(dates)>1:
        oneday = datetime.timedelta(days=1)
        dates.sort()
        start_date = dates[0]
        end_date = dates[0]

        for date in dates[1:]:
            if date == end_date+oneday:
                end_date = date
            elif date > end_date+oneday:
                ranges.append((start_date, end_date))
                start_date = date
                end_date = date

        ranges.append((start_date, end_date))

    return ranges

class AvailabilityEditView(FormView):
    model = None
    form_class = AvailabilityForm
    template_name = "availability_form.html"
    context_object_name = "object"
    success_url = None


    def get_success_url(self, **kwargs):
        if self.success_url != None:
            return self.success_url
        else:
            obj = self.model.objects.get(pk=self.kwargs['pk'])
            return obj.get_absolute_url()

    @transaction.commit_on_success
    def form_valid(self, form):
        obj = self.model.objects.get(pk=self.kwargs['pk'])
        obj.availability.all().delete()

        for r in generate_ranges(form.cleaned_data['dates']):
            a = Availability(content_object=obj, start_date=r[0], end_date=r[1])
            a.save()

        return super(AvailabilityEditView, self).form_valid(form)

    def form_invalid(self, form):
        return super(AvailabilityEditView, self).form_invalid(form)

    def get_context_data(self, **kwargs):
        context = super(AvailabilityEditView, self).get_context_data(**kwargs)
        context[self.context_object_name] = self.model.objects.get(pk=self.kwargs['pk'])
        return context'''
