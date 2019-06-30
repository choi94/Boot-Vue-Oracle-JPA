<template>
  <mdb-footer id="footer" color="stylish-color-dark" class="font-small pt-4 no-margin-top">
    <mdb-container class="text-left">
      <mdb-row>
        <mdb-col sm="3">
          <h5 class="font-weight-bold">Bitcamp Inspect</h5>
          <p></p>
        </mdb-col>
        <mdb-col sm="3" col="4">
          <h5 class="font-weight-bold">USEFUL</h5>
          <ul>
            <li class="list-unstyled mb-2"><a @click="modal">Your Account</a></li>
            <li class="list-unstyled mb-2"><a href="#!">Board</a></li>
            <li class="list-unstyled mb-2"><a href="#!">Home</a></li>
          </ul>
        </mdb-col>
        <mdb-col sm="3" col="4">
          <h5 class="font-weight-bold">PROJECT</h5>
          <ul>
            <li class="list-unstyled mb-2"><a href="#!">Technology</a></li>
            <li class="list-unstyled mb-2"><a href="https://github.com/choi94/Boot-Vue-H2-JPA" target="_blank">GitHub</a></li>
          </ul>
        </mdb-col>
        <mdb-col sm="3" col="4">
          <h5 class="font-weight-bold">CONTACT</h5>
          <ul>
            <li class="list-unstyled mb-2"><a href="https://map.naver.com/?query=%EC%84%9C%EC%9A%B8+%EA%B4%80%EC%95%85%EA%B5%AC" target="_blank">Seoul Korea, Gwanak-gu</a></li>
            <li class="list-unstyled mb-2">ehdgns94 icloud.com</li>
            <li class="list-unstyled mb-2">+82 10 6444 1246</li>
          </ul>
        </mdb-col>
      </mdb-row>
    </mdb-container>
    <div class="footer-copyright text-center py-3" style="min-height: 25vh;">
      <mdb-container fluid>
        &copy; 2019 Design by: <a class="font-weight-bold" href="#!" target="_blank">Choi-DongHun </a>
      </mdb-container>
    </div>
    <div>
      <mdb-modal id="account_modal" :show="subs" @close="subs = false">
      <mdb-modal-body class="mx-3 grey-text">
        <mdb-input label="Your email" icon="envelope" type="email" class="mb-5"/>
        <mdb-input label="New password" icon="lock" type="password" class="mb-5"/>
        <mdb-input label="Confirm your password" icon="exclamation-triangle" type="password" class="mb-5"/>
      </mdb-modal-body>
      <mdb-modal-footer center>
        <mdb-btn @click.native="subs = false" color="blue">Send <mdb-icon icon="paper-plane" class="ml-1"/></mdb-btn>
      </mdb-modal-footer>
    </mdb-modal>
    </div>
  </mdb-footer>
</template>
<script>
  import { mdbFooter, mdbContainer, mdbRow, mdbCol, mdbIcon, mdbBtn, mdbModal, mdbModalHeader, mdbModalBody, mdbInput, mdbModalFooter } from 'mdbvue';
  export default {
    name: 'FooterPage',
    components: {
      mdbFooter,
      mdbContainer,
      mdbRow,
      mdbCol,
      mdbBtn,
      mdbModal,
      mdbModalHeader,
      mdbModalBody,
      mdbInput,
      mdbModalFooter,
      mdbIcon
    },
    data() {
      return {
        subs: false,
      }
    },
    methods : {
      modal () {
        this.subs = true;
      }
    }
  }
</script>
<style scoped>
  .no-margin-top {
      margin-top: 0 !important;
  }
  #account_modal {
    padding-top: 7%;
  }
</style>
