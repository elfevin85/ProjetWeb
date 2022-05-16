package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.Domain.Address;
import com.example.demothymeleaf.Domain.Customer;
import com.example.demothymeleaf.Domain.Store;
import com.example.demothymeleaf.Service.AddressService;
import com.example.demothymeleaf.Service.CustomerService;
import com.example.demothymeleaf.Service.StoreService;
import com.example.demothymeleaf.Service.dto.CustomerDTO;
import com.example.demothymeleaf.Service.mapping.CustomerMapping;
import com.example.demothymeleaf.view.SearchViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;
    private  final StoreService storeService;
    private final AddressService addressService;
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService, StoreService storeService, AddressService addressService) {
        this.customerService = customerService;
        this.storeService = storeService;
        this.addressService = addressService;

    }
    //All with my Query ----------------------------------------------------------------------------------
    @GetMapping("/executeSearch")
    public String searchCustomer(@ModelAttribute("search") SearchViewModel search, Model model) {
        Collection<Customer> customer = customerService.searchCustomer(search.getQuery());
        model.addAttribute("search", search);
        model.addAttribute("customers", customer);
        return "pages/customer";
    }
    @GetMapping("/nameSearch")
    public String nameSearch(Model model, @ModelAttribute("search") SearchViewModel search){
        Optional<Customer> customer = customerService.getDetailByName(search.getName());
        model.addAttribute("search", search);
        model.addAttribute("customers" ,customer);
        return "pages/customer";
    }



    //----------------------------------------------------------------------------------------------------

    @GetMapping()
    public String showCustomerPage(Model model, @ModelAttribute("search") SearchViewModel search) {
        model.addAttribute("search", search);
        List<Customer> customers = customerService.readAllCustomer();
        model.addAttribute("customers",
                customers);
        return "pages/customer";
    }
    @GetMapping("/{id}")
    public String showCustomerDetail(@PathVariable int id, Model model)
    {
        Optional<Customer> customer =
                customerService.readOneCustomer(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "pages/customer/CustomerDetails";
        } else {
            return showCustomerNotFound(model, id);
        }
    }
    @GetMapping("/edit/{id}")
    public String showEditCustomer(@PathVariable int id, Model model) {
        Optional<Customer> customer =
                customerService.readOneCustomer(id);
        List<Customer> customers =
                customerService.readAllCustomer();

        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            model.addAttribute("store", customers);
            model.addAttribute("countries", customers);

            return "pages/customer/customer_edit";
        } else {
            return showCustomerNotFound(model, id);
        }
    }

    @PostMapping("edituser")
    public RedirectView editCustomer(Customer customer) {
        final Timestamp lastDate = Timestamp.from(Instant.now());
        customer.setLastUpdate(lastDate);
        customer.setCreateDate(customerService.readOneCustomer(customer.getCustomerId()).orElseThrow().getCreateDate());
        log.info("************ " + customer);
        customerService.createCustomer(customer);
        return new RedirectView("/customer");
    }

    @GetMapping("adduser")
    public String showCustomerAddPage(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        model.addAttribute("stores", storeService.readAllStore());
        model.addAttribute("addresses",
                addressService.readAllAddress());
        return "pages/customer/customer_add";
    }


    @PostMapping("adduser")
    public RedirectView saveCustomer(CustomerDTO customerDTO) {
        final Timestamp createdDate = Timestamp.from(Instant.now());
        final Timestamp lastDate = Timestamp.from(Instant.now());
        final int customerId = 703;//GeneratorUtils.randomId();
        final Store store =
                storeService.readOne(Math.toIntExact(customerDTO.getStoreId())).orElseThrow(() -> new
                        IllegalArgumentException("Store not found"));
        final Address address =
                addressService.readOneAddress(Math.toIntExact(customerDTO.getAddressId())).orElseThrow(()
                        -> new IllegalArgumentException("Address not found"));
        final Customer customer =
                CustomerMapping.populateCustomer(customerDTO, address, store,
                        createdDate, lastDate, customerId);
        customerService.createCustomer(customer);
        return new RedirectView("/customer");
    }

    @GetMapping("deleteUser")
    public RedirectView deleteCustomer(@PathVariable int id, Model model){
        customerService.deleteCustomer(id);
        return new RedirectView("/customer");
    }


    private String showCustomerNotFound(Model model, int id) {
        model.addAttribute("id", id);
        return "pages/showCustomerNotFound";
    }

}
