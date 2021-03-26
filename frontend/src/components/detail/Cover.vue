<template>
  <div class="b-img-box">
    <img class="b-img" :src="backDummy.bookImagePath" alt="책 이미지" />
  </div>
</template>

<script>
export default {
  name: "Cover",
  props: {
    backDummy: Object,
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
</style>
