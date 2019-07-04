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
            <td>{{ item.boardTitle }}</td>
            <td>{{ item.boardViews }}</td>
            <td>{{ item.boardReg }}</td>
        </tr>
        </mdb-tbl-body>
    </mdb-tbl>
    <div class="d-flex justify-content-between mt-4 flex-wrap">
        <mdb-pagination class="p-2" color="blue" style="margin-left:31%;">
            <div v-if="existPrev != true">
                <a class="mr-2" style="font-size:13px;" disabled>Previous</a>
            </div>
            <div v-else>
                <a class="mr-2" style="font-size:13px;" @click="pageing(prevBlock)">Previous</a>
            </div>
            <div v-for="startPage in endPage" v-bind:key="startPage.id">
                <div v-if="pageNum != startPage">
                    <input class="btn-md btn-outline-primary waves-effect" type="button" :value="startPage" @click="pageing(startPage)"/>
                </div>
                <div v-else>
                    <input class="btn-md btn-primary" type="button" :value="startPage" @click="pageing(startPage)"/>
                </div>
            </div>
            <div v-if="existNext != true">
                <a class="ml-2" style="font-size:13px;" disabled>Next</a>
            </div>
            <div v-else>
                <a class="ml-2" style="font-size:13px;" @click="pageing(1)" next>Next</a>
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
                console.dir(res);
                this.prevBlock = res.data.pageing.prevBlock
                this.nextBlock = res.data.pageing.nextBlock
                this.pageNum = res.data.pageing.pageNum
                this.endPage = res.data.pageing.endPage
                this.startPage = res.data.pageing.startPage
                this.list= res.data.list;
            })
            .catch( e => {
                alert('실패')
            })
        }
    },
    created() {
        axios.get(`${this.uri}/list/${this.pageNum}`)
            .then( res => {
                this.prevBlock = res.data.pageing.prevBlock
                this.nextBlock = res.data.pageing.nextBlock
                this.pageNum = res.data.pageing.pageNum
                this.endPage = res.data.pageing.endPage
                this.startPage = res.data.pageing.startPage
                this.list= res.data.list;
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
