import Vue from 'vue';
import VueRouter from 'vue-router';
import Employees from '../views/Employees.vue';
import NewEmployee from '../views/NewEmployee.vue';

Vue.use(VueRouter);

const routes = [
    {
        path: "/",
        name: "Employees",
        component: Employees
    },
    {
        path: "/new-employee",
        name: "NewEmployee",
        component: NewEmployee
    }
];

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
});

export default router;