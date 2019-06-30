<template>
    <div style="margin-top : 56px;">
        <Header></Header>
        <div style="margin: 7% 30% 3% 30%;">
            <mdb-input icon="clipboard-list" label="Input Title" v-model="value" />
            <mdb-input class="mt-5" type="textarea" @input="handleInput" id="input_text" label="Input Text" icon="pencil-alt" rows="10"/>
        <div class="d-flex justify-content-end mt-5">
            <mdb-btn color="primary">Write</mdb-btn>
        </div>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
    import { mdbInput,mdbBtn } from 'mdbvue';
    import Footer from '@/components/common/Footer.vue';
    import Header from '@/components/common/Header.vue';

  export default {
    name: 'write',
    components: {
      mdbInput,
      mdbBtn,
      Footer,
      Header
    }
  }
</script>
<style scoped>
    #input_text {
        margin-left: 0px !important;
    }
</style>


