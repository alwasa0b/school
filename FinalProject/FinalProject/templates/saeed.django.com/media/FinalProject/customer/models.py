# Create your models here.
from django.db import models
from django.db.models.signals import post_save
from django.contrib.auth.models import User
from henna.models import *
from datetime import datetime  
from django_autoslug.fields import AutoSlugField


class Customer(models.Model):
    fname=models.CharField(max_length=20)
    lname=models.CharField(max_length=20)
    slug = models.SlugField(unique=True)
    Address= models.CharField(max_length=40)
    def __unicode__(self):
        name = self.fname+" "+self.lname
        return name
    
def create_customer_user_callback(sender,instance,**kwargs):
    customer,new = Customer.objects.get_or_create(user=instance)
    
#post_save.connect(create_customer_user_callback,User)

class order(models.Model):
    henna=models.ForeignKey(Henna)
    customer=models.ForeignKey(Customer)
    date=models.DateField(auto_now_add=True)
    time= models.TimeField(auto_now_add=True)
    slug = AutoSlugField(populate_from=('henna','customer','date','time'))
    
    def __unicode__(self):
        return self.slug


#appointment = Appointment()
#appointment.start_time = datetime.now()
## 1 hour appointment
#appointment.end_time = appointment.start_time + datetime.timedelta(hours=1)
## more stuff here
#appointment.save()
#
## Checking for collision
## where the start time for an appointment is between the the start and end times
## You would want to filter this on user, etc 
## There is also a problem if you book an appointment within another appointment
#start_conflict = Appointment.objects.filter(
#                     start_time__range=(appointment.start_time,
#                                        appointment.end_time))
#end_conflict = Appointment.objects.filter(
#                   end_time__range=(appointment.start_time,
#                                    appointment.end_time))
#
#during_conflict = Appointment.objects.filter(
#                      start_date__lte=appointment.start_time, 
#                      end_date__gte=appointment.end_time)
#
#if (start_conflict or end_conflict or during_conflict):
#    appointment.start_time = 0
#    # reject, for there is a conflict