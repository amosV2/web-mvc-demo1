package cn.demo.dao;

import java.util.List;

import cn.demo.entity.Customer;

public interface CustomerDAO {

	void save(Customer customer);

	void update(Customer customer);

	void delete(Integer id);

	List<Customer> getAll();

	Customer getOne(Integer id);


}
