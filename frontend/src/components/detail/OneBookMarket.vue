<template>
  <div>
    <div class="o-header">
      <h3 class="o-title">당근서점에서 찾아보기</h3>
      <Button :title="title" />
    </div>
    <Map />
  </div>
</template>

<script>
import Button from "./Button.vue";
import Map from "./Map.vue";
export default {
  name: "OneBookMarket",
  components: {
    Button,
    Map,
  },
  data() {
    return {
      title: "+ 당근서점에 등록하기",
    };
  },
};
</script>

<style scoped>
.o-header {
  width: 100%;
  display: flex;
  justify-content: space-between;
  margin: 1rem;
}
.o-title {
  font-size: 30px;
}
</style>
