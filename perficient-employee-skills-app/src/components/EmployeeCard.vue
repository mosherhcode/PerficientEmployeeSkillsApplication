<template>
    <div class="employee-card">
          <form class="card-form" v-on:submit.prevent="updateEmployee()">
              <div class="input-div">
                <label for="firstName">First Name</label>
                <input v-bind:disabled="!isEditable" type="text" name="" id="firstName" v-model="employee.firstName" />
              </div>
              <div class="input-div">
                <label for="lastName">Last Name</label>
                <input v-bind:disabled="!isEditable" type="text" name="" id="lastName" v-model="employee.lastName" />
              </div>
              <div class="input-div">
                <label for="contactEmail">Contact Email</label>
                <input v-bind:disabled="!isEditable" type="text" name="" id="contactEmail" v-model="employee.contactEmail" />
              </div>
              <div class="input-div">
                <label for="companyEmail">Company Email</label>
                <input v-bind:disabled="!isEditable" type="text" name="" id="companyEmail" v-model="employee.companyEmail" />
              </div>
              <div class="input-div">
                <label for="birthDate">Birth Date</label>
                <input v-bind:disabled="!isEditable" type="text" name="" id="birthDate" v-model="employee.birthDate" />
              </div>
              <div class="input-div">
                <label for="hiredDate">Hired Date</label>
                <input v-bind:disabled="!isEditable" type="text" name="" id="hiredDate" v-model="employee.hiredDate" />
              </div>
              <div class="input-div">
                <label for="role">Role</label>
                <select v-bind:disabled="!isEditable" name="" id="role" v-model="employee.role">
                    <option value="Technical Consultant">Technical Consultant</option>
                    <option value="Project Manager">Project Manager</option>
                    <option value="Director">Director</option>
                    <option value="Chief">Chief</option>
                </select>

              </div>
              <div class="input-div">
                <label for="businessUnit">Business Unit</label>
                <select v-bind:disabled="!isEditable" name="" id="businessUnit" v-model="employee.businessUnit">
                    <option value="Digital Experience Group">Digital Experience Group</option>
                    <option value="Adobe">Adobe</option>
                    <option value="IBM NBU">IBM NBU</option>
                    <option value="API Management">API Management</option>
                </select>
              </div>
              <div class="input-div">
                <label for="assignedTo">Assigned To</label>
                <input v-bind:disabled="!isEditable" type="text" name="" id="assignedTo" v-model="employee.assignedTo.companyEmail" />
              </div>
            <input type="button" value="Edit" v-on:click="toggleEdit()" />
            <input v-show="isEditable" type="submit" value="Save Changes" />
          </form>
      </div>
</template>

<script>
import EmployeeService from '../services/EmployeeService.js';

export default {
    name: "employee-card",
    data() {
        return {
            isEditable: false 
        };
    }, 
    props: [
        "employee"
    ],
    methods: {
        toggleEdit(){
            this.isEditable = !this.isEditable;
        }, 
        updateEmployee(){
            EmployeeService.updateEmployee(this.employee).then(response => {
                this.employee = response.data;

            });
            this.isEditable = !this.isEditable;
        }
    }
}
</script>

<style>
    .input-div{
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }

    .card-form{
        display: flex;
        flex-wrap: wrap;
    }

    .employee-card{
        border-style: solid;
        width: 20%;
    }
</style>