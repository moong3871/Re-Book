<template>
  <div>
    <!-- first-category 선택하는 부분 -->
    <div class="first-category-container" v-if="domestic_count === 0">
      <button
        class="first-category"
        style="margin-right: 10%; margin-left: 15%"
        @click="finddomestic"
        :style="{ background: first_category_color }"
      >
        한글도서
      </button>
      <button
        class="first-category"
        style="margin-right: 10%"
        @click="findforeign"
      >
        외국어도서
      </button>
    </div>
    <!-- 1st depth 선택 후 나타는 부분 -->
    <div class="result-container" v-if="domestic_count !== 0">
      <div class="result-category">{{ first_category }}</div>
      <div class="result-category" v-if="second_category !== ''">
        > {{ second_category }}
      </div>
      <div class="search-button-container">
        <button class="search-button">검색</button>
      </div>
    </div>

    <!-- 2nd depth 목록들 -->
    <div v-if="domestic_count === 1" class="second-category-container">
      <div v-for="(secondcategory, i) in second_categories" :key="i" :data="i">
        <button
          class="second-category"
          @click="determine_second(secondcategory)"
        >
          {{ secondcategory }}
        </button>
      </div>
    </div>

    <!-- 3rd depth 목록들 -->
    <div v-if="domestic_count === 2" class="third-category-container">
      <div v-for="(thirdcategory, i) in third_categories" :key="i">
        <button class="third-category" @click="category_search">
          {{ thirdcategory }}
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import secondcategoryset from "@/assets/bookdata/second-category.json";
import allcategoryset from "@/assets/bookdata/categorystructure.json";
export default {
  data() {
    return {
      secondcategoryset: secondcategoryset,
      first_category: "",
      second_categories: [],
      second_category: "",
      domestic_count: 0,
      foreign_count: 0,
      first_category_color: "",
      third_categories: [],
      third_category: [],
      allcategoryset: allcategoryset,
    };
  },
  methods: {
    finddomestic() {
      this.second_categories = this.secondcategoryset.국내도서;
      this.first_category = "한글도서";
      this.domestic_count++;
    },
    findforeign() {
      this.second_categories = this.secondcategoryset.외국도서;
      this.first_category = "외국어도서";
      this.domestic_count++;
    },
    determine_second(value) {
      this.second_category = value;
      this.domestic_count++;
      if (this.first_category === "한글도서") {
        this.third_categories = this.allcategoryset.국내도서[
          this.second_category
        ];
      } else {
        this.third_categories = this.allcategoryset.외국도서[
          this.second_category
        ];
      }
    },
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap");

.first-category-container {
  margin-left: 20%;
  width: 60%;
  /* background-color: chartreuse; */
  height: 160px;
  margin-top: 10px;
  display: flex;
  align-items: center;
  /* border-bottom: 3px solid black; */
}
.result-container {
  margin-left: 20%;
  width: 60%;
  background-color: red;
  height: 100px;
  animation: fadein 1s;
  display: flex;
  align-items: center;
  padding: 20px;
  margin-bottom: 30px;
}
.result-category {
  margin-right: 15px;
  float: left;
  height: 40px;
  font-size: 32px;
  animation: fadein 1s;
}
.search-button-container {
  position: absolute;
  /* float: right; */
  top: 230px;
  left: 70vw;
}
.first-category {
  background-color: white;
  height: 70px;
  width: 30%;
  font-size: 40px;
  font-family: "Do Hyeon", sans-serif;
  border: 1px solid rgb(241, 232, 232);
  border-radius: 20px;
}
.first-category:hover {
  background-color: rgb(114, 166, 201);
}
.second-category:hover {
  background-color: rgb(114, 166, 201);
}
.second-category-container {
  margin-left: 20%;
  width: 60%;
  height: 200px;
  animation: fadein 1s;
}
.second-category {
  background-color: white;
  height: 50px;
  width: 200px;
  margin: 0.5%;
  /* display: inline-flex; */
  float: left;
  font-size: 20px;
  font-family: "Do Hyeon", sans-serif;
  border: 1px solid rgb(241, 232, 232);
  border-radius: 20px;
}
.third-category-container {
  margin-left: 20%;
  width: 60%;
  height: 200px;
  animation: fadein 1s;
  /* background-color: red; */
}
.third-category {
  background-color: white;
  height: 50px;
  width: 200px;
  margin: 0.5%;
  /* display: inline-flex; */
  float: left;
  font-size: 20px;
  font-family: "Do Hyeon", sans-serif;
  border: 1px solid rgb(241, 232, 232);
  border-radius: 20px;
}
@keyframes fadein {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
</style>
