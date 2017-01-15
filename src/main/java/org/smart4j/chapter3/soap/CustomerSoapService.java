package org.smart4j.chapter3.soap;

import org.smart4j.chapter3.model.Customer;

/**
 * 客户SOAP接口
 * Created by shijiapeng on 17/1/9.
 */
public interface CustomerSoapService {

    Customer getCustomer(long customerId);
}
