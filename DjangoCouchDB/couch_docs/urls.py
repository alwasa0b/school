from django.conf.urls.defaults import *
from django.views.generic import TemplateView

urlpatterns = patterns('couch_docs.views',
    (r'^doc/(?P<id>\w+)/','detail'),
   # (r'^$','index'),
    (r'^$', TemplateView.as_view(template_name="index.html")),
)
