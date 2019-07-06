<template>
<div style="margin-top : 56px;">
    <Header></Header>
    <div style="margin:5.5% 15% 2% 15%">
    <!-- <div class="d-flex justify-content-end">
        <mdb-form-inline class="active-blue">
            <mdbIcon class="mr-2" icon="search"/>
            <mdb-input type="text" placeholder="Search" aria-label="Search"/>
        </mdb-form-inline>
    </div> -->
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
            <td><router-link :to="{ name : 'boardview', params : { boardNum : item.boardNum }}">{{ item.boardTitle }}</router-link></td>
            <td>{{ item.boardViews }}</td>
            <td>{{ item.boardReg }}</td>
        </tr>
        </mdb-tbl-body>
    </mdb-tbl>
    <div class="d-flex justify-content-center mt-4 mr-5 flex-wrap">
        <mdb-pagination class="p-2" color="blue">
            <div v-if="existPrev">
                <a class="mr-2" style="font-size:13px;" @click="pageing(prevBlock)">Previous</a>
            </div>

            <div v-for="(endPages, index) in endPage" v-bind:key="endPages.id" v-if="index >= startPage-1">
                <div v-if="pageNum != endPages">
                    <input class="btn-md btn-outline-primary waves-effect" type="button" :value="endPages" @click="pageing(endPages)"/>
                </div>
                <div v-else>
                    <input class="btn-md btn-primary" type="button" :value="endPages" @click="pageing(endPages)"/>
                </div>
            </div>

            <div v-if="existNext">
                <a class="ml-2" style="font-size:13px;" @click="pageing(nextBlock)" next>Next</a>
            </div>
        </mdb-pagination>
    </div>
    <div class="d-flex justify-content-end mt-1 flex-wrap">
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
            uri : 'http://localhost:8080/board',

            pageNum : 1,
            endPage : null,
            startPage : null,
            existNext : false,
            existPrev : false,
            prevBlock : null,
            nextBlock : null,

            list : []
        }
    },
    methods :  {

        pageing(pageNum) {
            axios.get(`${this.uri}/list/${pageNum}`)
            .then( res => {
                this.prevBlock = res.data.pageing.prevBlock
                this.nextBlock = res.data.pageing.nextBlock
                this.pageNum = res.data.pageing.pageNum
                this.startPage = res.data.pageing.startPage
                this.endPage = res.data.pageing.endPage
                this.existNext = res.data.pageing.existNext
                this.existPrev = res.data.pageing.existPrev
                this.list= res.data.list;
            })
            .catch( e => {
                alert('실패')
            })
        },
    },


        created() {
            axios.get(`${this.uri}/list/${this.pageNum}`)
                .then( res => {
                    this.prevBlock = res.data.pageing.prevBlock
                    this.nextBlock = res.data.pageing.nextBlock
                    this.pageNum = res.data.pageing.pageNum
                    this.endPage = res.data.pageing.endPage
                    this.startPage = res.data.pageing.startPage
                    this.existNext = res.data.pageing.existNext
                    this.existPrev = res.data.pageing.existPrev
                    this.list= res.data.list;
                    console.dir(res.data.list)
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
