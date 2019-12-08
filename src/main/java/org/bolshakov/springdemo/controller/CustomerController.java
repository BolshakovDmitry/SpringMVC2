package org.bolshakov.springdemo.controller;

import java.util.List;

import org.bolshakov.dao.CustomerDAO;
import org.bolshakov.entity.Customer;
import org.bolshakov.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomers(theCustomer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
        Customer theCustomer = customerService.getCustomers(theId);
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
      customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}


