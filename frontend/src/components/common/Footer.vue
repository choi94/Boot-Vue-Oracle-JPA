<template>
  <mdb-footer color="stylish-color-dark" class="font-small pt-4 no-margin-top">
    <mdb-container class="text-left">
      <mdb-row>
        <mdb-col sm="3">
          <h5 class="font-weight-bold">Bitcamp Inspect</h5>
          <p></p>
        </mdb-col>
        <mdb-col sm="3" col="4">
          <h5 class="font-weight-bold">USEFUL</h5>
          <ul>
            <li class="list-unstyled mb-2"><a href="#!">Your Account</a></li>
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
            <li class="list-unstyled mb-2">ehdgns94@icloud.com</li>
            <li class="list-unstyled mb-2">+82 10 6444 1246</li>
          </ul>
        </mdb-col>
      </mdb-row>
    </mdb-container>
    <div class="footer-copyright text-center py-3">
      <mdb-container fluid>
        &copy; 2019 Design by: <a class="font-weight-bold" href="#!" target="_blank">Choi-DongHun </a>
      </mdb-container>
    </div>
  </mdb-footer>
</template>
<script>
  import { mdbFooter, mdbContainer, mdbRow, mdbCol, mdbBtn, mdbIcon } from 'mdbvue';
  export default {
    name: 'FooterPage',
    components: {
      mdbFooter,
      mdbContainer,
      mdbRow,
      mdbCol
    }
  }
</script>
<style scoped>
    .no-margin-top{
        margin-top: 0 !important;
    }
    .asdjh {
        display: flex;
    }
</style>
