<template>
<div style="margin-top : 56px">
  <Header></Header>
    <div class="d-flex justify-content-center py-5">
  <form class="my-5">
    <p class="h4 text-center mb-4">Sign in</p>
    <div class="grey-text">
      <mdb-input label="Your email" icon="envelope" type="email"/>
      <mdb-input label="Your password" icon="lock" type="password"/>
    </div>
    <div class="text-center">
      <mdb-btn color="primary">Login</mdb-btn>
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
</style>
