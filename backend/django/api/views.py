from api import models, serializers
from rest_framework import viewsets
from rest_framework.pagination import PageNumberPagination


class SmallPagination(PageNumberPagination):
    page_size = 10
    page_size_query_param = "page_size"
    max_page_size = 50


class BookViewSet(viewsets.ModelViewSet):
    serializer_class = serializers.BookSerializer
    pagination_class = SmallPagination

    def get_queryset(self):
        name = self.request.query_params.get("name", "")
        queryset = (
            models.Book.objects.all().filter(book_name__contains=name).order_by("id")
        )
        return queryset
