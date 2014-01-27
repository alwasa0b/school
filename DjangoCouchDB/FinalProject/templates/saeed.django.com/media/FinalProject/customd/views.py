
# Create your views here.
from django.http import HttpResponseRedirect
from django.shortcuts import render_to_response
from django.template import RequestContext
from customd.forms import OrderForm3
from django.contrib.auth.models import User
from customd.models import CustomDesgin
from datetime import datetime  


def PlaceOrder3(request):
    
    if request.method == 'POST':
        form = OrderForm3(request.POST,request.FILES)
        henna=form.save(commit=False)
       
        henna.save()
        locations = list(CustomDesgin.objects.all())
        ordr= locations[-1]
        context = {'order': ordr}
        customer = {'customer': form.cleaned_data['customer'],'order':ordr}
        return render_to_response('placedcustomdesgin.html', customer ,context_instance=RequestContext(request))
    
    else:
                form = OrderForm3()
                context = {'form': form}
                return render_to_response('customdesgin.html', context, context_instance=RequestContext(request))
            