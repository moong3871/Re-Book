<template>
  <v-container fill-height fluid class="login-bg">
    <v-row align="center" justify="center">
      <v-col align="center">
        <h2 class="title">로그인</h2>
        <v-text-field
          v-model="credentials.username"
          solo
          autofocus
          placeholder="ID를 입력하세요."
          clearable
          max
        ></v-text-field>
        <v-text-field
          type="password"
          v-model="credentials.password"
          solo
          placeholder="비밀번호를 입력하세요."
          clearable
        ></v-text-field>
        <!-- 여기 home으로 router 연결해놓은것도 임시 방편 -->
        <v-btn width="400" height="48" @click="$router.push('/home')"
          >로그인</v-btn
        >
        <v-btn width="400" height="48">
          <!-- <GoogleLogin :params="params" b :onSzuccess="onSuccess"> -->
          <GoogleLogin>
            <img
              alt="googleLogin"
              src="https://web-staging.brandi.co.kr/static/3.50.7/images/google-logo.png"
            />
            <span class="google-login-text">Google 계정으로 계속하기</span>
          </GoogleLogin>
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
// import { mapActions } from 'vuex'
import GoogleLogin from "vue-google-login";

// const URL = "http://j4b206.p.ssafy.io/login/oauth2/code/google";

export default {
  name: "Login",
  data: function () {
    return {
      credentials: {
        username: "",
        password: "",
      },
      params: {
        client_id: "rebook.manager@gmail.com",
      },
    };
  },
  components: {
    GoogleLogin,
  },
  methods: {
    login() {
      axios
        .post(`http://j4b206.p.ssafy.io/account/login/`, this.credentials)
        .then((res) => {
          // console.log(res)
          localStorage.setItem("jwt", res.data.token);
          this.$emit("login");
          this.$router.push({ name: "Home" });
          location.reload();
        })
        .catch((err) => {
          console.log(err);
          alert("email과 비밀번호를 확인해주세요.");
        });
    },
    // ...mapActions(serviceStore, ['updateAccess']),
  },
};
</script>

<style>
.login-bg {
  background-color: #d9d9d9;
  opacity: 0.8;
  max-width: 100%;
  height: 900px;
  margin: 0;
}
.v-input {
  width: 400px;
}

.title {
  margin: 30px;
}

.v-btn {
  display: block;
  margin-bottom: 30px;
}

.google-login-button {
  width: 400px;
  height: 100px;
  padding: 10px;
}

.google-login-text {
  vertical-align: middle;
  margin: 0 10px;
}
</style>
