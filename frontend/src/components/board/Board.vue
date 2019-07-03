<template>
<div style="margin-top : 56px;">
    <Header></Header>
    <div style="margin:3% 15% 2% 15%">
    <div class="d-flex justify-content-end">
        <mdb-form-inline class="active-blue">
            <mdbIcon class="mr-2" icon="search"/>
            <mdb-input type="text" placeholder="Search" aria-label="Search"/>
        </mdb-form-inline>
    </div>
    <mdb-tbl hover class="col-6 col-sm-12" style="text-align:center;">
        <mdb-tbl-head>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Count</th>
            <th>Date</th>
        </tr>
        </mdb-tbl-head>
        <mdb-tbl-body>
        <tr v-for="item in list" v-bind:key="item.id">
            <th>{{ item.boardEmail }}</th>
            <td>{{ item.boardTitle }}</td>
            <td>{{ item.boardContents }}</td>
            <td>{{ item.boardReg }}</td>
        </tr>
        </mdb-tbl-body>
    </mdb-tbl>
    <div class="d-flex justify-content-between mt-5 flex-wrap">
        <div v-if="this.$store.state.session_email != ''">
            <router-link to="/write"><mdb-btn color="primary">Write</mdb-btn></router-link>
        </div>
    </div>
    </div>
    <Footer></Footer>
</div>
</template>
<script>
    import { mdbTbl, mdbTblHead, mdbTblBody, mdbPagination, mdbPageItem, mdbPageNav, mdbBtn, mdbIcon, mdbFormInline, mdbInput } from 'mdbvue';
    import Footer from '@/components/common/Footer.vue';
    import Header from '@/components/common/Header.vue';
    import axios from 'axios';

  export default {
    name: 'TablePage',
    components: {
      mdbTbl,
      mdbTblHead,
      mdbTblBody,
      Header,
      Footer,
      mdbPagination,
      mdbPageItem,
      mdbPageNav,
      mdbBtn,
      mdbIcon,
      mdbFormInline,
      mdbInput
    },
    data() {
        return {
            list : []
        }
    },
    created() {
        let uri = 'http://localhost:8080/board'

        axios.get(`${uri}/list`)
            .then( res => {
                this.list= res.data;
            })
            .catch( e => {
                alert('실패')
            })
    }
    
  }
</script>
<style scoped>
    .active-blue input[type=text]:focus:not([readonly]) {
        border-bottom: 1px solid #4285f4;
        box-shadow: 0 1px 0 0 #4285f4;
    }
</style>
