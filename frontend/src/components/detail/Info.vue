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
        <p>평 점: {{ book.evaluation }}</p>
        <div class="btn-container">
          <div class="dropdown">
            <v-menu offset-y>
              <template v-slot:activator="{ on, attrs }">
                <v-btn v-bind="attrs" v-on="on">
                  {{ status[current] }}
                </v-btn>
              </template>
              <v-list>
                <v-list-item
                  v-for="(item, index) in items"
                  :key="index"
                  link
                  @click="changeStatus(index)"
                >
                  <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
          </div>
          <Stars @openCommentModal="handleCommentModal" />
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
    dummy: Object,
    book: Object,
  },
  data() {
    return {
      status: ["+ 읽고싶어요", "- 읽는 중", "✓ 읽었어요"],
      current: 0,
      // color: ["#E91E63", "#F8BBD0", "#616161"],
      items: [
        { title: "+ 읽고싶어요" },
        { title: "- 읽는 중" },
        { title: "✓ 읽었어요" },
      ],
    };
  },
  methods: {
    changeStatus(index) {
      this.current = index;
      this.$emit("changeStatus", this.current);
      // axios
      //   .put(`http://j4b206.p.ssafy.io/api/book/${ISBN}`, {
      //     userToken: localStorage.getItem("jwt"),
      //     status: this.current,
      //   })
      //   .then(() => {
      //     console.log("성공");
      //   })
      //   .catch((err) => {
      //     console.log(err);
      //   });
    },
    handleCommentModal() {
      this.$emit("openCommentModal");
    },
  },
  mounted() {
    this.current = this.dummy.status;
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
.btn-container {
  display: flex;
  justify-content: flex-start;
  align-content: center;
}
.dropdown {
  width: 250px;
  height: 86.4px;
  margin-right: 10%;
  line-height: 0;
}
.theme--light.v-btn.v-btn--has-bg {
  width: 100%;
  height: 100%;
  font-size: 30px;
  background-color: hotpink;
}
.v-list-item__title {
  font-size: 25px;
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
