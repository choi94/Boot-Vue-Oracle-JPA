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
        <tr>
            <th>Mark</th>
            <td>Lorem ipsum dolor shenderit quasi provident.</td>
            <td>5</td>
            <td>19-06-30</td>
        </tr>
        <tr>
            <th>ipsum</th>
            <td>Lorem ipsum dolor shenderit quasi provident.</td>
            <td>1</td>
            <td>19-06-30</td>
        </tr>
        <tr>
            <th>Mark</th>
            <td>Lorem ipsum dolor shenderit quasi provident.</td>
            <td>85</td>
            <td>19-06-30</td>
        </tr>
        <tr>
            <th>Mark</th>
            <td>Lorem ipsum dolor shenderit quasi provident.</td>
            <td>54</td>
            <td>19-06-30</td>
        </tr>
        <tr>
            <th>Mark</th>
            <td>Lorem ipsum dolor shenderit quasi provident.</td>
            <td>20</td>
            <td>19-06-30</td>
        </tr>
        <tr>
            <th>Mark</th>
            <td>Lorem ipsum dolor shenderit quasi provident.</td>
            <td>31</td>
            <td>19-06-30</td>
        </tr>
        <tr>
            <th>Mark</th>
            <td>Lorem ipsum dolor shenderit quasi provident.</td>
            <td>5</td>
            <td>19-06-30</td>
        </tr>
        <tr>
            <th>Mark</th>
            <td>Lorem ipsum dolor shenderit quasi provident.</td>
            <td>5</td>
            <td>19-06-30</td>
        </tr>
        </mdb-tbl-body>
    </mdb-tbl>
    <div class="d-flex justify-content-between mt-5 flex-wrap">
        <mdb-pagination class="p-2" color="blue" style="margin-left:31%;">
            <mdb-page-item disabled>Previous</mdb-page-item>
            <mdb-page-item active>1</mdb-page-item>
            <mdb-page-item>2</mdb-page-item>
            <mdb-page-item>3</mdb-page-item>
            <mdb-page-item>4</mdb-page-item>
            <mdb-page-item>5</mdb-page-item>
            <mdb-page-item next>Next</mdb-page-item>
        </mdb-pagination>
        <router-link to="/write"><mdb-btn color="primary">Write</mdb-btn></router-link>
    </div>
    </div>
    <Footer></Footer>
</div>
</template>
<script>
    import { mdbTbl, mdbTblHead, mdbTblBody, mdbPagination, mdbPageItem, mdbPageNav, mdbBtn, mdbIcon, mdbFormInline, mdbInput } from 'mdbvue';
    import Footer from '@/components/common/Footer.vue';
    import Header from '@/components/common/Header.vue';

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
    }
  }
</script>
<style scoped>
    .active-blue input[type=text]:focus:not([readonly]) {
        border-bottom: 1px solid #4285f4;
        box-shadow: 0 1px 0 0 #4285f4;
    }
</style>
