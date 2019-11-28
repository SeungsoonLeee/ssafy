import Vue from 'vue'
import App from './App.vue'
import store from './store'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  store : store // 이름이 같으므로 그냥 store라고 해도 됨
}).$mount('#app')
