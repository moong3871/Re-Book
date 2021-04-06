
from . import models, serializers
from .models import Book, Rating
from django.shortcuts import render
from django.http import JsonResponse
from rest_framework.response import Response
from rest_framework.decorators import api_view
from sklearn.metrics.pairwise import cosine_similarity
import pandas as pd
import numpy as np

@api_view(['GET'])
def recommend(request, user_id):
    # books = pd.read_json('./management/commands/aladinalldata.json')
    # ratings = pd.read_json('./management/commands/rating.json')
    # print(ratings)
    print('-----------으악------')
    print(user_id)

    # pd.set_option('display.max_columns', 6)
    # pd.set_option('display.width', 300)
    # book_ratings = pd.merge(ratings, books, on='isbn')

    # title_user = book_ratings.pivot_table('rating', index='user_id', columns='isbn')
    # title_user.fillna(0, inplace=True)

    # # 유저와 유저 간의 유사도
    # user_based_collab = cosine_similarity(title_user, title_user)
    # user_based_collab = pd.DataFrame(user_based_collab, index=title_user.index, columns=title_user.index)

    # # print(user_based_collab['1'])
    # # print(user_based_collab['1'].sort_values(ascending=False))

    # user = user_based_collab[1].sort_values(ascending=False)[:10].index[1]
    # # print(title_user.loc[user].sort_values(ascending=False).to_json())

    # return JsonResponse(title_user.loc[user].sort_values(ascending=False).to_json())
    return render(request, 'index.html', context) 


def index(request):
    ratings = Rating.objects.all()
    print(ratings)
    context = {
        ratings: ratings
    }
    return render(request, 'index.html', context)

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

    