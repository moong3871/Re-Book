<template>
  <v-container fill-height fluid class="signup-bg">
    <v-row align="center" justify="center">
      <v-col align="center">
        <h2 class="title">회원가입</h2>
        <form @submit.prevent="submit">
          <div
            class="form-group"
            :class="{ 'form-group--error': $v.email.$error }"
          >
            <v-text-field
              type="email"
              name="email"
              v-model.trim="$v.email.$model"
              solo
              autofocus
              placeholder="email를 입력하세요."
              @input="validateEmail"
            ></v-text-field>
          </div>
          <div class="error" v-if="!$v.email.required">
            email을 입력해주세요.
          </div>
          <div class="error" v-if="!$v.email.email">
            email을 올바르게 입력해주세요.
          </div>
          <v-text-field
            type="password"
            v-model.trim="$v.password.$model"
            solo
            placeholder="비밀번호를 입력하세요."
          ></v-text-field>
          <v-text-field
            type="password"
            v-model.trim="$v.repeatPassword.$model"
            solo
            placeholder="비밀번호를 다시 한 번 입력하세요."
          ></v-text-field>
          <span v-if="!isConfirmed">패스워드가 다릅니다.</span>
          <v-text-field
            type="name"
            v-model.trim="$v.nickname.$model"
            solo
            placeholder="닉네임을 입력해주세요"
          ></v-text-field>
          <div class="error" v-if="!$v.nickname.required">
            별명을 입력해주세요!
          </div>
          <div class="error" v-if="!$v.nickname.minLength">
            별명은 적어도 {{ $v.nickname.$params.minLength.min }} 글자
            이상이어야 합니다.
          </div>
          <button
            class="button"
            type="submit"
            :disabled="submitStatus === 'PENDING'"
          >
            Submit!
          </button>
          <!-- <v-btn
            width="400"
            height="48"
            color="#FFFFFF"
            type="submit"
            @click="signup"
            class="signup-btn"
            >회원가입</v-btn
          > -->
          <p class="typo__p" v-if="submitStatus === 'OK'">
            Thanks for your submission!
          </p>
          <p class="typo__p" v-if="submitStatus === 'ERROR'">
            Please fill the form correctly.
          </p>
          <p class="typo__p" v-if="submitStatus === 'PENDING'">Sending...</p>
        </form>
        <!-- <v-btn width="400" height="48" color="#FFFFFF">
          <GoogleLogin :params="params" b :onSuccess="onSuccess">
            <img
              alt="googleLogin"
              src="https://web-staging.brandi.co.kr/static/3.50.7/images/google-logo.png"
            />
            <span class="google-login-text">Google 계정으로 계속하기</span>
          </GoogleLogin>
        </v-btn> -->
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import Vue from "vue";
import Vuelidate from "vuelidate";
Vue.use(Vuelidate);
import { required, email, minLength, sameAs } from "vuelidate/lib/validators";

export default {
  name: "Signup",
  data() {
    return {
      email: "",
      password: "",
      repeatPassword: "",
      nickname: "",
      isEmail: true,
      isConfirmed: true,
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
    repeatPassword: {
      sameAsPassword: sameAs("password"),
    },
    nickname: {
      required,
      minLength: minLength(4),
    },
  },
  methods: {
    // validateEmail() {
    //   if (
    //     /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(
    //       this.credentials.email
    //     )
    //   ) {
    //     this.isEmail = false;
    //   } else {
    //     this.isEmail = true;
    //   }
    // },
    // isPasswordConfirmed() {
    //   this.isConfirmed =
    //     this.credentials.password === this.credentials.password_confirm;
    // },
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
        }, 500);
      }
    },
    signup() {
      if (this.credentials.email === "") {
        alert("닉네임을 입력해주세요!");
      } else if (this.credentials.password_confirm === "") {
        alert("닉네임을 입력해주세요!");
      } else if (this.credentials.nickname === "") {
        alert("닉네임을 입력해주세요!");
      } else {
        axios
          .post(`http://j4b206.p.ssafy.io/api/account/signup/`, {
            email: this.credentials.email,
            password: this.credentials.password,
            nickname: this.credentials.nickname,
          })
          .then((res) => {
            console.log(res);
            this.$router.push({ name: "Login" });
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
  },
};
</script>
<style scoped>
.signup-bg {
  background-color: #d9d9d9;
  opacity: 0.8;
  max-width: 100%;
  height: 900px;
  margin: 0;
}

.v-input {
  width: 400px;
}

.v-btn {
  display: block;
  margin-bottom: 30px;
}
</style>
