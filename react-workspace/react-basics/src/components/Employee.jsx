import React from 'react';

class Employee extends React.Component{

    constructor(props){
        super(props)

        this.state = {
            firstName : "Ashish"
        }
        

    }
    updateEmp(){
        this.setState ( {
            firstName : "suyash"
        })
    }
    render(){
        return (
        <div>
            <h1>Employee Details</h1>
            <p>Name : {this.state.firstName}</p>
            <button onClick={()=>this.updateEmp()}>Click Here</button>
        </div>
        )
    }
}

export default Employee;