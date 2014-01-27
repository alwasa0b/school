from django import forms
from django.contrib.auth.models import User
from django.forms import ModelForm
from customer.models import Customer,order

class OrderForm(ModelForm):
    class Meta:
        model = order
        fields=['henna','customer']
        exclude = ('slug','date',)

