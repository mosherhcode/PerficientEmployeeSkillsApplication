<template>
  <div class="employee-card">
      <form class="card-form" >
              <div class="input-div">
                <label for="firstName">First Name</label>
                <input  type="text" name="" id="firstName" v-model="newEmployee.firstName" />
              </div>
              <div class="input-div">
                <label for="lastName">Last Name</label>
                <input  type="text" name="" id="lastName" v-model="newEmployee.lastName" />
              </div>
              <div class="input-div">
                <label for="contactEmail">Contact Email</label>
                <input  type="text" name="" id="contactEmail" v-model="newEmployee.contactEmail" />
              </div>
              <div class="input-div">
                <label for="companyEmail">Company Email</label>
                <input  type="text" name="" id="companyEmail" v-model="newEmployee.companyEmail" />
              </div>
              <div class="input-div">
                <label for="birthDate">Birth Date</label>
                <input  type="text" name="" id="birthDate" v-model="newEmployee.birthDate" />
              </div>
              <div class="input-div">
                <label for="hiredDate">Hired Date</label>
                <input  type="text" name="" id="hiredDate" v-model="newEmployee.hiredDate" />
              </div>
              <div class="input-div">
                <label for="role">Role</label>
                <select name="" id="role" v-model="newEmployee.role">
                    <option value="Technical Consultant">Technical Consultant</option>
                    <option value="Project Manager">Project Manager</option>
                    <option value="Director">Director</option>
                    <option value="Chief">Chief</option>
                </select>
                
              </div>
              <div class="input-div">
                <label for="businessUnit">Business Unit</label>
                <select name="" id="businessUnit" v-model="newEmployee.businessUnit">
                    <option value="Digital Experience Group">Digital Experience Group</option>
                    <option value="Adobe">Adobe</option>
                    <option value="IBM NBU">IBM NBU</option>
                    <option value="API Management">API Management</option>
                </select>
                
              </div>
             
      
            <input type="submit" value="Save New Employee" />
        </form>
    </div>
</template>

<script>
import EmployeeService from '../services/EmployeeService.js';

export default {
    data(){
        return {
            newEmployee : {
                firstName: "",
                lastName: "",
                contactEmail: "",
                companyEmail: "",
                birthDate: "",
                hiredDate: "",
                role: "",
                businessUnit: ""
            }
        }
    }, 
    methods: {
        saveNewEmployee(){
            EmployeeService.addEmployee(this.newEmployee).then(response => {
                if(response.status == 201)
                    this.$router.push('/');
                else
                    alert(response.statusText);
            })
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