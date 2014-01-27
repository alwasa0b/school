# Create your views here.
from django.shortcuts import render_to_response
from django.template import RequestContext
from henna.models import Henna,Artist
from django import forms

def HennaAll(request):
    hennas = Henna.objects.all()
    context = {'hennas': hennas}
    return render_to_response('hennaall.html', context,context_instance=RequestContext(request))

def ArtistAll(request):
    artists = Artist.objects.all()
    context = {'artists': artists}
    return render_to_response('artistall.html', context,context_instance=RequestContext(request))

def SpecificDes(request, hennaslug):
    henna= Henna.objects.get(slug=hennaslug)
    context = {'henna': henna}
    return render_to_response('singlehenna.html', context,context_instance=RequestContext(request))

def SpecificArt(request, artslug):
    art= Artist.objects.get(slug=artslug)
    arts = Henna.objects.filter(fk=art)
    context = {'artist': art,'henna':arts}
    return render_to_response('artist.html', context,context_instance=RequestContext(request))


def AllWork(request, arslug):
    art= Artist.objects.get(slug=arslug)
    arts = Henna.objects.filter(fk=art)
    context = {'work': arts}
    return render_to_response('allwork.html', context,context_instance=RequestContext(request))