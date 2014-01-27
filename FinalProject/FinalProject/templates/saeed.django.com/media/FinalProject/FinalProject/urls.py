from django.conf.urls import patterns, include,url
from django.views.generic import TemplateView
# Uncomment the next two lines to enable the admin:
from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'FinalProject.views.home', name='home'),
    # url(r'^FinalProject/', include('FinalProject.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    #url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    (r'^admin/', include(admin.site.urls)),
    (r'^$', TemplateView.as_view(template_name="index.html")),
    (r'^readytatoos/$', 'henna.views.HennaAll'),
    (r'^artist/$', 'henna.views.ArtistAll'),
    (r'^readytatoos/(?P<hennaslug>.*)/$','henna.views.SpecificDes'),
    (r'^artist/(?P<artslug>.*)/$','henna.views.SpecificArt'),
    (r'^order/$', 'customer.views.PlaceOrder'),
    (r'^customd/$', 'customd.views.PlaceOrder3'),
    #(r'^cart/$', 'cart.views.Cart'),
    (r'^allwork/(?P<arslug>.*)/$','henna.views.AllWork'),
    (r'^res/$','availability.views.PlaceOrder'),
    #(r'^placedorder/$', 'customer.views.OrderNumber'),
    
)


