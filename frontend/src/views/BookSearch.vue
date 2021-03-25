<template>
  <div class="books-container">
    <div v-for="(book, i) in books" :key="i">
      {{ book.title }}
      {{ book.isbn }}
    </div>
  </div>
</template>

<script>
import bookdata from "@/assets/bookdata/book_domestic.json";
export default {
  data() {
    return {
      bookdata: bookdata,
      keyword: this.$route.query.keyword,
      books: [], //검색어와 일치하는 모든 책 정보
    };
  },
  mounted() {
    this.books = this.bookdata.filter((data) => {
      return data.title.includes(this.keyword);
    });
    // console.log(this.books);
  },
};
</script>

<style scoped>
.books-container {
  margin-left: 400px;
  width: 1500px;
  height: 2000px;
  border: 3px solid black;
}
</style>
