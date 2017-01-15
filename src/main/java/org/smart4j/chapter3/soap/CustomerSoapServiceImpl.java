package org.smart4j.chapter3.soap;

import org.smart4j.chapter3.model.Customer;
import org.smart4j.chapter3.service.CustomerService;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.annotation.Service;
import org.smart4j.plugin.soap.Soap;

/**
 * Created by shijiapeng on 17/1/9.
 */
@Service
@Soap
public class CustomerSoapServiceImpl implements CustomerSoapService {

    @Inject
    private CustomerService customerService;

    @Override
    public Customer getCustomer(long customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return customer;
    }
}
