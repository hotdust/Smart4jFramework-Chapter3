package org.smart4j.chapter3.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.smart4j.chapter3.model.Customer;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.annotation.Transaction;
import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.framework.helper.ServletHelper;

/**
 * 提供客户数据服务
 */
@Service
public class CustomerService {

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT * FROM customer";
        List<Customer> customerList = DatabaseHelper.queryEntityList(Customer.class, sql);

        // test set attribute
        ServletHelper.setRequestAttribute("greeting", "hello");

        return customerList;
//        return new ArrayList<Customer>();
    }

    /**
     * 获取客户
     */
    @Transaction
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }

    /**
     * 正常事务
     */
    @Transaction
    public void testTransaction_normal() {
        insertUserLogic_1();
        insertUserLogic_2();
    }


    /**
     * 在两个业务中间抛异常
     */
    @Transaction
    public void testTransaction_exceptionBetweenLogic() {
        insertUserLogic_1();
        throwException();
        insertUserLogic_2();
    }



    private void insertUserLogic_1() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "aaa");
        createCustomer(userMap);
    }

    private void insertUserLogic_2() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "bbb");
        createCustomer(userMap);
    }


    private void throwException() {
        throw new RuntimeException("---------- exception ------------");
    }
}
