<template>
  <div class="container">
    <!-- <a href="http://localhost:8081/oauth2/authorization/google">Google Login</a> -->
    <Cover :book="book" />
    <Info
      :detailBookInfo="detailBookInfo"
      :book="book"
      @changeStatus="changeStatus"
      @openCommentModal="openCommentModal"
    />
    <hr />
    <Comment :detailBookInfo="detailBookInfo" @open-modal="isModal = true" />
    <Modal
      v-if="isModal"
      @close-modal="isModal = false"
      :detailBookInfo="detailBookInfo"
      :book="book"
    />
    <!-- <ModalContent @close-modal="this.$emit('close-modal')"/>
    </Modal> -->
    <hr />
    <Recommend :detailBookInfo="detailBookInfo" />
    <hr />
    <OneBookMarket
      :detailBookInfo="detailBookInfo"
      @open-Mmodal="isMModal = true"
    />
    <hr />
    <MarketModal
      v-if="isMModal"
      @close-modal="isMModal = false"
      :detailBookInfo="detailBookInfo"
      :book="book"
    />
    <br />
    <input type="text" id="sample4_postcode" placeholder="우편번호" />
    <input
      type="button"
      @click="sample4_execDaumPostcode"
      value="우편번호 찾기"
    /><br />
    <input type="text" id="sample4_roadAddress" placeholder="도로명주소" />
    <input type="text" id="sample4_jibunAddress" placeholder="지번주소" />
    <span id="guide" style="color: #999; display: none"></span>
    <input type="text" id="sample4_detailAddress" placeholder="상세주소" />
    <input type="text" id="sample4_extraAddress" placeholder="참고항목" />
  </div>
</template>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
import axios from "axios";
import Cover from "@/components/detail/Cover.vue";
import Info from "@/components/detail/Info.vue";
import Comment from "@/components/detail/Comment.vue";
import Recommend from "@/components/detail/Recommend.vue";
import OneBookMarket from "@/components/detail/OneBookMarket.vue";
import MarketModal from "@/components/detail/MarketModal.vue";
import Modal from "@/components/detail/Modal.vue";
import bookdata from "@/assets/bookdata/bookdata.json";

export default {
  name: "Detail",
  components: {
    Cover,
    Info,
    Comment,
    Recommend,
    OneBookMarket,
    MarketModal,
    Modal,
  },
  props: {
    // book: Object,
  },
  data() {
    return {
      bookdata: bookdata,
      isModal: false,
      isMModal: false,
      book: null,
      detailBookInfo: null,
      isbn: this.$route.query.isbn,
    };
  },
  methods: {
    changeStatus: function (status) {
      // var ISBN = this.$route.params.book.isbn;
      const email = localStorage.getItem("email");
      axios
        .put(
          `http://j4b206.p.ssafy.io/api/book/${email}`,
          {
            userToken: localStorage.getItem("jwt"),
            status: status,
            book: this.book,
          },
          {
            headers: {
              Authorization: `jwt ${localStorage.getItem("jwt")}`,
            },
          }
        )
        .then(() => {
          console.log("성공");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    openCommentModal() {
      this.isModal = true;
    },
    // searchAddress: function () {
    //   new daum.Postcode({
    //     oncomplete: function (data) {
    //       var addr = data.addr;
    //       console.log("------------------------");
    //       console.log(addr);
    //       let temp = document.getElementById("testButton");

    //       // this.form.address = address;
    //       // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
    //       // 예제를 참고하여 다양한 활용법을 확인해 보세요.
    //     },
    //   }).open();
    // },
    sample4_execDaumPostcode: function () {
      new daum.Postcode({
        oncomplete: function (data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var roadAddr = data.roadAddress; // 도로명 주소 변수
          var extraRoadAddr = ""; // 참고 항목 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== "" && data.apartment === "Y") {
            extraRoadAddr +=
              extraRoadAddr !== ""
                ? ", " + data.buildingName
                : data.buildingName;
          }
          // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraRoadAddr !== "") {
            extraRoadAddr = " (" + extraRoadAddr + ")";
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById("sample4_postcode").value = data.zonecode;
          document.getElementById("sample4_roadAddress").value = roadAddr;
          document.getElementById("sample4_jibunAddress").value =
            data.jibunAddress;

          // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
          if (roadAddr !== "") {
            document.getElementById(
              "sample4_extraAddress"
            ).value = extraRoadAddr;
          } else {
            document.getElementById("sample4_extraAddress").value = "";
          }

          var guideTextBox = document.getElementById("guide");
          // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
          if (data.autoRoadAddress) {
            var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
            guideTextBox.innerHTML = "(예상 도로명 주소 : " + expRoadAddr + ")";
            guideTextBox.style.display = "block";
          } else if (data.autoJibunAddress) {
            var expJibunAddr = data.autoJibunAddress;
            guideTextBox.innerHTML = "(예상 지번 주소 : " + expJibunAddr + ")";
            guideTextBox.style.display = "block";
          } else {
            guideTextBox.innerHTML = "";
            guideTextBox.style.display = "none";
          }
        },
      }).open();
    },
  },
  created() {
    var temp = this.bookdata.filter((data) => {
      return data.isbn.includes(this.isbn);
    });
    this.book = temp[0];
    axios
      .get(`http://j4b206.p.ssafy.io/api/book/${this.isbn}`, {
        userToken: localStorage.getItem("jwt"),
      })
      .then((res) => {
        console.log(`=================책detail응답 ${res.data.object}`);
        this.detailBookInfo = res.data.object;
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
