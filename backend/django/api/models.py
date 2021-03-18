from django.utils import timezone
from django.db import models


class Book(models.Model):
    isbn = models.IntegerField(primary_key=True)
    title = models.CharField(max_length=45)
    book_image_path = models.CharField(max_length=45, null=True)
    book_summary = models.CharField(max_length=45, null=True)
    evaluation = models.CharField(max_length=45, null=True)
    price = models.CharField(max_length=45, null=True)
    publisher = models.CharField(max_length=45, null=True)
    writer = models.CharField(max_length=45, null=True)
    genre = models.CharField(max_length=45, null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    publihsed_date = models.DateField

