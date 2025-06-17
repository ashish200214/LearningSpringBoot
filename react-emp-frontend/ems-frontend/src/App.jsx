import "./App.css";
import Footer from "./component/Footer";
import ListEmployeeComponent from "./component/ListEmployeeComponent";
import { Header } from "./component/Header";
import {BrowserRouter, Routes,Route} from "react-router-dom";
import { EmployeeComponent } from "./component/EmployeeComponent";
function App() {
  
  return (
    <>
    <BrowserRouter>
    
    <Header></Header>
    <Routes>
      <Route path="/" element = {<ListEmployeeComponent></ListEmployeeComponent>}></Route>
      <Route path="/getAllEmp" element = {<ListEmployeeComponent></ListEmployeeComponent>}></Route>
      <Route path="/add-employee" element={EmployeeComponent}></Route>
    </Routes>

      <Footer></Footer>

      </BrowserRouter>
    </>
  );
}

export default App;
