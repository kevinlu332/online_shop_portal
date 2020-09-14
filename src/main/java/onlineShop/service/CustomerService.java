package onlineShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineShop.dao.CustomerDao;
import onlineShop.model.Customer;

//@service means this class is at service layer
//   to indicate it's holding the business logic
@Service
public class CustomerService {
    
    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {   	 
   	 customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String userName) {
   	 return customerDao.getCustomerByUserName(userName);
    }
}
