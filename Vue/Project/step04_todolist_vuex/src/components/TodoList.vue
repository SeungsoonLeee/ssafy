<template>
  <div>
    <ul>
      <li v-for="(todoItem) in todoItems" v-bind:key="todoItem.no" class="shadow" :class="{done : todoItem.done == 'Y'}">
        <i class="checkBtn fas fa-check" v-show="todoItem.done == 'N'" v-on:click="doneTodoList(todoItem.no)"></i>
          {{todoItem.content}} : {{todoItem.endDate}}
        <span class="removeBtn" type="button">
          <i class="far fa-trash-alt"  @click="deleteTodoList(todoItem.no)"></i>
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
      this.$store.dispatch(Constant.COMPLETE_TODO, {no}) // {no : no} 이기 때문에 속성명 하나로 표기 가능(es6)
    },
    deleteTodoList(no) {
      console.log('delete 처리 되었습니다. 번호 : ' + no);
      this.$store.dispatch(Constant.REMOVE_TODO, {no}) // {no : no} 이기 때문에 속성명 하나로 표기 가능(es6)
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