<template>
  <v-container fill-height fluid class="login-bg">
    <v-row align="center" justify="center">
      <v-col align="center">
        <h1 class="title">로그인</h1>
        <form @submit.prevent="submit">
          <div
            class="form-group"
            :class="{ 'form-group--error': $v.email.$error }"
          >
            <v-text-field
              type="email"
              v-model.trim="$v.email.$model"
              solo
              placeholder="email을 입력해주세요."
            ></v-text-field>
          </div>
          <div class="error" v-if="!$v.email.required">
            email을 입력해주세요.
          </div>
          <div class="error" v-if="!$v.email.email">
            email을 올바르게 입력해주세요.
          </div>
          <div
            class="form-group"
            :class="{ 'form-group--error': $v.password.$error }"
          >
            <v-text-field
              type="password"
              v-model.trim="$v.password.$model"
              solo
              placeholder="비밀번호를 입력해주세요."
            ></v-text-field>
          </div>
          <div class="error" v-if="!$v.password.required">
            비밀번호를 입력해주세요.
          </div>
          <div class="error" v-if="!$v.password.minLength">
            비밀번호는 적어도
            {{ $v.password.$params.minLength.min }}글자 이상이어야합니다.
          </div>
          <v-btn
            width="400"
            height="48"
            color="#FFFFFF"
            type="submit"
            :disabled="submitStatus === 'PENDING'"
            class="login-btn"
            >로그인</v-btn
          >
          <v-btn
            width="400"
            height="48"
            color="#FFFFFF"
            class="signup-btn"
            @click="goSignup"
            >회원가입</v-btn
          >
          <p class="typo__p" v-if="submitStatus === 'OK'">
            Thanks for your submission!
          </p>
          <p class="typo__p" v-if="submitStatus === 'ERROR'">
            모든 항목을 입력해주세요.
          </p>
          <p class="typo__p" v-if="submitStatus === 'PENDING'">Sending...</p>
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
        </form>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import GoogleLogin from "vue-google-login";
import Vue from "vue";
import Vuelidate from "vuelidate";
Vue.use(Vuelidate);
import { required, email, minLength } from "vuelidate/lib/validators";

export default {
  name: "Login",
  data() {
    return {
      email: "",
      password: "",
      params: {
        client_id: "xxxxxx",
      },
    };
  },
  validations: {
    email: {
      required,
      email,
    },
    password: {
      required,
      minLength: minLength(6),
    },
  },
  components: {
    GoogleLogin,
  },
  methods: {
    login() {
      axios
        .post(`http://j4b206.p.ssafy.io/api/account/login/`, {
          email: this.email,
          password: this.password,
        })
        .then((res) => {
          var data = JSON.parse(res.data.data);
          console.log(data);
          localStorage.setItem("jwt", data.token);
          localStorage.setItem("nickname", data.user.nickname);

          // this.$emit("login");
          // this.$router.push({ name: "Home" });
          // alert("정상적으로 로그인 되었습니다.");
        })
        .catch((err) => {
          console.log(err);
          alert("email과 비밀번호를 확인해주세요.");
        });
    },
    submit() {
      console.log("submit!");
      this.$v.$touch();
      if (this.$v.$invalid) {
        this.submitStatus = "ERROR";
      } else {
        // do your submit logic here
        this.submitStatus = "PENDING";
        setTimeout(() => {
          this.submitStatus = "OK";
          this.login();
        }, 500);
      }
    },
    goSignup() {
      this.$router.push("/signup");
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

.title {
  margin: 50px;
}

.v-input {
  width: 400px;
  margin: 1rem;
}

.v-btn {
  display: block;
  margin: 1rem;
}

.form-group__message,
.error {
  font-size: 1rem;
  line-height: 1;
  display: none;
  margin-left: 14px;
  margin-top: -1.9375rem;
  margin-bottom: 0.9375rem;
}

.form-group--error + .error {
  display: block;
  color: #fb3232d2;
}

.google-login-button {
  width: 400px;
  height: 100px;
  padding: 10px;
  margin: 1rem;
}

.google-login-text {
  vertical-align: middle;
  margin: 0 10px;
}
</style>
