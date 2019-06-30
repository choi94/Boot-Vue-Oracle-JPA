<template>
<div style="margin-top : 56px">
  <Header></Header>
    <div class="d-flex justify-content-center" style="margin: 7.25% 0 7.25% 0;">
  <form class="my-5">
    <p class="h4 text-center mb-4">Sign in</p>
    <div class="grey-text">
      <mdb-input label="Your email" icon="envelope" type="email"/>
      <mdb-input label="Your password" icon="lock" type="password"/>
    </div>
    <div class="text-center">
      <mdb-btn color="primary">Login</mdb-btn>
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

    
  export default {
    name: 'Basic',
    components: {
      mdbInput,
      mdbBtn,
      Footer,
      Header
    },
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
