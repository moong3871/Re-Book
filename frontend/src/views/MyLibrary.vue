<template>
  <div>
    <h3>책벌레님의 책 달력</h3>
    <BookCover />
    <Progress />
    <h3>책벌레님이 읽고 싶은 책</h3>
    <Bookshelf />
    <h3>책벌레님이 읽고 있는 책</h3>
    <Bookshelf />
    <h3>책벌레님이 읽은 책</h3>
    <h3></h3>
  </div>
</template>

<script>
import Bookshelf from "@/components/library/Bookshelf.vue";
import Progress from "@/components/library/Progress.vue";
export default {
  name: "MyLibrary",
  components: {
    Bookshelf,
    Progress,
  },
};
</script>

<style></style>
