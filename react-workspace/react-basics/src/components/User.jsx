import { useState } from "react"

const User = () =>{

    const [firstName,setFirstName] = useState('Ashish')
    const [lastName, setLastName] = useState("gawali")

    function updateUser(){
        setFirstName('Suyash')
        setLastName('Gawali')
    }
    return(

        <div>
            <h1>User Details</h1>
            <p>{firstName}</p>
            <p>{lastName}</p>
            <button onClick={()=>{updateUser()}}>Update User</button>
        </div>
    )
}

export default User;