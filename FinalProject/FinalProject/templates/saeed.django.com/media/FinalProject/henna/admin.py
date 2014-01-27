from django.contrib import admin
from django.contrib.auth.forms import AuthenticationForm
from henna.models import Henna, Artist
from availability.models import *
from customer.models import Customer,order
from django.contrib.auth.models import User
from django.contrib.sites.models import Site
from django.contrib.auth.models import Group
from django import forms
from customd.models import *
  
class HennaAdmin(admin.ModelAdmin):
    prepopulated_fields={'slug': ('name',),}
    list_display=('name','descritption')
    search_fields=['name']

class ArtistAdmin(admin.ModelAdmin):
    prepopulated_fields={'slug': ('fname','lname'),}
    
class CustomerAdmin(admin.ModelAdmin):
    prepopulated_fields={'slug': ('fname','lname'),}

admin.site.register(Henna, HennaAdmin)
admin.site.register(Artist,ArtistAdmin)
admin.site.register(Customer,CustomerAdmin)
admin.site.register(order)
admin.site.register(Availability)
admin.site.register(CustomDesgin)
admin.site.unregister(User)
admin.site.unregister(Group)
admin.site.unregister(Site)