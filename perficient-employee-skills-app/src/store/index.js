import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        employees: []
    },
    mutations: {
        SET_EMPLOYEES(state, data){
            state.employees = data;
        }
    },
    actions: {

    },
    modules: {

    }
})