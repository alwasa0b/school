# Create your views here.
from django.http import HttpResponseRedirect
from django.shortcuts import render_to_response
from django.template import RequestContext
from customer.forms import OrderForm
from django.contrib.auth.models import User
from customer.models import order,Customer
from datetime import datetime  


def PlaceOrder(request):
    form = OrderForm(request.POST)
    if request.method == 'POST':
        henna=form.save(commit=False)
  
        henna.save()
        locations = list(order.objects.all())
        ordr= locations[-1]
        context = {'order': ordr}
        customer = {'customer': form.cleaned_data['customer'],'order':ordr}
        return render_to_response('placedorder.html', customer ,context_instance=RequestContext(request))
    
    else:
                form = OrderForm()
                context = {'form': form}
                return render_to_response('order.html', context, context_instance=RequestContext(request))
            
     
            


