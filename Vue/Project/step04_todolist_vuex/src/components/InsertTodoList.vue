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
          <span class="addContainer" @click="insertTodoList">
            <div class="addBtn fas fa-plus"></div>
          </span>
        </th>
      </tr>
    </table>
  </div>
</template>

<script>
import Constant from "../Constant";

export default {
  name: "insertTodoList",
  data() { // ui에서 입력받은 데이터를 저장하기 위한 선언
    return {
      todo: {
        content: "",
        endDate: "",
        no: 0
      }
    };
  },
  methods: {
    insertTodoList() {
      if (this.todo.content.trim() != "") {
        this.$store.dispatch(Constant.ADD_TODO, {todo:this.todo}); // todo에 여기서 생성한 todo(=this.todo)를 넣어줌
        this.clear();
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
