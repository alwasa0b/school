import datetime
from django import forms
from django.db import models
from django.utils import formats
from django.utils.encoding import force_str
from django.utils.translation import ugettext_lazy as _, ungettext_lazy
from django.utils.translation import ungettext
from django.forms import ModelForm
#from customer.models import Customer,order
from couch_docs.models import Availability
from django.contrib.admin.widgets import AdminTimeWidget
from django.forms.extras.widgets import *
import django.forms.widgets as ww
from couchdbkit.ext.django.forms import *
from couchdbkit.ext.django.schema import *
from couchdb import *

DATE_FORMATS =  ['%d/%m/%y', '%d/%m/%Y', '%d.%m.%y']


SERVER = Server('http://localhost:5984/')
db=SERVER['docs']


class OrderForm2(DocumentForm):
  
    class Meta:
        document = Availability
        #fields=['start_date','start_time','end_time','artist','customer']
        widgets = {
            'start_date': SelectDateWidget(), 
         
            'start_time': forms.TimeInput(format='%H:%M') ,
            'end_time': forms.TimeInput(format='%H:%M') ,
        }
OrderForm2.base_fields['start_time'].help_text = 'e.g. 7:00 A time widget will be added in the future'
OrderForm2.base_fields['end_time'].help_text = 'e.g. 18:00'

