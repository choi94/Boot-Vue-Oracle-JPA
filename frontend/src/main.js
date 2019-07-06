import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import store from './components/store'
import 'bootstrap-css-only/css/bootstrap.min.css'; 
import 'mdbvue/build/css/mdb.css';

Vue.prototype.$http = axios
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
