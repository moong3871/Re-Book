<template>
  <div>
    <div class="category-container">
      <div class="big-category-container">
        <!-- <div class="big-category">한글도서</div> -->
        <!-- <div class="big-category">외국어도서</div> -->
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.category-container {
  width: 100vw;
}
.big-category-container {
  width: 40vw;
  margin-left: 30vw;
  height: 70px;
  background-color: gray;
}
.big-category-container:hover {
  cursor: pointer;
}
.big-category {
  background-color: green;
  /* transition-property: background-color; */
  /* transition-duration: 1s; */
}
.big-category:hover {
  width: 200px;
  cursor: pointer;
}
</style>
