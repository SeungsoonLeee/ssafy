import Vue from "vue";
import Vuex from "vuex";
import http from "./http-common";

// Vuex를 사용하기 위한 설정
Vue.use(Vuex);

// Vuex store 객체 생성
const store = new Vuex.Store({
    state: {
        QItems: [],
        QDetail: {},
        ADetail: [],
        Qupdate: {},
        LoginUserInfo: {},
    },
    actions: { // 백엔드와 통신하기 위한 메서드들
        // [] => 안의 내용에 대한 표현식을 실행 한 후 생기는 결과값을 속성명으로 하라는 의미
        getQList : (store) => { // 매개변수로 store 객체 자기 자신이 옴
            http
              .get("/safefood/qna/searchAll")
              // 자신이 데이터를 갱신하지 않고 store에 commit함.
              .then(response => store.commit('getQList', {QItems: response.data.data}))
              .catch(exp => alert("QItems get 처리에 실패하였습니다." + exp));
        },
        getQDetail : (store, payload) => { // 필요한 매개변수는 2번째 부터 써주면 됨
            http
              .get("/safefood/qna/searchQuestion/" + payload.no)
              .then(response => {
                console.log('QDetail get 처리 되었습니다.');
                console.log(response.data.data);
                store.commit('getQDetail', {QDetail: response.data.data});
              })
              .catch(exp => alert("QDetail get 처리에 실패하였습니다." + exp));
        },
        getADetail : (store, payload) => {
            http
              .get("/safefood/qna/searchAnswerAll/" + payload.no)
              .then(response => {
                console.log('ADetail get 처리 되었습니다.');
                store.commit('getADetail', {ADetail: response.data.data});
              })
              .catch(exp => alert("ADetail get 처리에 실패하였습니다." + exp));
        },
        insetQItem : (store, payload) => {
            http
              .post("/safefood/qna/insertQuestion", {
                title: payload.QInput.title,
                userid: payload.QInput.userid,
                content: payload.QInput.content
              })
              .then(() => {
                console.log("QnA insert 처리 되었습니다.");
                store.dispatch('getQList');
              })
              .catch(exp => alert("QnA insert 처리에 실패하였습니다." + exp));
        },
        updateQItem : (store, payload) => {
          console.log("--------" + payload.no);
          console.log("--------" + payload.Qupdate);
          console.log("--------" + payload.Qupdate.hit);
            http
              .put("/safefood/qna/updateQuestion/", {
                qno : payload.no,
                title: payload.Qupdate.title,
                content: payload.Qupdate.content
              })
              .then(() => {
                http
                  .get("/safefood/qna/searchQuestion/" + payload.no)
                  .then(response => {
                    console.log('QDetail get 처리 되었습니다.');
                    console.log(response.data.data);
                    store.commit('getQDetail', {QDetail: response.data.data});
                  })
                  .catch(exp => alert("QDetail get 처리에 실패하였습니다." + exp));
              })
              .catch(exp => alert("QnA update 처리에 실패하였습니다." + exp));
        },
        deleteQItem : (store, payload) => { // 매개변수로 store 객체 자기 자신이 옴, 두번째 매개변수는 받아올 데이터
          http
            .delete("/safefood/qna/deleteQuestion/" + payload.no)
            .then(() => {
              console.log("QnA delete 처리 되었습니다."  + payload.no);
              store.dispatch('getQList');
            })
            .catch(exp => alert("QnA delete 처리에 실패하였습니다." + exp));
        },
        insetAItem : (store, payload) => {
          http
            .post("/safefood/qna/insertAnswer", {
              userid: payload.AInput.userid,
              content: payload.AInput.content,
              qno: payload.AInput.qno
            })
            .then(() => {
              console.log("Answer insert 처리 되었습니다.");
              http
                .get("/safefood/qna/searchAnswerAll/" + payload.AInput.qno)
                .then(response => {
                  store.commit('getADetail', {ADetail: response.data.data});
                })
              .catch(exp => alert("ADetail get 처리에 실패하였습니다." + exp));
            })
            .catch(exp => alert("QnA insert 처리에 실패하였습니다." + exp));
        },
        deleteAItem : (store, payload) => { // 매개변수로 store 객체 자기 자신이 옴, 두번째 매개변수는 받아올 데이터
          http
            .delete("/safefood/qna/deleteAnswer/" + payload.no)
            .then(() => {
              console.log("Answer delete 처리 되었습니다.");
              http
                .get("/safefood/qna/searchAnswerAll/" + payload.qno)
                .then(response => {
                  store.commit('getADetail', {ADetail: response.data.data});
                })
              .catch(exp => alert("ADetail get 처리에 실패하였습니다." + exp));
            })
            .catch(exp => alert("Answer delete 처리에 실패하였습니다." + exp));
        },
        hitUpQItem : (store, payload) => {
          http
            .put("/safefood/qna/hitup/" + payload.no)
            .then(() => {
              console.log("조회수가 +1 되었습니다." + payload.no);
              http
                  .get("/safefood/qna/searchQuestion/" + payload.no)
                  .then(response => {
                    store.commit('getQDetail', {QDetail: response.data.data});
                  })
                  .catch(exp => alert("조회수 처리에 실패하였습니다.1" + exp));
            })
            .catch(exp => alert("조회수 처리에 실패하였습니다.2" + exp));
        },
        getLoginInfo : (store) =>{
          http
          .get("/safefood/getLoginInfo.do")
          .then(response => {
            store.commit('getLoginInfo', {LoginUserInfo: response.data.data});
            console.log("---------" + response.data.data);
          })
          .catch(exp => alert("getLoginInfo 처리에 실패하였습니다." + exp));
    },
    },
    mutations: { // 저장소에 데이터를 반영(commit시 호출됨)
        getQList : (state, payload) =>{ // 매개변수로 store안의 state와 받아온 데이터를 줌
          state.QItems = payload.QItems // 받아온 데이터를 state에 넣어준다
        },
        getQDetail : (state, payload) =>{ // 매개변수로 store안의 state와 받아온 데이터를 줌
          state.QDetail = payload.QDetail // 받아온 데이터를 state에 넣어준다
        },
        getADetail : (state, payload) =>{ // 매개변수로 store안의 state와 받아온 데이터를 줌
          state.ADetail = payload.ADetail // 받아온 데이터를 state에 넣어준다
        },
        getLoginInfo: (state, payload) =>{ // 매개변수로 store안의 state와 받아온 데이터를 줌
          state.LoginUserInfo = payload.LoginUserInfo // 받아온 데이터를 state에 넣어준다
        },
    }
});

export default store;