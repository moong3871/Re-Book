<template>
  <div>
    <div class="preference-bg">
      <div class="preference-header">
        <img src="@/assets/images/REBOOK-removebg.png" class="login-logo" />
      </div>
      <div class="description-container">
        <div class="description">10개 이상의 작품에 대한 평가를 해주세요.</div>
        <div class="description">
          이를 기반으로 RE:BOOK이 책을 추천해 드릴게요!
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic:wght@700&display=swap");
.preference-bg {
  width: 100vw;
  height: 100%;
  background-color: beige;
  padding-top: 7%;
  /* background-image: url("https://media.wired.com/photos/5e666c01ac94e900085c0f3d/master/w_2560%2Cc_limit/Biz-books-174638658.jpg");
  background-size: cover; */
}
.preference-header {
  width: 100%;
  height: 7%;
  background-color: rgba(199, 192, 157, 0.5);
  position: fixed;
  top: 0;
}
.login-logo {
  height: 100%;
  position: absolute;
  top: 0;
}
.description-container {
  /* font-family: "Nanum Gothic", sans-serif; */
  font-family: "Do Hyeon", sans-serif;
  height: 500px;
}
.description {
  font-size: 25px;
  margin: 0 auto;
  text-align: center;
}
</style>
