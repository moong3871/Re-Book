<template>
  <div class="m-content">
    <input
      type="text"
      placeholder="이 작품에 대한 생각을 자유롭게 표현해주세요."
    />
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.m-content {
  width: 100%;
  height: 380px;
  margin-top: 40px;
  z-index: 10;
  background-color: white;
}
input {
  width: 100%;
  height: 100%;
  /* background-color: thistle; */
  vertical-align: top;
}
input::placeholder {
  color: blue;
  vertical-align: top;
}
</style>
