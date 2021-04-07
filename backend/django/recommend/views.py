from . import models, serializers
from .models import Book, Rating
from django.shortcuts import render
from django.http import JsonResponse
from rest_framework.response import Response
from rest_framework.decorators import api_view
from sklearn.metrics.pairwise import cosine_similarity
import pandas as pd
import MySQLdb

@api_view(['GET'])
def recommend(request, user_id):

    # 책 데이터 불러오기
    with open('recommend/management/commands/aladinalldata.json', encoding='UTF-8') as books:
        books = pd.read_json(books)

    # AWS 환경 실행
    con = MySQLdb.connect('rebookdb.cr7qoevh9p3x.ap-northeast-2.rds.amazonaws.com', 'admin', 'ssafyb206!', 'rebookdb')
   
    # 로컬 환경 실행
    # con = MySQLdb.connect("127.0.0.1", 'root', 'ssafy107', 'rebookdb')
    
    cur = con.cursor()
    ratings = pd.read_sql_query('SELECT * FROM rating', con)

    # 데이터 출력 제한
    # pd.set_option('display.max_columns', 14)
    # pd.set_option('display.width', 10)

    # 데이터 통합
    book_ratings = pd.merge(books, ratings, on='isbn')
    title_user = book_ratings.pivot_table('rating', index='user_id', columns='isbn')
    title_user.fillna(0, inplace=True)

    # 유저와 유저 간의 유사도 계산
    user_based_collab = cosine_similarity(title_user, title_user)
    user_based_collab = pd.DataFrame(user_based_collab, index=title_user.index, columns=title_user.index)

    book_list = []
    # 사용자 기반 추천 목록 출력 및 JSON으로 변환
    user = user_based_collab[user_id].sort_values(ascending=False)[:7].index[1]
    recommend_books = title_user.loc[user].sort_values(ascending=False).to_json()
    for k, v in title_user.loc[user].sort_values(ascending=False).items():
        book_list.append(k)

    book_info = set(book_list)

    return Response(book_info)
    # return render(request, 'index.html', context) 


def index(request):
    ratings = Rating.objects.all()
    print(ratings)
    return render(request, 'index.html')

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

    