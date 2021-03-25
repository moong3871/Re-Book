<template>
  <div class="nav">
    <v-app id="header" style="height: 240px">
      <div class="top-header">
        <div class="logo" @click="toHome">
          <img src="@/assets/images/logo.png" style="height: 110px" />
        </div>
        <div class="hello-user-container">
          <div class="hello-user">박성준님 환영합니다.</div>
        </div>
        <div class="profile-container" style="margin-left: 30px">
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
      <!-- 여기까지가 top-header -->
      <div>
        <v-app-bar class="navbar" color="#345656" height="100px" width="100vw">
          <v-tabs class="tabs" style="margin-left: 50px">
            <v-tab
              v-for="(item, i) in menuItems"
              :key="i"
              class="tab"
              @click="$router.push(item.path)"
              >{{ item.title }}</v-tab
            >
            <div style="display: flex; align-items: center">
              <v-text-field
                class="search-input"
                solo-inverted
                flat
                hide-details
                label="검색어를 입력해주세요"
                v-model="bookSearch"
                @keyup.enter="search"
                style="
                  margin-left: 4vw;
                  width: 40vw;
                  font-size: 26px;
                  color: red;
                "
              >
              </v-text-field>
            </div>
          </v-tabs>
        </v-app-bar>
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
      // sidebar: false,
      menuItems: [
        { title: "사이트소개", path: "/introduce" },
        { title: "카테고리", path: "/category" },
        { title: "장터", path: "/market" },
        { title: "내 서재", path: "/mylibrary" },
      ],
    };
  },
  methods: {
    toHome() {
      this.$router.push("/");
    },
    search() {
      this.$router.push({
        name: "BookSearch",
        query: { keyword: this.bookSearch },
      });
      location.reload();
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
  height: 120px;
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
.hello-user-container {
  display: flex;
  align-items: center;
  float: right;
  margin-left: 65vw;
  height: 100%;
}
.hello-user {
  font-family: "Nanum Gothic", sans-serif;
  font-size: 35px;
  /* border: 3px solid blue; */
}
.tabs {
  /* border: 3px solid black; */
  height: 100%;
}
.tab {
  /* width: 100px; */
  width: 12vw;
  font-family: "Nanum Gothic", sans-serif;
  font-size: 30px !important;
  color: white !important;
}
/* .search-input .v-input {
  color: blue !important;
} */
</style>
