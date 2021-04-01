<template>
  <div class="container">
    <div class="c-header">
      <h3>코멘트</h3>
      <div class="btn-box" @click="$emit('open-modal')">
        <Button :title="title" />
      </div>
    </div>
    <!-- 나중에 아래부분 backDummy로 바꾸기 -->
    <div v-if="dummy.comments == null" class="item">
      아직 코멘트가 없습니다.
    </div>
    <div v-else>
      <ul
        class="item"
        v-for="(comment, index) in dummy.comments"
        v-bind:key="index"
      >
        <!-- <ul
        class="item"
        v-for="(comment, index) in backDummy.comments"
        v-bind:key="index"
      > -->
        <CommentItem :comment="comment" />
      </ul>
    </div>
    <!-- 나중에 아래부분 backDummy로 바꾸기 -->
    <div v-if="dummy.comments == null" class="item">
      아직 코멘트가 없습니다.
    </div>
    <div v-else>
      <ul
        class="item"
        v-for="(comment, index) in dummy.comments"
        v-bind:key="index"
      >
        <!-- <ul
        class="item"
        v-for="(comment, index) in backDummy.comments"
        v-bind:key="index"
      > -->
        <CommentItem :comment="comment" />
      </ul>
    </div>
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
    backDummy: Object,
  },
  data() {
    return {
      title: "+ 코멘트 남기기",
    };
  },
  methods: {
    openModal: function () {
      this.$emit("open-modal");
    },
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
.btn-box {
  background-color: red;
}
</style>
