<template>
  <v-container fill-height fluid class="login-bg">
    <v-row align="center" justify="center">
      <v-col align="center">
        <h2 class="title">로그인</h2>
        <v-text-field
          v-model="credentials.email"
          solo
          autofocus
          placeholder="email을 입력해주세요."
          max
        ></v-text-field>
        <v-text-field
          type="password"
          v-model="credentials.password"
          solo
          placeholder="비밀번호를 입력해주세요."
        ></v-text-field>
        <v-btn width="400" height="48" @click="login">로그인</v-btn>
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

export default {
  name: "Login",
  data: function () {
    return {
      credentials: {
        email: "",
        password: "",
      },
      params: {
        client_id: "xxxxxx",
      },
    };
  },
  components: {
    GoogleLogin,
  },
  methods: {
    login() {
      axios
        .post(`http://j4b206.p.ssafy.io/api/account/login/`, this.credentials)
        .then((res) => {
          var data = JSON.parse(res.data.data);
          localStorage.setItem("jwt", data.token);
          // this.$emit("login");
          // this.$router.push({ name: "Home" });
          // location.reload();
        })
        .catch((err) => {
          console.log(err);
          alert("email과 비밀번호를 확인해주세요.");
        });
    },
    // ...mapActions(serviceStore, ['updateAccess']),
    onSuccess(googleUser) {
      console.log(googleUser);
      // this.updateAccess({ access: googleUser.wc.access_token });
      // axios
      //   .post(URL, {
      //     access_token: googleUser.wc.access_token,
      //   })
      //   .then(console.log("GOOGLE", googleUser.wc.access_token))
      //   .then((googleUser) => {
      //     localStorage.setItem("access_token", googleUser.data.access_token);
      //     console.log("Google Login Success");
      //     alert("Google Login Success");
      //     this.$router.push("/");
      //   })
      //   .then((res) => console.log(res))
      //   .catch((error) => {
      //     if (error.response.status === 401) {
      //       alert("비회원이므로 회원가입 페이지로 이동합니다!");
      //       this.$router.push("/signup");
      //     }
      //   });
    },
  },
};
</script>

<style scoped>
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
