from django.conf.urls import url
from rest_framework.routers import DefaultRouter
from api import views


router = DefaultRouter(trailing_slash=False)
router.register(r"category", views.CategoryViewSet, basename="Category")
# router.register(r"bookDetail", views.BookDetailViewSet, basename="bookdetail")
# router.register(r"bookSearch", views.BookSearchViewSet, 'booksearch')
# router.register(r"book/(?P<id>.+)",views.BookDetailViewSet,basename="book")


urlpatterns = router.urls
