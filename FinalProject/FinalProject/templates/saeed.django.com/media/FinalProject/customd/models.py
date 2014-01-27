# Create your models here.
from django.db import models
from django.db.models.signals import post_save
from django.contrib.auth.models import User
from henna.models import *
from datetime import datetime  
from django_autoslug.fields import AutoSlugField
from customer.models import *  
from henna.models import *  

class CustomDesgin(models.Model):
    desginName = models.CharField(max_length=200)
    descritption= models.TextField(blank=True)
    customer=models.ForeignKey(Customer)
    artist=models.ForeignKey(Artist)
    date=models.DateField(auto_now_add=True)
    time= models.TimeField(auto_now_add=True)
    picture=models.ImageField(upload_to='images')
    slug = AutoSlugField(populate_from=('customer','desginName','artist'))
    
    def __unicode__(self):
        return self.slug


