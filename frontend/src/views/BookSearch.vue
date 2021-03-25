<template>
  <div class="books-container">
    <!-- <div v-for="(book, i) in books" :key="i">
      {{ book.title }}
      {{ book.isbn }}
    </div> -->
    <div class="search-word">검색어 : {{ this.keyword }}</div>
    <div class="content">
      <div class="wrapper" v-for="(book, i) in books" :key="i">
        <div class="box">
          <img
            :src="book.book_image_path"
            alt=""
            class="cover-image"
            @click="
              $router.push({ name: 'Detail', params: { ISBN: book.isbn } })
            "
          />
        </div>
      </div>
      <!-- <div class="wrapper">
        <div class="box">
          <img
            src="https://image.aladin.co.kr/product/26613/43/cover500/k192739031_1.jpg"
            alt=""
            class="cover-image"
          />
        </div>
      </div>
      <div class="wrapper">
        <div class="box">
          <img
            src="https://image.aladin.co.kr/product/26613/43/cover500/k192739031_1.jpg"
            alt=""
            class="cover-image"
          />
        </div>
      </div>
      <div class="wrapper">
        <div class="box">
          <img
            src="https://image.aladin.co.kr/product/26613/43/cover500/k192739031_1.jpg"
            alt=""
            class="cover-image"
          />
        </div>
      </div>
      <div class="wrapper">
        <div class="box">
          <img
            src="https://image.aladin.co.kr/product/26613/43/cover500/k192739031_1.jpg"
            alt=""
            class="cover-image"
          />
        </div>
      </div>
      <div class="wrapper">
        <div class="box">
          <img
            src="https://image.aladin.co.kr/product/26613/43/cover500/k192739031_1.jpg"
            alt=""
            class="cover-image"
          />
        </div>
      </div>
      <div class="wrapper">
        <div class="box">
          <img
            src="https://image.aladin.co.kr/product/26613/43/cover500/k192739031_1.jpg"
            alt=""
            class="cover-image"
          />
        </div>
      </div>
      <div class="wrapper">
        <div class="box">
          <img
            src="https://image.aladin.co.kr/product/26613/43/cover500/k192739031_1.jpg"
            alt=""
            class="cover-image"
          />
        </div>
      </div> -->
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
    this.books = this.books.slice(0, 8);
    console.log(this.books);
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Jua&display=swap");

.books-container {
  margin-left: 400px;
  width: 1500px;
  height: 2000px;
  /* border: 3px solid black; */
}
.search-word {
  /* border: 3px solid green; */
  padding-left: 50px;
  font-size: 40px;
  font-family: "Jua", sans-serif;
  /* text-align: center; */
}
.content {
  display: flex;
  flex-wrap: wrap;
  margin-top: 30px;
  padding: 0 30px;
  border: 3px solid black;
}
.wrapper {
  width: 25%;
  height: 100%;
  padding: 10px;
  margin-top: 30px;
  margin-bottom: 20px;
  /* border: 5px solid red; */
}

.box {
  position: relative;
  width: 90%;
  height: 410px;
  border-radius: 5px;
  /* overflow: hidden; */
  box-shadow: 0 1.4px 1.7px rgba(0, 0, 0, 0.017),
    0 3.3px 4px rgba(0, 0, 0, 0.024), 0 6.3px 7.5px rgba(0, 0, 0, 0.03),
    0 11.2px 13.4px rgba(0, 0, 0, 0.036), 0 20.9px 25.1px rgba(0, 0, 0, 0.043),
    0 50px 60px rgba(0, 0, 0, 0.06);
}
.cover-image {
  width: 100%;
  height: 100%;
}
</style>
