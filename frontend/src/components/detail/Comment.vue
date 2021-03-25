<template>
  <div class="container">
    <div class="c-header">
      <h3>코멘트</h3>
      <Button />
    </div>
    <ul
      class="item"
      v-for="(comment, index) in dummy.comments"
      v-bind:key="index"
    >
      <CommentItem :comment="comment" />
    </ul>
  </div>
</template>

<script>
import Button from "./Button.vue";
import CommentItem from "./CommentItem.vue";
export default {
  name: "Comment",
  components: {
    Button,
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
  /* background-color: yellow; */
}
.c-header {
  width: 100%;
  display: flex;
  justify-content: space-between;
  margin: 1rem;
  /* background-color: red; */
}
ul {
  list-style: none;
}
.item {
  display: block;
}
</style>
