from django.conf.urls import patterns, include,url
from django.views.generic import TemplateView
from django.contrib import admin
admin.autodiscover()
from django.conf import settings
from django.conf.urls.static import static


urlpatterns = patterns('',
    (r'^admin/', include(admin.site.urls)),
    (r'^$', TemplateView.as_view(template_name="index.html")),    
    (r'^artist/$', 'couch_docs.views.ArtistAll'),
    (r'^order/$', 'couch_docs.views.order'),
    (r'^customd/$', 'couch_docs.views.PlaceOrder3'),
    (r'^res/$','couch_docs.views.PlaceOrder'),
  
    
    
    (r'^readytatoos/$', 'couch_docs.views.readytatoos'),
    (r'^artist/(?P<artist>.*)/$','couch_docs.views.artist'),
    (r'^readytatoos/(?P<hennaslug>.*)/$','couch_docs.views.tatoo'),
    (r'^allwork/(?P<arslug>.*)/$','couch_docs.views.AllWork'),
)

    

if settings.DEBUG:
    urlpatterns += patterns('',
        (r'^%s(?P<path>.*)$' % settings.MEDIA_URL[1:],
         'django.views.static.serve',
         {'document_root': settings.MEDIA_ROOT, 'show_indexes': True}),
    )
