import pandas as pd
import numpy as np
from sklearn.metrics.pairwise import cosine_similarity

# books = pd.read_json('file:///C:/Users/multicampus/Desktop/project/fork/s04p23b206/backend/django/recommend/management/aladinalldata.json')
books = pd.read_json('./aladinalldata.json')
ratings = pd.read_json('./rating.json')

pd.set_option('display.max_columns', 14)
pd.set_option('display.width', 300)

book_ratings = pd.merge(ratings, books, on='isbn')
print(book_ratings)

title_user = book_ratings.pivot_table('rating', index='user_id', columns='isbn')
title_user.fillna(0, inplace=True)

    
# 유저와 유저 간의 유사도
user_based_collab = cosine_similarity(title_user, title_user)
user_based_collab = pd.DataFrame(user_based_collab, index=title_user.index, columns=title_user.index)

# print(user_based_collab['1'])
# print(user_based_collab['1'].sort_values(ascending=False))

user = user_based_collab[1].sort_values(ascending=False)[:5].index[1]
print(title_user.loc[user].sort_values(ascending=False).to_json())
