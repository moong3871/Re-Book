<template>
  <v-container>
    <v-row class="info">
      <v-col md="8">
        <Calendar :books="books"></Calendar>
      </v-col>
      <v-col md="3" offset-md="1">
        <Progress />
      </v-col>
    </v-row>
    <h3>테스형님이 읽고 싶은 책</h3>
    <div v-for="book in books" :key="book.id">
      <BookHover :book="book" />
    </div>
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
  data() {
    return {
      books: [],
    };
  },
  components: {
    BookHover,
    Progress,
    Calendar,
  },
  methods: {
    getAccountInfo() {
      axios
        .get("https://j4b206.p.ssafy.io/api/account/ssafy1617@ssafy.com")
        .then((res) => {
          var data = JSON.parse(res.data.data);
          this.books = data;
          // var t_date = new Date(this.books[0].createDate);

          console.log(this.books);
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
