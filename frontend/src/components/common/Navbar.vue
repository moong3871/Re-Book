<template>
  <div class="nav">
    <v-app id="header" style="height: 180px">
      <div class="top-header">
        <div class="logo" @click="toHome">
          <img src="@/assets/images/logo.png" style="height: 60px" />
        </div>
        <div class="myinfo-container">
          <div class="hello-user-container">
            <div class="hello-user">박성준님 환영합니다.</div>
          </div>
          <div class="profile-container">
            <v-avatar
              class="my-profile"
              color="green"
              size="50px"
              @click="toMyInfo"
            >
              <v-icon dark size="48px"> mdi-account-circle </v-icon>
            </v-avatar>
          </div>
        </div>
      </div>

      <div class="navbar-container">
        <div class="tab-container">
          <div
            class="tab"
            v-for="(tab, i) in tabItems"
            :key="i"
            @click="$router.push(tab.path)"
          >
            <div class="tab-text">
              {{ tab.title }}
            </div>
          </div>
        </div>
        <div class="search">
          <div class="search-box">
            <input
              type="text"
              class="searchTerm"
              placeholder="  원하는 책을 검색해주세요"
              v-model="bookSearch"
              @keyup.enter="search"
            />
            <button type="submit" class="searchButton">
              <font-awesome-icon
                icon="search"
                style="height: 32px; width: 32px"
                color="white"
                height="30"
                @click="search"
              />
            </button>
          </div>
        </div>
      </div>
    </v-app>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      bookSearch: "",
      clicked: false,
      tabItems: [
        { title: "사이트소개", path: "/about" },
        { title: "카테고리", path: "/category" },
        { title: "장터", path: "/market" },
        { title: "내 서재", path: "/mylibrary" },
      ],
    };
  },
  methods: {
    toHome() {
      this.$router.push("/home");
    },
    search() {
      if (this.bookSearch.length < 2) {
        alert("2글자 이상으로 입력해주세요!");
      } else {
        this.$router.push({
          name: "BookSearch",
          query: { keyword: this.bookSearch },
        });
        location.reload();
      }
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap");
#header {
  /* position: fixed; */
  top: 0px;
}
.top-header {
  width: 100vw;
  height: 70px;
  display: flex;
  align-items: center;
  border: 1px solid black;
  /* position: fixed; */
  background-color: white;
}
.logo {
  margin-left: 50px;
  display: flex;
  align-items: center;
  float: left;
  /* height: 110px; */
}
.logo:hover {
  cursor: pointer;
}
.myinfo-container {
  height: 80%;
  display: flex;
  align-items: center;
  /* float: right; */
  /* width: 1200px; */
  margin-left: auto;
  padding-right: 5vw;
}
.hello-user-container {
  display: flex;
  align-items: center;
  float: right;
  margin-left: auto;
  /* margin-left: 75vw; */
  height: 100%;
  width: 250px;
}
.hello-user {
  font-family: "Nanum Gothic", sans-serif;
  font-size: 24px;
  width: 250px;
  /* border: 3px solid blue; */
}
.navbar-container {
  background-color: #345656;
  height: 80px;
  min-width: 1600px;
}
.tab-container {
  height: 100%;
  width: 40vw;
  min-width: 600px;
  margin-left: 5vw;
  float: left;
}
.tab {
  height: 100%;
  width: 10vw;
  min-width: 150px;
  float: left;
  display: flex;
  align-items: center;
  justify-content: center;
}
.tab:hover {
  background-color: rgb(2, 119, 94);
  cursor: pointer;
}
.tab-text {
  text-align: center;
  font-family: "Nanum Gothic", sans-serif;
  font-size: 27px;
  color: white;
}
.search {
  height: 100%;
  float: left;
  display: flex;
  align-items: center;
  margin-left: 10vw;
  /* background-color: red; */
  width: 40vw;
  min-width: 500px;
}
.search-box {
  float: left;
  width: 1000px;
  min-width: 500px;
  height: 75%;
  display: flex;
  align-items: center;
  /* background-color: red; */
}

.searchTerm {
  width: 70%;
  /* border: 3px solid black; */
  border-right: none;
  padding: 5px;
  height: 50px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9dbfaf;
  background-color: #1b6844;
  transition-property: background-color, width;
  transition-duration: 0.7s;
  color: black;
  font-size: 24px;
}
.searchTerm::placeholder {
  color: white;
  font-size: 18px;
}

.searchTerm:focus {
  background-color: rgb(142, 187, 142);
  width: 80%;
}

.searchButton {
  width: 50px;
  height: 50px;
  /* border: 1px solid wh; */
  background: black;
  text-align: center;
  border-radius: 0 10px 10px 0;
  cursor: pointer;
}
</style>
