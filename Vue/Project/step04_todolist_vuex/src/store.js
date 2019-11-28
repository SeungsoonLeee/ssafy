import Vue from "vue";
import Vuex from "vuex";
import Constant from "./Constant";
import http from "./http-common";

// Vuex를 사용하기 위한 설정
Vue.use(Vuex);

// Vuex store 객체 생성
const store = new Vuex.Store({
    state: {
        todoItems: [],
        todo: {}
    },
    actions: { // 백엔드와 통신하기 위한 메서드들
        // [] => 안의 내용에 대한 표현식을 실행 한 후 생기는 결과값을 속성명으로 하라는 의미
        [Constant.GET_TODOLIST] : (store) => { // 매개변수로 store 객체 자기 자신이 옴
            http
              .get("/todolist/user/java")
              // 자신이 데이터를 갱신하지 않고 store에 commit함.
              .then(response => store.commit(Constant.GET_TODOLIST, {todoItems: response.data}))
              .catch(exp => alert("get 처리에 실패하였습니다." + exp));
        },
        [Constant.REMOVE_TODO] : (store, payload) => { // 필요한 매개변수는 2번째 부터 써주면 됨
            http
              .delete("/todolist/todo/" + payload.no)
              .then(() => {
                console.log('delete 처리 되었습니다.');
                // 목록을 다시 불러오기 위해 dispatch함
                store.dispatch(Constant.GET_TODOLIST);
              })
              .catch(exp => alert("delete 처리에 실패하였습니다." + exp));
        },
        [Constant.COMPLETE_TODO] : (store, payload) => {
            http
              .put("/todolist/todo/done/" + payload.no)
              .then(() => {
                console.log('done 처리 되었습니다.');
                store.dispatch(Constant.GET_TODOLIST);
              })
              .catch(exp => alert("done 처리에 실패하였습니다." + exp));
        },
        [Constant.ADD_TODO] : (store, payload) => {
            http
              .post("/todolist/todo", {
                content: payload.todo.content,
                endDate: payload.todo.endDate,
                userId: "java"
              })
              .then(() => {
                console.log("insert 처리 되었습니다.");
                store.dispatch(Constant.GET_TODOLIST);
              })
              .catch(exp => alert("insert 처리에 실패하였습니다." + exp));
        }
    },
    mutations: { // 저장소에 데이터를 반영(commit시 호출됨)
        [Constant.GET_TODOLIST] : (state, payload) =>{ // 매개변수로 store안의 state와 받아온 데이터를 줌
            state.todoItems = payload.todoItems // 받아온 데이터를 state에 넣어준다
        }
    }
});

export default store;