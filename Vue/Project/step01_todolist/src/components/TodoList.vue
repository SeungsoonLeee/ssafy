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
import http from "../http-common";

export default {
  name: "TodoList",
  data() {
    return {
      todoItems: [] // 새로운 객체를 생성하여 리턴한다. instance 느낌
    };
  },
  created() {
    this.getTodoList();
  },
  methods: { // data를 처리하거나 UI event를 처리하는 메서드들
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