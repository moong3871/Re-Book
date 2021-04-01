<template>
  <div class="m-content">
    <Stars />
    <form>
      <input
        type="text"
        class="c-input"
        v-model="comment.content"
        placeholder="이 작품에 대한 생각을 자유롭게 표현해주세요."
      />
    </form>
    <button class="btn" type="button" @click="onSubmit">저장</button>
    <button class="btn" @click="cancel">취소</button>
  </div>
</template>

<script>
// import Button from "./Button.vue";
import axios from "axios";
import Stars from "./Stars";
export default {
  name: "ModalContent",
  components: {
    Stars,
  },
  props: {
    book: Object,
  },
  data() {
    return {
      comment: {
        content: "",
        rating: localStorage.getItem("rating"),
        userToken: localStorage.getItem("jwt"),
        book: this.book,
      },
    };
  },
  methods: {
    cancel: function () {
      alert("저장하지 않고 이 페이지를 벗어나면, 변경사항을 잃게 됩니다.");
      this.$emit("close-modal");
    },
    onSubmit: function (event) {
      event.preventDefault();
      if (
        this.comment.content == null ||
        this.comment.content == "" ||
        this.comment.content == "undefined"
      ) {
        alert("내용을 입력해주세요.");
        return;
      } else {
        axios
          .post(`http://j4b206.p.ssafy.io/api/comment`, this.comment, {
            headers: {
              Authorization: `jwt ${localStorage.getItem("jwt")}`,
            },
          })
          .then(() => {
            console.log("성공");
            localStorage.setitem("rating", 0);
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
  },
};
</script>

<style scoped>
.m-content {
  width: 100%;
  height: 380px;
  margin-top: 40px;
  z-index: 7;
  background-color: white;
}
input {
  width: 100%;
  height: 200px;
  text-align: center;
}
.btn {
  background-color: #345656;
}
</style>
