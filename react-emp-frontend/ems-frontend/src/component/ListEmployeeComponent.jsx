import React, { useEffect, useState } from "react";
import { EmployeeService } from "../services/EmployeeService";
import {useNavigate} from 'react-router-dom';
const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);
  const navigator = useNavigate();
  useEffect(() => {
    EmployeeService()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error("Error fetching employees:", error);
        setEmployees([]); // Optional: Reset the employee list to empty on error.
      });
  }, []);

  function addNewEmployee(){
    navigator('/add-employee')
  }
  return (
    <div className="container">
      <button className="btn btn-primary mb-2" onClick={addNewEmployee}>Add Employee</button>
      <h1 className="my-4">List of Employees</h1>
      {employees.length === 0 ? (
        <p>No employees found or failed to fetch data.</p>
      ) : (
        <table className="table table-bordered">
          <thead className="table-dark">
            <tr>
              <th>ID</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default ListEmployeeComponent;
