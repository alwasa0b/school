from django import forms
from django.contrib.auth.models import User
from django.forms import ModelForm
from customd.models import CustomDesgin

class OrderForm3(ModelForm):
    class Meta:
        model = CustomDesgin
        fields=['desginName','descritption','customer','artist','picture']
        #exclude = ('slug','date','time',)

