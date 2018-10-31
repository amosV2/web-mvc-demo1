package cn.demo.dao;

import java.util.List;

import cn.demo.dto.CustomerQueryReq;
import cn.demo.entity.Customer;

public interface CustomerDAO {

	void addCustomer(Customer c);

	void updateCustomer(Customer c);

	void deleteCustomer(Integer id);

	Customer getCustomer(Integer id);

	List<Customer> getForList();

	List<Customer> getForListWithCondition(CustomerQueryReq req);

	Long getCount();
}
