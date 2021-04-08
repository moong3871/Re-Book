<template>
  <v-container>
    <v-row class="info">
      <v-col md="8">
        <Calendar></Calendar>
      </v-col>
      <v-col md="3" offset-md="1">
        <Progress />
      </v-col>
    </v-row>
    <h3>테스형님이 읽고 싶은 책</h3>
    <BookHover
      :book="{
        title: '회복탄력성',
        src: 'http://image.yes24.com/momo/TopCate2227/MidCate003/222620895.jpg',
      }"
    />
    <h3>테스형님이 읽고 있는 책</h3>
    <BookHover />
    <h3>테스형님이 읽은 책</h3>
    <BookHover />
  </v-container>
</template>

<script>
// import Bookshelf from "@/components/library/Bookshelf.vue";
import BookHover from "@/components/library/BookHover.vue";
import Progress from "@/components/library/Progress.vue";
import Calendar from "@/components/library/Calendar.vue";
import axios from "axios";

export default {
  name: "UserPage",
  components: {
    BookHover,
    Progress,
    Calendar,
  },
  methods: {
    getAccountInfo() {
      axios
        .get("https://j4b206.p.ssafy.io/api/account/sbs%40ssafy.com")
        .then((res) => {
          var data = JSON.parse(res.data.data);
          console.log(data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {
    this.getAccountInfo();
  },
};
</script>

<style scoped>
.info {
  margin: 30px 0;
}

.container {
  max-width: 1200px;
}
</style>
