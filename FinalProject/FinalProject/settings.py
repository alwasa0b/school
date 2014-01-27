# Django settings for FinalProject project.

from django.conf import settings
import os
from couchdb import *


DEBUG = True
TEMPLATE_DEBUG = DEBUG

ADMINS = (
     ('Saeed', 'alalwan@gmail.com'),
)

MANAGERS = ADMINS
COUCHDB_DATABASES = (
            ('greeting', 'http://ix.cs.uoregon.edu:18350/greeting'),
        )
SERVER = Server('http://127.0.0.1:5984')
DB = 'http://localhost:5984/'

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql', # Add 'postgresql_psycopg2', 'mysql', 'sqlite3' or 'oracle'.
        'NAME': 'finalProject',                      # Or path to database file if using sqlite3.
        # The following settings are not used with sqlite3:
        'USER': 'guest',
        'PASSWORD': 'guest',
        'HOST': '',                      # Empty for localhost through domain sockets or '127.0.0.1' for localhost through TCP.
        'PORT': '',                      # Set to empty string for default.
    }
}

# Hosts/domain names that are valid for this site; required if DEBUG is False
# See https://docs.djangoproject.com/en/1.5/ref/settings/#allowed-hosts
ALLOWED_HOSTS = []

# Local time zone for this installation. Choices can be found here:
# http://en.wikipedia.org/wiki/List_of_tz_zones_by_name
# although not all choices may be available on all operating systems.
# In a Windows environment this must be set to your system time zone.
TIME_ZONE = 'America/Los_Angeles'

# Language code for this installation. All choices can be found here:
# http://www.i18nguy.com/unicode/language-identifiers.html
LANGUAGE_CODE = 'en-us'

SITE_ID = 1

# If you set this to False, Django will make some optimizations so as not
# to load the internationalization machinery.
USE_I18N = True

# If you set this to False, Django will not format dates, numbers and
# calendars according to the current locale.
USE_L10N = True

# If you set this to False, Django will not use timezone-aware datetimes.
USE_TZ = True

# Absolute filesystem path to the directory that will hold user-uploaded files.
# Example: "/var/www/example.com/media/"
#MEDIA_ROOT = '/home/bob/workspace/FinalProject/FinalProject/templates/saeed.django.com/media/'

# URL that handles the media served from MEDIA_ROOT. Make sure to use a
# trailing slash.
# Examples: "http://example.com/media/", "http://media.example.com/"
#MEDIA_URL = '/media/'

# Absolute path to the directory static files should be collected to.
# Don't put anything in this directory yourself; store your static files
# in apps' "static/" subdirectories and in STATICFILES_DIRS.
# Example: "/var/www/example.com/static/"
#STATIC_ROOT = '/home/bob/workspace/FinalProject/FinalProject/templates/saeed.django.com/static/'
#MEDIA_URL = '/media/'
#STATIC_URL = '/static/'

#MEDIA_ROOT = 'media.127.0.0.1:8000'
#STATIC_ROOT = 'static.127.0.0.1:8000'

#STATIC_DIRS = (
#    os.path.join(os.path.abspath(os.path.dirname(__file__) + '/..'), 'static'),
#)
if(DEBUG):
   # Settings on Development Server
    MEDIA_ROOT = '/home/bob/workspace/FinalProject/FinalProject/templates/saeed.django.com/media/'
else:
    MEDIA_ROOT = '/path/to/deployed/media/'

MEDIA_URL = '/media/'
ADMIN_MEDIA_PREFIX = '/media/admin/'



# URL prefix for static files.
# Example: "http://example.com/static/", "http://static.example.com/"
#STATIC_URL = '/static/'
#SITE_ROOT = os.path.dirname(os.path.realpath(__file__))
# Additional locations of static files
STATICFILES_DIRS = (
    # Put strings here, like "/home/html/static" or "C:/www/django/static".
    # Always use forward slashes, even on Windows.
    # Don't forget to use absolute paths, not relative paths.
#   'saeed.django.com/static/',
)


STATICFILES_FINDERS = (
    'django.contrib.staticfiles.finders.FileSystemFinder',
    'django.contrib.staticfiles.finders.AppDirectoriesFinder',
#     'django.contrib.staticfiles.finders.DefaultStorageFinder',

)


SECRET_KEY = 'h938&kgwlu5&z53*b&o*s%^77y64b!z+aea%8wvwr(m=2s8+_i'


TEMPLATE_LOADERS = (
    'django.template.loaders.filesystem.Loader',
    'django.template.loaders.app_directories.Loader',
)

MIDDLEWARE_CLASSES = (
    'django.middleware.common.CommonMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
)

ROOT_URLCONF = 'FinalProject.urls'
WSGI_APPLICATION = 'FinalProject.wsgi.application'

TEMPLATE_DIRS = (
    '/home/bob/workspace/FinalProject/FinalProject/templates'             
)
AUTH_PROFILE_MODULE = 'customer.Customer'

INSTALLED_APPS = (
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.sites',
    'django.contrib.messages',
    #'django.contrib.staticfiles',
    'django_autoslug',
    'django.contrib.admin',
    'couchdbkit.ext.django',
    'couch_docs',
)
LOGGING = {
    'version': 1,
    'disable_existing_loggers': False,
    'filters': {
        'require_debug_false': {
            '()': 'django.utils.log.RequireDebugFalse'
        }
    },
    'handlers': {
        'mail_admins': {
            'level': 'ERROR',
            'filters': ['require_debug_false'],
            'class': 'django.utils.log.AdminEmailHandler'
        }
    },
    'loggers': {
        'django.request': {
            'handlers': ['mail_admins'],
            'level': 'ERROR',
            'propagate': True,
        },
    }
}
