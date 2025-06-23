package com.asent.customerDetails.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asent.customerDetails.dto.CustomerDTO;
import com.asent.customerDetails.entity.CustomerEntity;
import com.asent.customerDetails.mapper.MapperClass;
import com.asent.customerDetails.service.CustomerService;



@Controller
@RequestMapping("/asent")
public class CustomerController {

	@Autowired
	CustomerService serviceLayer;
	

	@GetMapping("")
	public String welcomePage() {
		return "welcome";
	}
	
	//for redirecting to the create_customer page.
	@GetMapping("/createNewCustomer")
	public ModelAndView ModelAcreateCustomerPage() {
		ModelAndView mView = new ModelAndView();
		CustomerDTO customerDTO = new CustomerDTO();
		mView.addObject("customer", customerDTO);
		mView.setViewName("create_customer");
		return mView;
		
	}
	
	
	@GetMapping("/displayAll")
	public ModelAndView goToDisplayPage(@RequestParam(defaultValue = "1")int pageNo) {
		
		ModelAndView modelAndView = new ModelAndView();
		List<CustomerEntity> customer= serviceLayer.sortByAscending(pageNo++);
		modelAndView.addObject("customers", customer);
		modelAndView.addObject("pageNo", pageNo);  // Pass incremented pageNo as nextPage

		modelAndView.addObject("nextPage", pageNo + 1);  // Pass incremented pageNo as nextPage

		modelAndView.setViewName("display-page");
		return modelAndView;
	}
	
	//when user click the submit button in the form post request is send.
	@PostMapping("/submit-user")
	public String saveCustomer(@ModelAttribute CustomerDTO dto,RedirectAttributes attriubte) {
			serviceLayer.saveCustomer(dto);
//			ModelAndView modelAndView = new ModelAndView();
			attriubte.addFlashAttribute("msg", "Customer Created successfully");

//			modelAndView.addObject("msg", "Customer Created successfully");
			return "redirect:/asent/createNewCustomer";
	}
	
	@GetMapping("/search")
	public ModelAndView goToSearchPage() {
		CustomerDTO dto = new CustomerDTO();
		ModelAndView modelAndView = new ModelAndView("search");
		modelAndView.addObject("customer-search-obj", dto);
		return modelAndView;
	}
	
	@PostMapping("/searchSubmit")
	public ModelAndView searchSubmit(@RequestParam String option, @RequestParam String enteredDetails) {
	    ModelAndView modelAndView = new ModelAndView();

	    // Attempt to fetch the customer entity based on the search option and details
	    CustomerEntity customerEntity = serviceLayer.searchUser(option, enteredDetails);
	    
	    // If no customer is found (i.e., entity is null), redirect to error page
	    if (customerEntity == null) {
	        modelAndView.setViewName("error-page");
	        modelAndView.addObject("errorMessage", "User not found with the provided details.");
	        return modelAndView;
	    }
	    
	    // Convert the customer entity to DTO
	    CustomerDTO dto = MapperClass.customerFromEntityToDto(customerEntity);

	    // Add the DTO to the model for rendering the result
	    modelAndView.addObject("result", dto);
	    modelAndView.setViewName("search"); // This is the view to display the result

	    return modelAndView;
	}

	@GetMapping("/delete{id}")
	public String deleteUser(@PathVariable Integer id) {
		serviceLayer.deleteUserByID(id);
		return "redirect:/asent/displayAll";
	}

	@GetMapping("/updateUser/{id}")
	public ModelAndView updateUser(@PathVariable Integer id) {
		CustomerEntity customer = serviceLayer.findCustomerById(id);
		ModelAndView model = new ModelAndView();
		model.addObject("customer", customer);
		System.out.println(customer);
		model.setViewName("update");
		return model;
	}

	@PostMapping("/updateSubmit")
	public String postMethodName(@ModelAttribute CustomerEntity customer,RedirectAttributes attributes) {
		attributes.addFlashAttribute("msg_update","Customer Updated Successfully...");
		System.out.println(customer);
		System.out.println(customer.getId());
		CustomerEntity existingCustomer = serviceLayer.findCustomerById(customer.getId());

    if (existingCustomer != null) {  // Ensure the record exists
		existingCustomer.setId(customer.getId());
		
        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setWhatappNo(customer.getWhatappNo());
        existingCustomer.setRequirements(customer.getRequirements());

        // Save the updated entity
        serviceLayer.saveCustomer(MapperClass.customerFromEntityToDto(existingCustomer));
    }
		return "redirect:/asent/displayAll";
	}
	
	// @GetMapping("/asent/sort/ascen")
	// public ModelAndView getMethodName() {
		
	// 	ModelAndView modelAndView = new ModelAndView();
	// 	List<CustomerEntity> customer= serviceLayer.sortByAscending(pageNo++);
	// 	modelAndView.addObject("customers", customer);
	// 	return modelAndView;
	// }
	
	
	
	
}
