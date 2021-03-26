<template>
  <div>
    <router-link :to="{ name: 'Detail', params: { ISBN: dummy.ISBN } }"
      ><h1>{{ dummy.title }}</h1></router-link
    >
  </div>
  <!-- <div class="temp" @click="getDetail()">{{ dummy.title }}</div> -->
</template>

<script>
// import { getDetail } from "@/api/book.js";
// import axios from "axios";

export default {
  name: "Temp",
  data() {
    return {
      dummy: {
        title: "질서너머",
        ISBN: "9788901249872",
      },
      // backDummy: null,
    };
  },
  methods: {
    // getDetail(
    //   ISBN,
    //   (response) => {
    //     this.backDummy = response.object;
    //     console.log(backDummy);
    //     this.$router.push({ name: "Detail" });
    //   },
    //   (error) => {
    //     console.error(error);
    //   }
    // );
    // getDetail(e) {
    //   console.log(e);
    //   axios({
    //     // url: `http://localhost:8080/book/${this.dummy.ISBN}/`,
    //     url: `http://j4b206.p.ssafy.io/book/${this.dummy.ISBN}`,
    //     method: "GET",
    //   })
    //     .then((res) => {
    //       console.log(`=================책detail응답 ${res.object}`);
    //       this.backDummy = res.object;
    //       this.$router.push({ name: "Detail" });
    //     })
    //     .catch((err) => {
    //       console.log("@@@@@@@@@@@@@@@@@@@책detail응답 에러");
    //       console.error(err);
    //     });
    // },
  },
};
</script>

<style>
.temp {
  background-color: teal;
}
</style>
