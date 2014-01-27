from django.db import models
from django import forms

# Create your models here.
class Henna(models.Model):
    name = models.CharField(max_length=200)
    slug = models.SlugField(unique=True)
    descritption= models.TextField(blank=True)
    picture=models.ImageField(upload_to='images')
    fk=models.ForeignKey('Artist')
    def __unicode__(self):
        return self.name
    
class Artist(models.Model):
    fname=models.CharField(max_length=20)
    lname=models.CharField(max_length=20)
    slug = models.SlugField(unique=True)
    descritption= models.TextField(blank=True)
    rate= models.IntegerField()
    picture=models.ImageField(upload_to='images')
    def __unicode__(self):
        name = self.fname+" "+self.lname
        return name

    
class CommentForm(forms.Form):
    name = forms.CharField(label='Your name')
    url = forms.URLField(label='Your Web site', required=False)
    comment = forms.CharField()
