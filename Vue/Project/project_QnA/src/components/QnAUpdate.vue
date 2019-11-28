<template>
    <div>
        <h1 align="center">QnA 수정</h1>
        <table align="center" class="contentBox">
            <tr>
                <th class="contentBoxTh">제목</th>
                <td class="contentBoxTd"><input type="text" v-model="getQDetail.title"></td>
            </tr>
            <tr>
                <th class="contentBoxTh">글쓴이</th>
                <td class="contentBoxTd">{{getQDetail.userid}}</td>
            </tr>
            <tr>
                <th class="contentBoxTh">작성일</th>
                <td class="contentBoxTd">{{getQDetail.write_date}}</td>
            </tr>
            <tr>
                <th class="contentBoxTh">조회수</th>
                <td class="contentBoxTd">{{getQDetail.hit}}</td>
            </tr>
            <tr>
                <th class="contentBoxTh">내용</th>
                <td class="content">
                    <textarea rows="10" cols="200" v-model="getQDetail.content">
                    </textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="contentEnd">
                    <input type="button" class="btn" value="목록으로" @click="goQList">
                    <input type="button" class="btn" value="수정하기" @click="updateQItem(getQDetail.qno)">
                    <input type="button" class="btn"  value="삭제하기" @click="deleteQItem(getQDetail.qno)">
                    <input type="button" class="btn" value="취소하기" @click="goBack">
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        created () {
            this.$store.dispatch('getQDetail', {no:this.$route.params.no});
            this.$store.dispatch('getADetail', {no:this.$route.params.no});
            this.$store.dispatch('getLoginInfo');
    
        },
        computed: {
            getQDetail() {
                return this.$store.state.QDetail;
            },
            getADetail() {
                return this.$store.state.ADetail;
            },
            getLoginInfo() {
                return this.$store.state.LoginUserInfo;
            }
        },
        methods: {
            updateQItem(no) {
                console.log('update 처리 되었습니다. 번호 : ' + no);
                this.$store.dispatch('updateQItem', {no, Qupdate:this.$store.state.QDetail});
                this.$router.push('/qnadetail/' + no);
            },
            deleteQItem(no) {
                console.log('delete 처리 되었습니다. 번호 : ' + no);
                this.$store.dispatch('deleteQItem', {no});
                this.$router.push('/qnalist');
            },
            goQList(){
                this.$router.push('/qnalist');
            },
            goBack(){
                this.$router.go(-1);
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

.replyBox{
    width: 80%;
    font-size: 1.2rem;
}

.replyInput{
    border: solid 1px black;
    border-radius: 5px 5px 5px 5px;
    text-align: right;
}

.reply{
    border-bottom: solid 1px silver;
}

.replyText{
    height: 1.5rem;;
    width: 80%;
    border: 0px;
    border-bottom: solid 1px black;
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

.deleteBtn{
    font-size: 0.6rem;
}

.deleteBtn:hover{
    font-size: 0.8rem;
    color: blue;
}
</style>