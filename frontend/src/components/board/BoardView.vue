<template>
    <div style="margin-top : 56px;">
        <Header></Header>

        <div style="margin: 7% 30% 3% 30%;" v-if="modify">
            <div class="d-flex justify-content-between mb-3">
                <div class="d-flex justify-content-start">
                    <div>{{ boardEmail }}</div>
                    <div class="ml-5">{{ boardReg }}</div>
                </div>
                <div class="d-flex justify-content-end">
                    <div>{{ boardViews }}<span class="ml-2">Views</span></div>
                </div>
            </div>
            <p class="text-justify" id="title"><mdb-icon class="mr-3" icon="clipboard-list"/>{{ boardTitle }}</p>
            <p class="text-justify" id="content">
                {{ boardContents }}
            </p>
            <div class="d-flex justify-content-end mt-5" v-if="this.$store.state.session_email === boardEmail">
                <input class="btn btn-danger" type="button" value="Delete" @click="board_delete"/>
                <input class="btn btn-success" type="button" value="Modify" @click="board_modify"/>
            </div>
        </div>

        <div style="margin: 7% 30% 3% 30%;" v-if="!modify">
            <mdb-input icon="clipboard-list" label="Input Title" v-model="boardTitle"/>
            <mdb-input class="mt-5" type="textarea" @input="handleInput" id="input_text" label="Input Text" icon="pencil-alt" rows="10" v-model="boardContents"/>
        <div class="d-flex justify-content-end mt-5">
            <input class="btn btn-danger" type="button" value="Cancel" @click="board_modify_cancel"/>
            <input class="btn btn-success" type="button" value="Write" @click="board_modify_write"/>
        </div>
        </div>

        <Footer></Footer>
    </div>
</template>
<script>
    import { mdbBtn, mdbIcon, mdbInput } from 'mdbvue';
    import Footer from '@/components/common/Footer.vue';
    import Header from '@/components/common/Header.vue';
    import axios from 'axios';

export default {
    components : {
        mdbBtn,
        Footer,
        Header,
        mdbIcon,
        mdbInput
    },
    data() {
        return {
            uri : 'http://localhost:8080/board',
            boardNum : null,
            boardContents : null,
            boardEmail : null,
            boardReg : null,
            boardTitle : null,
            boardViews : null,
            modify : true,

        }
    },
    methods : {
        board_delete() {

            if (confirm('이 게시물을 삭제 하시겠습니까?')) {
                axios.delete(`${this.uri}/view/${this.boardNum}`)
                    .then( res => {
                        alert('삭제가 완료 되었습니다.')
                        this.$router.push('/board')
                    })
                    .catch( e => {
                        alert('실패')
                })
            }
        },

        board_modify() {
            this.modify = false
        },

        board_modify_cancel() {
            this.modify = true
        },

        board_modify_write() {

            let data = {
                boardNum : this.boardNum,
                boardTitle : this.boardTitle,
                boardContents : this.boardContents,
                boardEmail : this.boardEmail,
                boardViews : this.boardViews,
                boardReg : this.boardReg
            }

            axios.put(`${this.uri}/view`, data)
            .then( res => {
                alert('수정이 완료 되었습니다.')
                this.modify = true
            })
            .catch( e => {
                alert('실패')
        })
        }
    },

    created() {
        this.boardNum = this.$route.params.boardNum

        axios.get(`${this.uri}/view/${this.boardNum}`)
            .then( res => {
                this.boardContents = res.data.boardContents
                this.boardEmail = res.data.boardEmail
                this.boardReg = res.data.boardReg
                this.boardTitle = res.data.boardTitle
                this.boardViews = res.data.boardViews
            })
            .catch( e => {
                alert('실패')
        })
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


