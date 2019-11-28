<template>
  <div>
    <ul>
      <li v-for="(todoItem) in propsTodoItems" v-bind:key="todoItem.no" class="shadow" :class="{done : todoItem.done == 'Y'}">
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

export default {
  name: "TodoList",
  props: { // 부모에게서 데이터를 받아옴
    propsTodoItems: { // 받아온 데이터 명 설정
      type: Array
    },
  },
  //-부모로부터 데이터를 받아오기 때문에 더이상 필요가 없음--------------------------------------------------------
  // data() { 
  //   return {
  //     todoItems: [] // 새로운 객체를 생성하여 리턴한다. instance 느낌
  //   };
  // },
  // created() {
  //   this.getTodoList();
  //   bus.$on('getTodoList', this.getTodoList) // 수신할 이벤트 버스 연결 => $on.('이벤트 명', callback 할 함수)
  // },
  //-----------------------------------------------------------------------------------------------------------

  //-부모에서 다 처리하므로 필요 없어짐---------------------------------------------------------------------------
  methods: { // data를 처리하거나 UI event를 처리하는 메서드들
    // getTodoList() {
    //   http
    //     .get("/todolist/user/java")
    //     .then(response => (this.todoItems = response.data))
    //     .catch(exp => alert("get 처리에 실패하였습니다." + exp));
    // },
    doneTodoList(no) {
      // http
      //   .put("/todolist/todo/done/" + no)
      //   .then(() => {
      //     console.log('done 처리 되었습니다.');
      //     this.getTodoList();
      //   })
      //   .catch(exp => alert("done 처리에 실패하였습니다." + exp));

      console.log('done 처리 되었습니다. 번호 : ' + no);
      this.$emit('doneTodoList', no); // 부모에게 이벤트 송신
    },
    deleteTodoList(no) {
      // http
      //   .delete("/todolist/todo/" + no)
      //   .then(() => {
      //     console.log('delete 처리 되었습니다.');
      //     this.getTodoList();
      //   })
      //   .catch(exp => alert("delete 처리에 실패하였습니다." + exp));

      console.log('delete 처리 되었습니다. 번호 : ' + no);
      this.$emit('deleteTodoList', no); // 부모에게 이벤트 송신
    }
  //-----------------------------------------------------------------------------------------------------------
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