<template>
  <div class="container">
    <!-- <a href="http://localhost:8081/oauth2/authorization/google">Google Login</a> -->
    <Cover :book="book" />
    <Info :dummy="dummy" :book="book" />
    <hr />
    <Comment
      :dummy="dummy"
      :backDummy="backDummy"
      @open-modal="isModal = true"
    />
    <Modal v-if="isModal" @close-modal="isModal = false" :dummy="dummy">
      <ModalContent />
    </Modal>
    <hr />
    <Recommend :dummy="dummy" :backDummy="backDummy" />
    <hr />
    <Library :dummy="dummy" :backDummy="backDummy" />
    <hr />
    <OneBookMarket :dummy="dummy" :backDummy="backDummy" />
    <hr />
  </div>
</template>

<script>
import axios from "axios";
import Cover from "@/components/detail/Cover.vue";
import Info from "@/components/detail/Info.vue";
import Comment from "@/components/detail/Comment.vue";
import Recommend from "@/components/detail/Recommend.vue";
import Library from "@/components/detail/Library.vue";
import OneBookMarket from "@/components/detail/OneBookMarket.vue";
import Modal from "@/components/detail/Modal.vue";
import ModalContent from "@/components/detail/ModalContent.vue";
export default {
  name: "Detal",
  components: {
    Cover,
    Info,
    Comment,
    Recommend,
    Library,
    OneBookMarket,
    Modal,
    ModalContent,
  },
  props: {
    book: Object,
  },
  data() {
    return {
      isModal: false,
      backDummy: null,
      dummy: {
        user_id: 1,
        comments: [
          {
            id: 1,
            nickname: "북유럽",
            rating: 3.5,
            review:
              "시기적으로 나에게 필요한 책이었다 논리가 때로 조금 어설프고 다듬어지지 않은 느낌도 들엇으나 한번씩 와닿는 문장들에 충분히 위로 받았다.",
          },
          {
            id: 2,
            nickname: "오마이걸",
            rating: 3.5,
            review:
              "처음에 인스타를 통해 감정적인 소모로 인한 저의 마음을 잘 정리된 피드로 위로를 많이 받았어요",
          },
        ],
        librarys: [
          {
            library: "구암 도서관",
            stock: 2,
            telephone: "042 - 601 - 6630",
            address: "대전광역시 유성구 구암동 128",
          },
          {
            library: "유성 도서관",
            stock: 1,
            telephone: "042 - 601 - 6630",
            address: "대전광역시 유성구 구암동 128",
          },
          {
            library: "문정 도서관",
            stock: 1,
            telephone: "042 - 601 - 6630",
            address: "대전광역시 유성구 구암동 128",
          },
          {
            library: "석범 도서관",
            stock: 1,
            telephone: "042 - 601 - 6630",
            address: "대전광역시 유성구 구암동 128",
          },
        ],
      },
    };
  },
  created() {
    var ISBN = this.$route.params.book.isbn;
    console.log("안녕하세요 isbn입니다");
    console.log(ISBN);
    axios({
      //url: "http://localhost:8080/book/8954655971",
      url: "http://j4b206.p.ssafy.io/book/" + ISBN,
      method: "GET",
      // headers: {
      //   Authorization: `JWT ${localStorage.getItem("jwt")}`,
      // },
    })
      .then((res) => {
        console.log(`=================책detail응답 ${res.data.object}`);
        this.backDummy = res.data.object;
        console.log("@@@@@@@@@@@@@BackDummy");
        console.log(this.backDummy);
      })
      .catch((err) => {
        console.log("@@@@@@@@@@@@@@@@@@@책detail응답 에러");
        console.error(err);
      });
  },
};
</script>
<style scoped>
.container {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
