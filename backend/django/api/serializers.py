from .models import Book
from rest_framework import serializers


class BookSerializer(serializers.ModelSerializer):
    class Meta:
        model = Book
        # fields = [
        #     "isbn",
        #     "title",
        #     "book_image_path",
        #     "book_summary",
        #     "evaluation",
        #     "price",
        #     "publisher",
        #     "writer",
        #     "genre",
        # ]
        fields = '__all__'