from api import models, serializers
from rest_framework import viewsets
from rest_framework.pagination import PageNumberPagination

key = 'ttbdng201027001'

# class SmallPagination(PageNumberPagination):
#     page_size = 10
#     page_size_query_param = "page_size"
#     max_page_size = 50


# class CategoryViewSet(viewsets.ModelViewSet):
#     serializer_class = serializers.BookSerializer
#     pagination_class = SmallPagination
 
#     def get_queryset(self):
#         queryset = 'http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey={}&QueryType=Bestseller&MaxResults=20&CategoryId={}&start=1&SearchTarget=Book&output=js&Version=20131101'.format(key, CID)
#         return queryset

# class BookDetailViewSet(viewsets.ModelViewSet):
#     serializer_class = serializers.BookDetailSerializer
#     def get_queryset(self):
#         queryset = 'http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey={}&Query={}&QueryType=Keyword&MaxResults=1&start=1&SearchTarget=Book&output=js&Version=20131101'.format(key, {query_params})
#         return queryset

    