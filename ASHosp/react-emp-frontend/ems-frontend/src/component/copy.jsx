import React, { useEffect, useState } from 'react'
import { listEmployees } from '../services/EmployeeService'

const ListEmployeeComponent = () =>{
    listEmployees
    const [employees, seteEmployee] = useState([])

    useEffect(()=>{
    listEmployees().then((response)=>{
        seteEmployee(response.data);
    }).catch(error =>{
        console.error(error);
    })

    },[])
    return(
        <div className='container'>
            <h2 className='text-center'>
                List of Employee
            </h2>
            <table className='table table-striped table-bordered' >
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Employee First Name</th>
                        <th>Employee Last Name</th>
                        <th>Employee Email ID : </th>
                    </tr>
                </thead>

                <tbody>
                    {
                        employees.map((employee)=> 
                            <tr key={employee.id}>
                                <td>{employee.id}</td>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListEmployeeComponent