<template>
  <div id="app">
    <todo-header></todo-header>
    <insert-todo-list></insert-todo-list>
    <TodoList></TodoList>
  </div>
</template>

<script>
import TodoList from "./components/TodoList.vue";
import TodoHeader from "./components/TodoHeader.vue";
import InsertTodoList from "./components/InsertTodoList.vue";

export default {
  name: "app", // devtool에서 보여질 디스플레이 명 [optional]
  components: {
    TodoList,
    TodoHeader,
    InsertTodoList
  }
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
