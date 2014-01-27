import datetime
from django import forms
from django.db import models
from django.utils import formats
from django.utils.encoding import force_str
from django.utils.translation import ugettext_lazy as _, ungettext_lazy
from django.utils.translation import ungettext
from django.forms import ModelForm
from customer.models import Customer,order
from availability.models import Availability
from django.contrib.admin.widgets import AdminTimeWidget
from django.forms.extras.widgets import *
import django.forms.widgets as ww


DATE_FORMATS =  ['%d/%m/%y', '%d/%m/%Y', '%d.%m.%y']




class OrderForm2(ModelForm):
  
    class Meta:

        model = Availability
        fields=['start_date','start_time','end_time','artist','customer']
        widgets = {
            'start_date': SelectDateWidget(), 
         
            'start_time': forms.TimeInput(format='%H:%M') ,
            'end_time': forms.TimeInput(format='%H:%M') ,
        }
OrderForm2.base_fields['start_time'].help_text = 'e.g. 7:00 A time widget will be added in the future'
OrderForm2.base_fields['end_time'].help_text = 'e.g. 18:00'    

'''
class MultiDateField(forms.fields.BaseTemporalField):
    input_formats = formats.get_format_lazy('DATE_INPUT_FORMATS')
    default_error_messages = {
        'invalid': _('Enter a list of dates separated by a comma'),
    }

    def to_python(self, value):
        """
        Validates that the input can be converted to a list of dates. Returns a Python
        list of datetime.date objects.
        """
        return super(MultiDateField, self).to_python(value)

    def strptime(self, value, format):
        if len(value)>0:
            values = value.split(",")
            dates = [datetime.datetime.strptime(force_str(d), format).minutes() for d in values]
        else:
            dates = []

        return list(dates)

class AvailabilityForm(forms.Form):
    dates = MultiDateField(input_formats=DATE_FORMATS, required=False, widget=forms.widgets.HiddenInput)'''

