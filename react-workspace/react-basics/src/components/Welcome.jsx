// function Welcome(){
//     return(
//         <>
//             <h1>Welcome to my page..</h1>
//             <h1>My Name Ashish</h1>
//         </>
//     )
// }

const Welcome=(props)=>{
        return(
        <>
            <h1>Welcome to my page..</h1>
            <h1>My Name {props.name}</h1>
        </>
        )
    
}

export default Welcome;