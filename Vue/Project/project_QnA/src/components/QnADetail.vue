<template>
    <div>
        <h1 align="center">QnA 상세내용</h1>
        <table align="center" class="contentBox">
            <input type="hidden" value="getQDetail.qno" v-model="AInput.qno">
            <tr>
                <th class="contentBoxTh">제목</th>
                <td class="contentBoxTd">{{getQDetail.title}}</td>
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
                <td class="content">{{getQDetail.content}}</td>
            </tr>
        </table>
        <table align="center" class="replyBox" v-if="getLoginInfo.id != ''">
            <tr>
                <td colspan="2" class="replyInput">
                    {{getLoginInfo.id}}
                    <input class="replyText" type="text" v-model="AInput.content"/>
                    <input type="button" class="btn" value="답변쓰기" @click="insertAItem()" />
                </td>
            </tr>
        </table>
        <table align="center" class="replyBox">
            <div class="reply" v-for="(AItem) in getADetail" v-bind:key="AItem.ano">
                <tr> 
                    <td>
                        {{AItem.userid}} | 
                    </td>
                    <td class="replyDate">{{AItem.write_date}}</td>
                </tr>
                <tr>
                    <td></td>
                    <td>{{AItem.content}} <span v-show="AItem.userid == getLoginInfo.id" class="deleteBtn" @click="deleteAItem(AItem.ano)">답변삭제</span></td>
                </tr>
            </div>
            <tr>
                <td colspan="2" class="contentEnd">
                    <input type="button" class="btn" value="목록" @click="goQList">
                    <input v-show="getQDetail.userid == getLoginInfo.id" type="button" class="btn" value="수정" @click="goQItemUpdate(getQDetail.qno)">
                    <input v-show="getQDetail.userid == getLoginInfo.id" type="button" class="btn" value="삭제" @click="deleteQItem(getQDetail.qno)">
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        data() { // ui에서 입력받은 데이터를 저장하기 위한 선언
            return {
                AInput: {
                    userid: "",
                    content: "",
                    qno: ""
                }
            };
        },
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
            goQItemUpdate(no) {
                console.log('QnA Update 페이지 이동 처리 되었습니다. 번호 : ' + no);
                this.$router.push('/qnaupdate/' + no);
            },
            deleteQItem(no) {
                console.log('delete 처리 되었습니다. 번호 : ' + no);
                this.$store.dispatch('deleteQItem', {no});
                this.$router.push('/qnalist');
            },
            insertAItem() {
                this.AInput.userid = this.$store.state.LoginUserInfo.id;
                this.AInput.qno = this.$store.state.QDetail.qno;
                this.$store.dispatch('insetAItem', {AInput:this.AInput});
            },
            deleteAItem(no) {
                console.log('delete 처리 되었습니다. 번호 : ' + no);
                this.$store.dispatch('deleteAItem', {no, qno:this.$store.state.QDetail.qno});
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

.replyDate{
    text-align: left;
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