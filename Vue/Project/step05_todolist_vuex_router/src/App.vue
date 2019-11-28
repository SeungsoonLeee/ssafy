<template>
  <div id="app">
    <todo-header></todo-header>
    <router-view></router-view>
  </div>
</template>

<script>
import TodoList from "./components/TodoList.vue";
import TodoHeader from "./components/TodoHeader.vue";
import InsertTodoList from "./components/InsertTodoList.vue";
import TodoDetail from "./components/TodoDetail.vue";
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter); // vue-router를 쓰기 위한 설정
const router = new VueRouter({
  mode:'history',
  // routing 할 아이들 매핑
  routes:[
    {path:'/', component : TodoList}, // '/' 요놈에 TodoList 컴포넌트를 연결 시키겠다.
    {path:'/list', component : TodoList},
    {path:'/input', component : InsertTodoList},
    {path:'/detail/:no', component : TodoDetail}, // url에 ':data' 를 써주면 data를 url이 아닌 데이터로 받겠다는 의미
  ]
});

export default {
  name: "app", // devtool에서 보여질 디스플레이 명 [optional]
  components: {
    TodoHeader,
    // TodoList, // 이제 직접적으로 쓰이지 않기 떄문에 지워준다.
    // InsertTodoList  // 이제 직접적으로 쓰이지 않기 떄문에 지워준다.
  },
  router // router : router와 같은 의미
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
