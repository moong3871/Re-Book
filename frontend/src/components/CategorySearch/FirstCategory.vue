<template>
  <div>
    <!-- first-category 선택하는 부분 -->
    <div
      class="first-category-container"
      style="height: 30px !important"
      v-if="domestic_count === 0"
    >
      <div
        style="
          width: 100%;
          height: 50px;
          font-family: 'Noto Serif KR', serif;
          font-size: 35px;
          padding-left: 15%;
        "
      >
        대분류를 선택해주세요
      </div>
    </div>
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
      <div class="result-category">카테고리 : {{ first_category }}</div>
      <div class="result-category" v-if="second_category !== ''">
        > {{ second_category }}
      </div>
      <div class="result-category" v-if="third_category.length !== 0">></div>
      <div
        class="result-category"
        v-for="(third, i) in third_category"
        :key="i"
      >
        {{ third }}
      </div>

      <!-- <div class="search-button-container">
        <button class="search-button">검색</button>
      </div> -->
    </div>

    <!-- 2nd depth 목록들 -->
    <div v-if="domestic_count === 1" class="second-category-container">
      <div
        style="
          width: 100%;
          height: 50px;
          font-family: 'Noto Serif KR', serif;
          font-size: 35px;
          padding-left: 3%;
          margin-bottom: 40px;
        "
      >
        중분류를 선택해주세요
      </div>
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
      <div
        style="
          width: 100%;
          height: 50px;
          font-family: 'Noto Serif KR', serif;
          font-size: 35px;
          padding-left: 3%;
          margin-bottom: 40px;
          min-width: 1100px;
        "
      >
        소분류를 선택(최대 3개)한 뒤, 검색을 눌러주세요
        <button class="search-button" @click="find_result">검색</button>
      </div>
      <div v-for="(thirdcategory, i) in third_categories" :key="i">
        <button
          class="third-category"
          @click="category_check(thirdcategory)"
          :style="{ color: back_colors[thirdcategory] }"
        >
          {{ thirdcategory }}
        </button>
      </div>
    </div>

    <!-- 여기서부터가 이제 마지막으로 최종 나오는 결과물 부분 -->
    <div v-if="domestic_count === 3" class="search-container">
      <div
        class="search-wrapper"
        v-for="(book, i) in categorized_books"
        :key="i"
      >
        <div class="image-box">
          <img :src="book.book_image_path" alt="" class="cover-image" />
        </div>
        <div class="title-box">
          <div class="title">
            {{ book.title }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import secondcategoryset from "@/assets/bookdata/second-category.json";
import allcategoryset from "@/assets/bookdata/categorystructure.json";
import allbookdatas from "@/assets/bookdata/bookdata.json";

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
      back_colors: {},
      categorized_books: [],
      allbookdatas: allbookdatas,
    };
  },
  computed: {
    final_back_colors() {
      return this.back_colors;
    },
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
      for (let i = 0; i < this.third_categories.length; i++) {
        this.back_colors[this.third_categories[i]] = "";
      }
      console.log(this.back_colors);
    },
    category_check(value) {
      console.log(value);
      if (this.third_category.includes(value)) {
        this.third_category.splice(this.third_category.indexOf(value), 1);
        console.log(this.third_category);
        this.back_colors[value] = "";
      } else if (this.third_category.length === 3) {
        alert("3개 초과로 선택하실 수 없습니다.");
      } else {
        this.third_category.push(value);
        this.back_colors[value] = "red";
        console.log(this.third_category);
        console.log(this.back_colors);
      }
    },
    find_result() {
      if (this.third_category.length === 0) {
        alert("소분류를 선택해주세요!");
      } else {
        this.domestic_count++;
        this.categorized_books = this.allbookdatas.filter((data) => {
          // return data.title.replace(/ /g, "").includes(this.keyword);
          return this.third_category.includes(data.subcategory);
        });
        console.log(this.categorized_books);
      }
    },
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@500&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Jua&display=swap");

.first-category-container {
  margin-left: 13%;
  width: 74%;
  height: 160px;
  margin-top: 10px;
  display: flex;
  align-items: center;
}
.result-container {
  margin-left: 13%;
  width: 80%;
  /* background-color: rgb(112, 153, 240); */
  border-bottom: 2px solid green;
  min-width: 1700px;
  height: 100px;
  animation: fadein 1s;
  display: flex;
  align-items: center;
  padding: 20px;
  margin-bottom: 30px;
  font-family: "Jua", sans-serif;
}
.result-category {
  margin-right: 20px;
  float: left;
  height: 40px;
  font-size: 30px;
  animation: fadein 1s;
}
.search-button-container {
  position: relative;
  /* float: right; */
  width: 100px;
  height: 100px;
  top: 30px;
  left: 8%;
}
.search-button {
  width: 150px;
  /* border: 3px solid rgb(103, 167, 112); */
  background-color: rgb(121, 174, 187);
  margin-left: 10%;
  border-radius: 10px;
  height: 60px;
  color: white;
}
.search-button:hover {
  background-color: rgb(23, 90, 107);
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
.third-category:hover {
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
  margin-left: 15%;
  width: 70%;
  height: 200px;
  animation: fadein 1s;
  /* background-color: red; */
}
.third-category {
  background-color: white;
  height: 50px;
  width: 250px;
  margin: 0.5%;
  /* display: inline-flex; */
  float: left;
  font-size: 20px;
  font-family: "Do Hyeon", sans-serif;
  border: 1px solid rgb(241, 232, 232);
  border-radius: 20px;
}
.search-container {
  /* background-color: beige; */
  width: 90vw;
  min-width: 1500px;
  margin-left: 5vw;
  height: 1500px;
  animation: fadein 1.5s;
}
.search-wrapper {
  width: 17%;
  border-radius: 15px;
  min-width: 300px;
  max-width: 380px;
  margin: 1.5%;
  height: 500px;
  background-color: white;
  float: left;
  box-shadow: 0 1.4px 1.7px rgba(0, 0, 0, 0.017),
    0 3.3px 4px rgba(0, 0, 0, 0.024), 0 6.3px 7.5px rgba(0, 0, 0, 0.1),
    0 11.2px 13.4px rgba(0, 0, 0, 0.3), 0 20.9px 25.1px rgba(0, 0, 0, 0.2),
    0 50px 60px rgba(0, 0, 0, 0.06);
}
.image-box {
  display: flex;
  justify-content: center;
  width: 100%;
  height: 80%;
  border-bottom: 2px solid brown;
  background-color: beige;
}
.cover-image {
  height: 100%;
  max-width: 95%;
  /* border: 1px solid black; */
}
.title-box {
  background-color: rgb(241, 241, 207);
  height: 20%;
  border-bottom-left-radius: 15px;
  border-bottom-right-radius: 15px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 5px;
}
.title {
  font-size: 18px;
  text-align: center;
  font-family: "Noto Serif KR", serif;
  max-height: 100%;
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
