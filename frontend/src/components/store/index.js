import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

const uri = 'http://localhost:8080/account'

const store = new Vuex.Store({
    state: {
        session_email : ''
      },
      getters: {
    
      },
      mutations: {
        LOGIN (state, {email}) {
            state.session_email = email
        },
        LOGOUT (state) {
          state.session_email = ''
        }
      },
      actions: {
        LOGIN ({commit}, {email, password}) {
            let value = {
                accountEmail : email,
                accountPassword : password
            }

            axios.post(`${uri}/login`, value)
            .then(({data}) => {

                if (data.result === '로그인 성공'){
                    commit('LOGIN', data)
                } else {
                    alert(data.result)
                }
            })

        },
        LOGOUT ({commit}) {
          commit('LOGOUT')
        },
      }
})

export default store