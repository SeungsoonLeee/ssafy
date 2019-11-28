<template>
  <div>
    <ul>
      <li v-for="(todoItem) in todoItems" v-bind:key="todoItem.no" class="shadow" :class="{done: todoItem.done == 'Y'}" @click="getTodo(todoItem.no)">
        <i class="checkBtn fas fa-check" v-show="todoItem.done == 'N'" v-on:click.stop="doneTodoList(todoItem.no)"></i>
          {{todoItem.content}} : {{todoItem.endDate}}
        <span class="removeBtn" type="button">
          <i class="far fa-trash-alt"  @click.stop="deleteTodoList(todoItem.no)"></i> <!-- '.stop'을 해주면 부모태그의 click 이벤트까지 넘어가지 않는다! -->
        </span>
      </li>
    </ul>
  </div>
</template>

<script>
import Constant from '../Constant';

export default {
  name: "TodoList",
  // -부모에게서 데이터를 받아올 필요가 없어짐----------------------------------
  // props: { // 부모에게서 데이터를 받아옴
  //   propsTodoItems: { // 받아온 데이터 명 설정
  //     type: Array
  //   },
  // },
  // ------------------------------------------------------------------------
  created () { // 실행 시 바로 목록을 불러오기 위한 작업
    this.$store.dispatch(Constant.GET_TODOLIST);
  },
  computed: {
    todoItems() {
      return this.$store.state.todoItems; // store가 가지고 있는 state에 있는 data를 쓰겠다는 의미
    }
  },
  methods: {
    doneTodoList(no) {
      console.log('done 처리 되었습니다. 번호 : ' + no);
      this.$store.dispatch(Constant.COMPLETE_TODO, {no}); // {no : no} 이기 때문에 속성명 하나로 표기 가능(es6)
    },
    deleteTodoList(no) {
      console.log('delete 처리 되었습니다. 번호 : ' + no);
      this.$store.dispatch(Constant.REMOVE_TODO, {no}); // {no : no} 이기 때문에 속성명 하나로 표기 가능(es6)
    },
    getTodo(no){
      console.log('getTodo 처리 되었습니다. 번호 : ' + no);
      this.$router.push('/detail/' + no ); // 받은 데이터를 url 정보로 넘겨줄 수 있음 -> 동적 라우팅이 되도록 설정되어 있어야 함
    }
  }
};
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}
li {
  border : solid 1px black;
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}
.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}
.removeBtn {
  margin-left: auto;
  color: #de4343;
}

.list-item {
  display: inline-block;
  margin-right: 10px;
}
.list-move {
  transition: transform 1s;
}
.list-enter-active,
.list-leave-active {
  transition: all 1s;
}
.list-enter,
.list-leave-to {
  opacity: 0;
  transform: translateY(30px);
}
.done {
  background-color: lightslategray;
}
</style>