import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    getAllEmployees(){
        return http.get('/employees');
    },

    updateEmployee(updatedEmployee){
        return http.put(`/employees/${updatedEmployee.id}`, updatedEmployee);
    },

    addEmployee(newEmployee){
        return http.post('/employees', newEmployee);
    }

}