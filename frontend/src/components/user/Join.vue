<template>
  <div style="margin-top : 56px;">
  <Header></Header>
    <div class="d-flex justify-content-center py-5" style="margin : 7.08% 0 7.08% 0">
        <form>
            <p class="h4 text-center mb-4">Sign up</p>
            <div class="grey-text">
            <mdb-input v-model="name" label="Your name" icon="user" type="text"/>
            <mdb-input v-model="email" label="Your email" icon="envelope" type="email"/>
            <mdb-input v-model="confirmEmail" label="Confirm your email" icon="exclamation-triangle" type="text"/>
            <div class="aniText" v-if="email != confirmEmail">Correct Email</div>
            <mdb-input v-model="password" label="Your password" icon="lock" type="password"/>
            </div>
            <div class="text-center">
              <mdb-btn @click="conTest()" color="primary">Register</mdb-btn>
            </div>
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
        confirmEmail : '',
        password : '',
        name : ''
      }
    },
    methods : {
      conTest() {

        let data = {
          accountEmail : this.email,
          accountPassword : this.password,
          accountName : this.name
        }

        axios.post(`${this.uri}/join`, data)
        .then(res => {
          alert(res.data.result);
        })
        .catch(e => {
          alert('실패ㅠㅠ');
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
.aniText {
  text-align: center;
  color: red;
  animation: fadein 2s;
  -moz-animation: fadein 2s;
  -webkit-animation: fadein 2s;
  -o-animation: fadein 2s;
}
@keyframes fadein {
    from {
        opacity:0;
    }
    to {
        opacity:1;
    }
}
@-moz-keyframes fadein { /* Firefox */
    from {
        opacity:0;
    }
    to {
        opacity:1;
    }
}
@-webkit-keyframes fadein { /* Safari and Chrome */
    from {
        opacity:0;
    }
    to {
        opacity:1;
    }
}
@-o-keyframes fadein { /* Opera */
    from {
        opacity:0;
    }
    to {
        opacity: 1;
    }
}
</style>
