<template>
    <v-container fill-height fluid class="signup-bg"> 
        <v-row align="center" justify="center">
            <v-col align="center">
                <h2 class="title">회원가입</h2>
                <v-text-field
                type="email"
                v-model="credentials.email"
                solo
                autofocus
                placeholder="email를 입력하세요."
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
                <v-text-field
                type="password"
                v-model="credentials.password_confirm"
                solo
                placeholder="비밀번호를 다시 한 번 입력하세요."
                clearable
                ></v-text-field>
                <v-text-field
                type="text"
                v-model="credentials.nickname"
                solo
                placeholder="닉네임을 입력해주세요"
                clearable
                ></v-text-field>
                <v-btn width="400" height="48" color='#FFFFFF' @click="signup" class="signup-btn">회원가입</v-btn>
                <v-btn width="400" height="48" color='#FFFFFF'>
                <GoogleLogin
                    :params="params" 
                    b 
                    :onSuccess="onSuccess"
                >
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
import axios from 'axios'

export default {
    name: 'Signup',
    data() {
        return {
            credentials: {
                email: '',
                password: '',
                password_confirm: '',
                nickname: '',
            },
        }
    },
    methods: {
        signup () {
            if (this.credentials.password != this.credentials.password_confirm) {
                alert('비밀번호가 다릅니다.')
                this.credentials.password = ''
                this.credentials.password_confirm = ''
            } else {
                axios.post(`http://j4b206.p.ssafy.io/account/signup/`, { email: this.credentials.email, password: this.credentials.password, nickname: this.credentials.nickname })
                    .then((res) => {
                    console.log(res)
                    this.$router.push({ name: 'Login' })
                    })
                    .catch((err) => {
                    console.log(err)
                    })
            }
        }
    }
}
</script>
<style>
    .signup-bg {
        background-color: #D9D9D9;
        opacity: .8;
        max-width: 100%;
        height: 900px;
        margin: 0;
    }
</style>
