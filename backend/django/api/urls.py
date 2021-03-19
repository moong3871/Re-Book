from django.conf.urls import url
from rest_framework.routers import DefaultRouter
from api import views


router = DefaultRouter(trailing_slash=False)
router.register(r"books", views.BookViewSet, basename="books")
<<<<<<< HEAD
# router.register(r"")
=======
# router.register(r"book/(?P<id>.+)",views.BookDetailViewSet,basename="book")
>>>>>>> d3fca2d... [ADD] django


urlpatterns = router.urls
