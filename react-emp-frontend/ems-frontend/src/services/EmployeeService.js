import axios from 'axios';

const REST_API_BASE_URL = "http://localhost:8080/employee/getAllEmp";

export const EmployeeService = () => {
  return axios.get(REST_API_BASE_URL);
};
