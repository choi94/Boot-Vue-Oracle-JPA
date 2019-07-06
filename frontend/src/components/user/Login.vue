<template>
<div style="margin-top : 56px">
  <Header></Header>
    <div class="d-flex justify-content-center" style="margin: 7.25% 0 7.25% 0;">
  <form class="my-5">
    <p class="h4 text-center mb-4">Sign in</p>
    <div class="grey-text">
      <mdb-input v-model="email" label="Your email" icon="envelope" type="email"/>
      <mdb-input v-model="password" label="Your password" icon="lock" type="password"/>
    </div>
    <div class="text-center">
      <input class="btn btn-primary" type="button" value="Login" @click="login"/>
    </div>
    <hr class="mt-4 my-4">
      <p class="font-small grey-text d-flex justify-content-end">Forgot your password? <a href="#" class="blue-text ml-1"> Find Password</a></p>
      <p class="font-small grey-text d-flex justify-content-end">New to Site? <a href="#" class="blue-text ml-1"> Create Account</a></p>
  </form>
  </div>
    <Footer></Footer>
  </div>
</template>
<script>
    import { mdbInput, mdbBtn } from 'mdbvue';
    import Footer from '@/components/common/Footer.vue';
    import Header from '@/components/common/Header.vue';
    import axios from 'axios'

  export default {
    name: 'Basic',
    components: {
      mdbInput,
      mdbBtn,
      Footer,
      Header
    },
    data : () => {
      return {
        uri : 'http://localhost:8080/account',
        email : '',
        password : ''
      }
    },
    methods: {
      login() {
        let data = {
          accountEmail : this.email,
          accountPassword : this.password
        }

        axios.post(`${this.uri}/login`, data)
          .then(res => {
            
            if (res.data.result === '로그인 성공'){
              this.$store.dispatch('LOGIN', {email : this.email, password : this.password})
              .then()
              .catch(({message}) => this.msg = message)
              this.$router.push('/')
            } else {
              alert('아이디 또는 비밀번호가 틀렸거나\n존재하지 않는 아이디입니다.')
            }
          })
          .catch(s => {
            alert('axios 실패')
          })
        
        
      }

    }
  }
</script>
<style scoped>
  #footer {
    position: relative;
    bottom: 0;
    left: 0;
    right: 0;
  }
</style>
