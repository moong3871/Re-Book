<template>
  <div
    class="overlay"
    @click.self="$emit('close-modal')"
    @close-modal="$emit('close-modal')"
  >
    <div class="modal-card">
      <p class="c-title">장터에 책 등록하기</p>
      <div class="m-content">
        <div class="m-img">
          <img :src="this.book.book_image_path" alt="책표지" class="m-img" />
        </div>
        <div class="m-info">
          <form class="form">
            <div class="status">
              책상태:
              <label for="status"
                >상
                <input
                  id="status"
                  type="radio"
                  name="status"
                  value="0"
                  v-model="form.status"
                />
              </label>
              <label for="status"
                >중
                <input
                  id="status"
                  type="radio"
                  name="status"
                  value="1"
                  v-model="form.status"
                />
              </label>
              <label for="status"
                >하
                <input
                  id="status"
                  type="radio"
                  name="status"
                  value="2"
                  v-model="form.status"
                />
              </label>
            </div>
            <div class="price">
              <label for="price">가격: </label>
              <input
                type="number"
                id="price"
                name="price"
                v-model="form.price"
              />
            </div>
            <div class="address">
              <!-- <p>주소 :</p>
              <button type="button" @click="searchAddress">주소 검색</button> -->
              <label for="address">직거래 장소: </label>
              <input
                type="text"
                id="address"
                name="address"
                placeholder="주소를 입력해주세요"
                @click="searchAddress"
              />
            </div>
            <div class="desc">
              <label for="desc">상세설명: </label>
              <input
                type="text"
                id="desc"
                name="desc"
                v-model="form.description"
              />
            </div>
          </form>
        </div>
      </div>
      <button class="btn" type="button" @click="onSubmit">저장</button>
      <button class="btn" @click="cancel">취소</button>
    </div>
  </div>
</template>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
  type="text/javascript"
  src="//dapi.kakao.com/v2/maps/sdk.js?appkey=96d25cdceea12f75a73fe83bd3348112&libraries=services"
></script>

<script>
import axios from "axios";
// import Button from "./Button.vue";
export default {
  // components: { Button },
  props: {
    detailBookInfo: Object,
    book: Object,
  },
  data() {
    return {
      form: {
        id: 0, // 나중에 지우기
        address: "",
        bookImagePath: this.book.book_image_path,
        bookPhoto: "", // 나중에 지우기
        description: "",
        isbn: this.book.isbn,
        lat: "0",
        lng: "0",
        price: 0,
        status: 0,
        title: this.book.title,
        userId: localStorage.getItem("email"),
      },
    };
  },
  methods: {
    cancel: function () {
      alert("저장하지 않고 이 페이지를 벗어나면, 변경사항을 잃게 됩니다.");
      this.$emit("close-modal");
    },
    onSubmit: function () {
      this.form.address = document.getElementById("address").value;
      console.log(this.form);
      axios
        .post(`https://j4b206.p.ssafy.io/api/yangsangchu`, this.form, {
          // .post(`http://localhost:8080/api/yangsangchu`, this.form, {
          headers: {
            Authorization: `jwt ${localStorage.getItem("jwt")}`,
          },
        })
        .then(() => {
          console.log("성공");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    searchAddress: function () {
      //주소-좌표 변환 객체를 생성
      let geocoder = new kakao.maps.services.Geocoder();
      new daum.Postcode({
        oncomplete: function (data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드
          let address = document.getElementById("address");
          address.value = data.address;
          // 주소 -> 좌표 변환
          geocoder.addressSearch(data.address, function (results, status) {
            if (status === daum.maps.services.Status.OK) {
              var result = results[0]; //첫번째 결과의 값을 활용

              // 해당 주소에 대한 좌표를 받기
              var coords = new daum.maps.LatLng(result.y, result.x);
              console.log(coords);
            } else {
              console.log("주소 좌표변환 실패");
            }
          });
        },
      }).open();
    },
  },
};
</script>

<style scoped>
.overlay {
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
  background: rgba(0, 0, 0, 0.5);
  z-index: 5;
}
.modal-card {
  position: relative;
  max-width: 40%;
  margin: auto;
  margin-top: 80px;
  padding: 40px;
  background-color: #345656;
  min-height: 500px;
  z-index: 6;
  color: white;
  text-align: center;
}
.c-title {
  font-size: 2rem;
}
.m-content {
  width: 100%;
  height: 380px;
  margin-top: 40px;
  z-index: 7;
  background-color: white;
  display: flex;
  justify-content: center;
}

.btn {
  background-color: #345656;
}
.form {
  color: black;
}
.condition {
  display: flex;
  align-content: center;
}
</style>
