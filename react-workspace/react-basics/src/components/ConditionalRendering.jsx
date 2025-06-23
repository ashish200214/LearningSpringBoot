import { useState } from "react"

const ConditionalRendering = () =>{
    
    const [isLogged,setIsLoggedIn]=useState(false)
    let message = isLogged && "Welcome User"
    function handleEvent(){
        setIsLoggedIn(true)
    }
    return (
        <div>
            
            {message}
            <br />
            <button onClick={handleEvent}>Login</button>
        </div>
    )
    
}

export default ConditionalRendering;