<template>
  <div >
      <h1>Employees</h1>
      <div class="card-grid">
        <employee-card v-for="employee in this.$store.state.employees" v-bind:key="employee.id" v-bind:employee="employee"/>
      </div>
      <router-link :to="{name : 'NewEmployee'}">Add New Employee</router-link>
  </div>
</template>

<script>
import EmployeeService from "../services/EmployeeService.js";
import EmployeeCard from "../components/EmployeeCard.vue";

export default {
    name: "employee-list",
    methods: {
        getEmployees(){
            EmployeeService.getAllEmployees().then(response => {
                this.$store.commit("SET_EMPLOYEES", response.data);
            })
        }
    },
    created(){
        this.getEmployees();
    }, 
    components: {
        EmployeeCard
    }
}
</script>

<style>
    .card-grid{
        display: flex;
        flex-wrap: wrap;
        justify-content: space-evenly;
    }
</style>