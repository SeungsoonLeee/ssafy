<template>
  <div>
    <h1 align="center">QnA List</h1>
    <table align="center">
      <tr>
        <th>No</th>
        <th width="50%">제목</th>
        <th>글쓴이</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <tr v-for="(QItem) in getQItems" v-bind:key="QItem.qno">
        <td align="center">{{QItem.qno}}</td>
        <td aling="left">
          <span @click="goQItemDetail(QItem.qno)">{{QItem.title}}</span>
          <span v-show="QItem.userid == getLoginInfo.id">
            <span class="aaa" @click="goQItemUpdate(QItem.qno)">수정</span>/
            <span class="aaa" @click="deleteQItem(QItem.qno)" >삭제</span>
          </span>
        </td>
        <td align="center">{{QItem.userid}}</td>
        <td align="center">{{QItem.write_date}}</td>
        <td align="center">{{QItem.hit}}</td>
      </tr>
      <tr>
        <td colspan="5" align="right">
          <input v-if="getLoginInfo.id != ''" type="button" class="btn" value="글쓰기" @click="goQnAInsert">
        </td>
      </tr>
    </table>
  </div>
</template>

<script>

export default {
  name: "QnAList",
  created () { // 실행 시 바로 목록을 불러오기 위한 작업
    this.$store.dispatch('getQList');
    this.$store.dispatch('getLoginInfo');
  },
  computed: {
    getQItems() {
      return this.$store.state.QItems; // store가 가지고 있는 state에 있는 data를 쓰겠다는 의미
    },
    getLoginInfo() {
      return this.$store.state.LoginUserInfo;
    }
  },
  methods: {
    goQItemDetail(no){
      console.log('QnA 보기 페이지 이동 처리 되었습니다. 번호 : ' + no);
      this.$store.dispatch('hitUpQItem', {no});
      this.$router.push('/qnadetail/' + no );
    },
    goQItemUpdate(no) {
      console.log('QnA Update 페이지 이동 처리 되었습니다. 번호 : ' + no);
      this.$router.push('/qnaupdate/' + no);
    },
    goQnAInsert(){
      console.log('QnA Insert 페이지 이동 처리 되었습니다.');
      this.$router.push('/qnainsert');
    },
    deleteQItem(no) {
      console.log('delete 처리 되었습니다. 번호 : ' + no);
      this.$store.dispatch('deleteQItem', {no});
    }
  }
};
</script>

<style scoped>
table{
    width: 80%;
    border-top: solid 2px black;
    border-bottom: solid 2px black;
    font-size: 1.3rem;
}

table td{
    border-top: solid 1px silver;
}

.aaa{
  font-size: 0.6rem;
}

.aaa:hover{
  font-size: 0.8rem;
  color: blue;
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