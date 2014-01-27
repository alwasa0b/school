
# Create your models here.
# coding: utf-8
from __future__ import unicode_literals
from django.utils.encoding import python_2_unicode_compatible
from django.db import models
from django.contrib.contenttypes.models import ContentType
from django.contrib.contenttypes import generic
import datetime
from django import forms
from django.forms.widgets import Select
#from henna.models import *
#from customer.models import *
from couchdbkit.ext.django.forms import *
from couchdbkit.ext.django.schema import *

@python_2_unicode_compatible
class Availability(Document):
    start_date = StringProperty()

    start_time = TimeProperty()
    end_time = TimeProperty()
    #artist = StringProperty()
    name = StringProperty()
    address = StringProperty()
    #content_object = generic.GenericForeignKey('artist', 'customer')

    def __str__(self):
        return("%s - %s" % (self.start_date.isoformat(), self.end_date.isoformat()))
    
    def generate_dates(self):
        return (self.start_date + datetime.timedelta(day=d) for d in xrange((self.end_date - self.start_date).day + 1))

   # class Meta:
       # unique_together = (("start_date", "start_time", "end_time", "artist"))
    #    verbose_name_plural = "Availability"
