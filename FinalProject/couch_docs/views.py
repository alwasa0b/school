from django.http import Http404,HttpResponseRedirect
from django.shortcuts import render_to_response
from django.template import RequestContext
from django.conf import settings
from couchdb import *
from couch_docs.forms import OrderForm2
from couchdbkit.ext.django.schema import *

import datetime 
from couch_docs.models import Availability
from django.core.serializers.json import json, DjangoJSONEncoder




SERVER = Server('http://localhost:5984/')
db=SERVER['docs']

func_str = "function(d) { if (d.type=='desgin') emit(d,null) }"
func_str2 = "function(d) { if (d.type=='artist') emit(d,null); }"
today = datetime.datetime.now()
date = json.dumps(today, cls=DjangoJSONEncoder)

def readytatoos(request):
	d=[]
	for row in db.query(func_str):
		d.append(row)	
	context = {'rows':d}
	#	print row.key
	return render_to_response('hennaall.html',context)


def artist(request, artist):
	d=[]
	for row in db.query(func_str2):
		if(row.key['slug'] == artist): 
			name=row.key['name']
			picture=row.key['picture']
			description=row.key['description']
	for row in db.query(func_str):
		if(row.key['artistslug'] == artist):
			d.append(row)
	context = {'rows':d, 'name':name,'picture': picture, 'description':description}
	#	print row.key
	return render_to_response('artist.html',context,context_instance=RequestContext(request))


def tatoo(request, hennaslug):
	d=[]
	for row in db.query(func_str):
		
		if(row.key['slug'] == hennaslug):
			#d.append(row)
			name=row.key['name']
			picture=row.key['picture']
			description=row.key['description']
			artistslug=row.key['artistslug']
			
				
	for row in db.query(func_str2):
		if(row.key['slug'] == artistslug):
			artist=row.key['name']
			slu=row.key['slug']
	
	for row in db.query(func_str):
		if(row.key['artistslug']==artistslug and row.key['slug'] != hennaslug):
			d.append(row)
			
	context = {'henna': name,'artist':artist,'slu':slu,'work': d,'picture':picture,'description':description}
	return render_to_response('singlehenna.html', context,context_instance=RequestContext(request))

def ArtistAll(request):
	d=[]
	for row in db.query(func_str2):
		d.append(row)
	context = {'artists': d}
	return render_to_response('artistall.html', context,context_instance=RequestContext(request))

def order(request):
	result=db.query(func_str)
	des=[]
	for i in result:
		des.append(i.key['name'])

	if request.method == "POST":
		name = request.POST['name'].replace(' ','')
		address = request.POST['address'].replace(' ','')
		_id=name+address
		try:
			db[_id] = {'name':request.POST['name'] ,'address': request.POST['address'] ,'type':"customer",'order':[["ready-desgin",request.POST['item_id'], date]]}
			row=db[_id]
			return render_to_response('placedordercouch.html',{'row':row},context_instance=RequestContext(request))
		except ResourceConflict:
			this= db.get(name+address)
			this['order'].append(["ready-desgin",request.POST['item_id'], date])
			db.save(this)
			return render_to_response('placedordercouch.html',{'row':this},context_instance=RequestContext(request))
		
	return render_to_response('ordercouch.html',{'rows':db,'des':result},context_instance=RequestContext(request))

result=db.query(func_str2)
artist=[]
for i in result:
	artist.append(i.key['name'])

def PlaceOrder3(request):

	if request.method == "POST":
		name = request.POST['name'].replace(' ','')
		address = request.POST['address'].replace(' ','')
		description = request.POST['description']
		_id=name+address
		try:
			db[_id] = {'name':request.POST['name'] ,'address': request.POST['address'],'type':"customer",'order':[["custom-desgin",request.POST['item_id'], description ,date]]}
			row=db[_id]
			context={'row':row}
			return render_to_response('placedordercouch.html',context,context_instance=RequestContext(request))
		except ResourceConflict:
			this= db.get(name+address)
			this['order'].append(["custom-desgin",request.POST['item_id'], description ,date])
			db.save(this)
			return render_to_response('placedordercouch.html',{'row':this},context_instance=RequestContext(request))
	return render_to_response('customdesgincouch.html',{'rows':db,'des':result},context_instance=RequestContext(request))

def PlaceOrder(request):
	if request.method == 'POST':
		form = OrderForm2(request.POST)
		if form.is_valid():
			start_date = form.cleaned_data['start_date']
			end_time = form.cleaned_data['end_time']
			start_time = form.cleaned_data['start_time']
			customer,address = form.cleaned_data['name'],form.cleaned_data['address']
			_id=(customer+address).replace(' ','')
			try:
				
				db[_id] = {'name':customer , 'address':address,'type':"customer",'order':[["reservation",request.POST['item_id'],request.POST['start_date'],request.POST['start_time'],request.POST['end_time'] ,date]]}
				row=db[_id]
				context={'row':row}
				return render_to_response('placedordercouch.html',context,context_instance=RequestContext(request))
			except ResourceConflict:
				this= db.get(_id)
				order=["reservation",request.POST['item_id'],request.POST['start_date'],request.POST['start_time'],request.POST['end_time'],date]
				this['order'].append(order)
				db.save(this)
				context={'row': this}
				return render_to_response('resorder.html',context,context_instance=RequestContext(request))
			
	else:
		form = OrderForm2()
		context = {'form': form,'des':result}
		return render_to_response('res.html', context,context_instance=RequestContext(request))    