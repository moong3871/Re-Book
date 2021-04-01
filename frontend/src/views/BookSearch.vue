<template>
  <div class="books-container">
    <div class="search-word">검색어 : {{ this.keyword }}</div>
    <div class="content">
      <div v-if="books.length == 0" class="nobook">
        검색어에 해당되는 도서가 없어요 ㅠ_ㅠ
      </div>
      <div class="wrapper" v-for="(book, i) in books" :key="i">
        <div class="box">
          <img
            :src="book.book_image_path"
            alt=""
            class="cover-image"
            @click="$router.push({ name: 'Detail', params: { book: book } })"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import bookdata from "@/assets/bookdata/book_domestic.json";
import bookdata from "@/assets/bookdata/bookdata.json";
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
      return data.title.replace(/ /g, "").includes(this.keyword);
    });
    // this.books = this.books.slice(0, 8);
    console.log(this.books);
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&display=swap");

.books-container {
  margin-left: 400px;
  width: 80vw;
  min-width: 1200px;
  /* height: 2000px; */
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
  min-width: 350px;
  height: 100%;
  padding: 2%;
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
    0 3.3px 4px rgba(0, 0, 0, 0.024), 0 6.3px 7.5px rgba(0, 0, 0, 0.1),
    0 11.2px 13.4px rgba(0, 0, 0, 0.3), 0 20.9px 25.1px rgba(0, 0, 0, 0.2),
    0 50px 60px rgba(0, 0, 0, 0.06);
}
.cover-image {
  width: 100%;
  height: 100%;
  opacity: 1;
  -webkit-transition: 0.3s ease-in-out;
  transition: 0.3s ease-in-out;
}
.cover-image:hover {
  cursor: pointer;
  opacity: 0.35;
}
.nobook {
  font-family: "Jua", sans-serif;
  width: 100%;
  height: 500px;
  display: flex;
  align-items: center;
  padding-left: 340px;
  font-size: 50px;
}
</style>
