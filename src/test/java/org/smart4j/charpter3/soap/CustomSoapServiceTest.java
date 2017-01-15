package org.smart4j.charpter3.soap;

import org.junit.Assert;
import org.junit.Test;
import org.smart4j.chapter3.model.Customer;
import org.smart4j.chapter3.soap.CustomerSoapService;
import org.smart4j.plugin.soap.SoapHelper;

/**
 * Created by shijiapeng on 17/1/9.
 */
public class CustomSoapServiceTest {

    @Test
    public void getCustomerTest() {
//        String wsdl = "http://localhost:8080/soap/CustomerSoapService";
        String wsdl = "http://localhost:8080/chapter3/soap/CustomerSoapService";
        CustomerSoapService customerSoapService =
                SoapHelper.createClient(wsdl, CustomerSoapService.class);
        Customer customer = customerSoapService.getCustomer(1);
        Assert.assertNotNull(customer);

    }
}
