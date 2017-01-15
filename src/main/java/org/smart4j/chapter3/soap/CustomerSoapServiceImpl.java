package org.smart4j.chapter3.soap;

import org.smart4j.chapter3.model.Customer;
import org.smart4j.chapter3.service.CustomerService;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.annotation.Service;
import org.smart4j.plugin.soap.Soap;

/**
 * Created by shijiapeng on 17/1/9.
 * 访问路径：http://localhost:8080/chapter3/soap/CustomerSoapService?wsdl
 * 注意：上面的访问路径，是已经把Deployment的ApplicationContext设置成了"/chapter3"
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
