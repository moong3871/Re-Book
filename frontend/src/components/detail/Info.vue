<template>
  <div>
    <div class="b-img-box">
      <img class="b-img" :src="dummy.profileimg_path" alt="책 이미지" />
    </div>
    <div class="info-container">
      <div class="s-img-box">
        <img class="s-img" :src="dummy.profileimg_path" alt="책 이미지" />
      </div>
      <div class="info-box-right">
        <h2>{{ dummy.title }}</h2>
        <p>작 가: {{ dummy.author }}</p>
        <p>출판사: {{ dummy.company }}</p>
        <p>정 가: {{ dummy.price }}원</p>
        <p>평 균: {{ dummy.grade }}</p>
      </div>
    </div>
    <hr />
    <div class="desc-container">
      <div class="desc-box">
        <h3 class="d-title">책 소개</h3>
        <p class="d-content">{{ dummy.desc }}</p>
      </div>
      <div class="desc-box">
        <h3 class="d-title">저자 소개</h3>
        <div class="d-content">
          <p>{{ dummy.author }}</p>
          <p>{{ dummy.desc }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Info",
  props: {
    dummy: Object,
  },
  data() {
    return {};
  },
};
</script>

<style scoped>
.b-img-box {
  width: 100%;
  height: 40%;
  display: flex;
  justify-content: center;
  background-color: #445b54;
  margin: 1rem 0 3rem;
  padding: 2.5%;
}
.b-img {
  width: 445px;
  height: 656px;
}
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
