<template>
  <div class="container">
    <div class="c-header">
      <h3>코멘트</h3>
      <button>+코멘트 남기기</button>
    </div>
    <li class="item">
      <CommentItem />
    </li>
  </div>
</template>

<script>
import CommentItem from "./CommentItem.vue";
export default {
  name: "Comment",
  components: {
    CommentItem,
  },
  props: {
    dummy: Object,
  },
};
</script>

<style scoped>
.container {
  width: 100%;
  display: inline-block;
  text-align: center;
  font-size: 30px;
  margin: 0 auto;
  background-color: blue;
}
/* .c-header {
  display: flex;
  justify-content: space-between;
}
.li {
}
.item {
  display: block;
} */
</style>
