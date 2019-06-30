<template>
    <div style="margin-top : 56px;">
        <Header></Header>
        <div style="margin: 7% 30% 3% 30%;">
            <div class="d-flex justify-content-between mb-3">
                <div class="d-flex justify-content-start">
                    <div>NickName</div>
                    <div class="ml-5">2019-06-30 15:00</div>
                </div>
                <div class="d-flex justify-content-end">
                    <div>15<span class="ml-2">Views</span></div>
                </div>
            </div>
            <p class="text-justify" id="title"><mdb-icon class="mr-3" icon="clipboard-list"/>Title Area</p>
            <p class="text-justify" id="content">Ambitioni dedisse scripsisse iudicaretur.<br> Cras mattis iudicium purus sit amet
            fermentum.<br> Donec sed odio operae,
            eu vulputate felis rhoncus.<br> Praeterea iter est quasdam res quas ex communi.<br> At nos hinc posthac, sitientis
            piros Afros.<br> Petierunt uti sibi concilium totius Galliae in diem certam indicere.<br> Cras mattis iudicium
            purus sit amet fermentum.<br> Lorem ipsum dolor sit amet consectetur adipisicing elit.<br> Rerum repudiandae esse dolorum quo quaerat quisquam reprehenderit, aperiam</p>
            <div class="d-flex justify-content-end mt-5">
                <mdb-btn color="success">Modify</mdb-btn>
                <mdb-btn color="danger">Delete</mdb-btn>
            </div>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
    import { mdbBtn, mdbIcon } from 'mdbvue';
    import Footer from '@/components/common/Footer.vue';
    import Header from '@/components/common/Header.vue';
export default {
    components : {
        mdbBtn,
        Footer,
        Header,
        mdbIcon
    }
}
</script>
<style scoped>
    #content {
        border : 1px solid #e0e0e0;
        padding : 3%;
    }
    #title {
        border : 1px solid #e0e0e0;
        padding : 2%;
    }
</style>


