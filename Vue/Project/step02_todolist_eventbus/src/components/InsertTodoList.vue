<template>
  <div>
    <table class="inputBox">
      <tr>
        <th>content</th>
        <th>endDate</th>
        <th>userId</th>
        <th width="1%"></th>
      </tr>
      <tr>
        <td><input type="text" name="content" v-model="todo.content"/></td>
        <td><input type="date" name="endDate" v-model="todo.endDate"/></td>
        <td><input type="text" name="userId" /></td>
        <th colspan="3">
          <span class="addContainer" @click="InsertTodoList">
            <div class="addBtn fas fa-plus"></div>
          </span>
        </th>
      </tr>
    </table>
  </div>
</template>

<script>
import http from "../http-common";
import bus from "../eventbus";

export default {
  name: "InsertTodoList",
  data() {
    return {
      todo: {
        content: "",
        endDate: "",
        no: 0
      }
    };
  },
  methods: {
    InsertTodoList() {
      if (this.todo.content.trim() != "") {
        http
          .post("/todolist/todo", {
            content: this.todo.content,
            endDate: this.todo.endDate,
            userId: "java"
          })
          .then(() => {
            console.log("insert 처리 되었습니다.");
            bus.$emit('getTodoList') // 송신할 이벤트 버스 연결 => $emit.('이벤트 명')
            this.clear();
          })
          .catch(exp => alert("insert 처리에 실패하였습니다." + exp));
      }
    },
    clear() {
      this.todo.content = "";
      this.todo.endDate = "";
    }
  }
};
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  width: 100%;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox td{
  border: solid 1px  black;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  align-items: center;
  background: linear-gradient(to right, #6478fb, #8763fb);
  display: inline-block;
  width: 3rem;
  border-radius: 5px 5px 5px 5px;
}
.addContainer2 {
  align-items: center;
  background: linear-gradient(to right, #647811, #527810);
  display: inline-block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.modifyBtn,
.addBtn {
  color: white;
  vertical-align: middle;
}
</style>
