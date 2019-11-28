<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
import QnAList from "./components/QnAList.vue";
import QnAInsert from "./components/QnAInsert.vue";
import QnAUpdate from "./components/QnAUpdate.vue";
import QnADetail from "./components/QnADetail.vue";
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter); // vue-router를 쓰기 위한 설정
const router = new VueRouter({
  // mode:'history',
  // routing 할 아이들 매핑
  routes:[
    {path:'/', component : QnAList}, // '/' 요놈에 TodoList 컴포넌트를 연결 시키겠다.
    {path:'/qnalist', component : QnAList},
    {path:'/qna.jsp', component : QnAList},
    {path:'/qnainsert', component : QnAInsert},
    {path:'/qnadetail/:no', component : QnADetail},
    {path:'/qnaupdate/:no', component : QnAUpdate},
  ]
});

export default {
  name: "app", // devtool에서 보여질 디스플레이 명 [optional]
  components: {
  },
  router // router : router와 같은 의미
};
</script>

<style>
@font-face {
	font-family: goyang;
	src: url('./font/HangeulNuriB.ttf');
	font-size: 60px;
}
</style>
