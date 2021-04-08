from . import views
from django.conf.urls import url
from django.urls import path
from rest_framework.routers import DefaultRouter


router = DefaultRouter(trailing_slash=False)

# router.register(r"category", views.CategoryViewSet, basename="Category")
# router.register(r"bookDetail", views.BookDetailViewSet, basename="bookdetail")
# router.register(r"bookSearch", views.BookSearchViewSet, 'booksearch')
# router.register(r"book/(?P<id>.+)",views.BookDetailViewSet,basename="book")

urlpatterns = [
    path('', views.index, name='index'),
    path('<int:user_id>/', views.recommend, name='recommend'),
]
