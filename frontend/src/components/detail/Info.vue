<template>
  <div>
    <div class="info-container">
      <div class="s-img-box">
        <img class="s-img" :src="this.book.book_image_path" alt="책 이미지" />
      </div>
      <div class="info-box-right">
        <h2>{{ book.title }}</h2>
        <p>작 가: {{ book.writer }}</p>
        <p>출판사: {{ book.publisher }}</p>
        <p>정 가: {{ book.price }}원</p>
        <p>평 균: {{ book.evaluation }}</p>
        <div>
          <button>읽고싶어요</button>
          <Stars />
        </div>
      </div>
    </div>
    <hr />
    <div class="desc-container">
      <div class="desc-box">
        <h3 class="d-title">책 소개</h3>
        <p v-if="book.book_summary == null" class="d-content">
          소개글이 없습니다.
        </p>
        <p v-else class="d-content">{{ book.book_summary }}</p>
      </div>
      <!-- <div class="desc-box">
        <h3 class="d-title">저자 소개</h3>
        <div class="d-content">
          <p>{{ backDummy.writer }}</p>
          <p>{{ dummy.desc }}</p>
        </div>
      </div> -->
    </div>
  </div>
</template>

<script>
import Stars from "./Stars.vue";
export default {
  components: { Stars },
  name: "Info",
  props: {
    book: Object,
  },
  data() {
    return {};
  },
};
</script>

<style scoped>
.info-container {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  margin-bottom: 3rem;
}
.s-img-box {
  width: 844px;
  height: 617px;
  display: flex;
  justify-content: center;
  background-color: #445b54;
  margin-right: 1%;
}
.s-img {
  width: 317px;
  height: 442px;
  margin: auto 1rem;
}
.info-box-right {
  height: 100%;
  text-align: left;
  font-size: 35px;
  letter-spacing: 5px;
  word-spacing: 5px;
  line-height: 250%;
  padding: 1%;
}
.desc-container {
  width: 100%;
  height: 100%;
  font-size: 30px;
  /* background-color: red; */
}
.desc-box {
  display: flex;
  justify-content: center;
  margin: 4rem auto;
  /* background-color: blueviolet; */
}
.d-title {
  width: 300px;
  padding: 1rem;
  /* background-color: coral; */
}
.d-content {
  width: 1310px;
  font-size: 20px;
  line-height: 200%;
  padding: 1rem;
  /* background-color: burlywood; */
}
</style>
