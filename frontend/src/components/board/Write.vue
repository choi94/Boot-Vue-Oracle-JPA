<template>
    <div style="margin-top : 56px;">
        <Header></Header>
        <div style="margin: 7% 30% 3% 30%;">
            <mdb-input icon="clipboard-list" label="Input Title" v-model="title" />
            <mdb-input class="mt-5" type="textarea" @input="handleInput" id="input_text" label="Input Text" icon="pencil-alt" rows="10" v-model="contents"/>
        <div class="d-flex justify-content-end mt-5">
            <input @click="write" type="button" value="Write" class="btn btn-primary"/>
        </div>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
    import { mdbInput,mdbBtn } from 'mdbvue';
    import Footer from '@/components/common/Footer.vue';
    import Header from '@/components/common/Header.vue';
    import axios from 'axios'

  export default {
    name: 'write',
    components: {
      mdbInput,
      mdbBtn,
      Footer,
      Header
    },
    data : () => {
        return {
            uri : 'http://localhost:8080/board',
            title : '',
            contents : ''
        }
    },
    methods : {
        write() {

            let data = {
                boardEmail : this.$store.state.session_email,
                boardTitle : this.title,
                boardContents : this.contents
            }

            if (this.title != '' && this.contents != '' && data.boardEmail != ''){
                axios.post(`${this.uri}/write`, data)
                    .then(res => {
                        this.$router.push('/board')
                    })
                    .catch(e => {
                        alert('실패')
                    })
            } else {
                alert('내용을 입력하세요')
            }
        }
    }
  }
</script>
<style scoped>
    #input_text {
        margin-left: 0px !important;
    }
</style>


