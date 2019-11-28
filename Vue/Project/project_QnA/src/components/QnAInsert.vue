<template>
    <div>
        <h1 align="center">QnA 작성</h1>
        <table align="center" class="contentBox">
            <tr>
                <th class="contentBoxTh">제목</th>
                <td class="contentBoxTd"><input type="text" name="title" v-model="QInput.title"/></td>
            </tr>
            <tr>
                <th class="contentBoxTh">글쓴이</th>
                <td class="contentBoxTd">{{getLoginInfo.id}}</td>
            </tr>
            <tr>
                <th class="contentBoxTh">내용</th>
                <td class="content">
                    <textarea rows="10" cols="200"  name="content" v-model="QInput.content"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="contentEnd">
                    <input type="button" class="btn" value="작성하기" @click="insertQItem">
                    <input type="button" class="btn" value="취소하기" @click="goQList">
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        data() { // ui에서 입력받은 데이터를 저장하기 위한 선언
            return {
                QInput: {
                    title: "",
                    userid: "",
                    content: "",
                }
            };
        },
        created () {
            this.$store.dispatch('getQDetail', {no:this.$route.params.qno});
            this.$store.dispatch('getADetail', {no:this.$route.params.qno});
            this.$store.dispatch('getLoginInfo');
        },
        computed: {
            getLoginInfo() {
                return this.$store.state.LoginUserInfo;
            }
        },
        methods: {
            insertQItem() {
                this.QInput.userid = this.$store.state.LoginUserInfo.id;
                this.$store.dispatch('insetQItem', {QInput:this.QInput});
                this.$router.push('/qnalist');
            },
            goQList(){
                this.$router.push('/qnalist');
            }
        },
    }
</script>

<style scoped>
.contentBox{
    width: 80%;
    font-size: 1.3rem;
}

.contentBoxTh{
    width: 150px;
    background-color: dimgray;
    color : white;
    border-radius: 5px 0px 0px 5px;
}

.contentBoxTd{
    border: solid 1px black;
    border-radius: 0px 5px 5px 0px;
    text-align: left;
    padding: 10px;
}

.content{
    border: solid 1px black;
    border-radius: 0px 5px 5px 0px;
    height: 150px;
    text-align: left;
    padding: 10px;
}

.content textarea{
    width: 100%;
}

.contentEnd{
    border: solid 1px black;
    border-radius: 5px 5px 5px 5px;
    text-align: right;
}

.btn {
    border: thin;
    padding: 13px 30px;
    border-radius: 5px 5px 5px 5px;
    color: #fff;
    text-transform: capitalize;
    transition: 0.5s;
    background-color: slategray;
    font-weight: 500;
    margin-left: 10px;
}

.btn:hover {
    color: #fff;
    background-color: #2493e0;
}
</style>