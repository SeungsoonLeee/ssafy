<template>
  <div id="app">
    <todo-header></todo-header>
    <insert-todo-list @insertTodoList="insertTodoList"></insert-todo-list>
    <!-- 자신이 가지고 있는 data를 자식에게 넘겨주고, 자식이 보내는 이벤트를 받아와 처리함 -->
    <TodoList :propsTodoItems="todoItems" @doneTodoList="doneTodoList" @deleteTodoList="deleteTodoList"></TodoList> 
  </div>
</template>

<script>
import http from "./http-common";
import TodoList from "./components/TodoList.vue";
import TodoHeader from "./components/TodoHeader.vue";
import InsertTodoList from "./components/InsertTodoList.vue";

export default {
  name: "app", // devtool에서 보여질 디스플레이 명 [optional]
  components: {
    TodoList,
    TodoHeader,
    InsertTodoList
  },
  data() {
    return { // back-end와 통신하기 위한 데이터들
      todo: {},
      todoItems: []
    }
  },
  mounted () { // mounted 시 데이터를 새로 불러옴. 변경이 생기면 알아서 계속 이벤트 처리됨
    this.getTodoList();
  },
  methods: {
    getTodoList() {
      http
        .get("/todolist/user/java")
        .then(response => (this.todoItems = response.data))
        .catch(exp => alert("get 처리에 실패하였습니다." + exp));
    },
    doneTodoList(no) {
      http
        .put("/todolist/todo/done/" + no)
        .then(() => {
          console.log('done 처리 되었습니다.');
          this.getTodoList();
        })
        .catch(exp => alert("done 처리에 실패하였습니다." + exp));
    },
    deleteTodoList(no) {
      http
        .delete("/todolist/todo/" + no)
        .then(() => {
          console.log('delete 처리 되었습니다.');
          this.getTodoList();
        })
        .catch(exp => alert("delete 처리에 실패하였습니다." + exp));
    },
    insertTodoList(todo) { // 자식으로부터 데이터를 받아와야 함
      http
        .post("/todolist/todo", {
          content: todo.content, // todo 객체를 받아와 데이터 설정
          endDate: todo.endDate,
          userId: "java"
        })
        .then(() => {
          console.log("insert 처리 되었습니다.");
          this.getTodoList();
        })
        .catch(exp => alert("insert 처리에 실패하였습니다." + exp));
    }
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
body {
  text-align: center;
  background-color: #f6f6f8cb;
}
input {
  border-style: groove;
  width: 200px;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
}
</style>
