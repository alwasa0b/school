import os
import sys

os.environ['DJANGO_SETTINGS_MODULE'] = 'FinalProject.settings'

import django.core.handlers.wsgi
application = django.core.handlers.wsgi.WSGIHandler()

sys.path.append('/home/bob/workspace/FinalProject/')