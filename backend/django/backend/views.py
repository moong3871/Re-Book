from rest_framework import viewsets
from rest_framework.pagination import PageNumberPagination
from api import views
from rest_framework.decorators import api_view
from rest_framework.response import Response

@api_view(['GET', 'POST'])
def hello(request):
    a = ["관계를 정리중입니다", "시간을 갈아넣는 20가지 방법", "포기하지 않고 노력하자"]
    return Response(a)