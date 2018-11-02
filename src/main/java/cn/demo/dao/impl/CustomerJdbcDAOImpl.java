package cn.demo.dao.impl;

import java.util.List;

import cn.demo.dao.CustomerDAO;
import cn.demo.dao.DAO;
import cn.demo.dto.CustomerQueryReq;
import cn.demo.entity.Customer;

public class CustomerJdbcDAOImpl extends DAO<Customer> implements CustomerDAO {
	@Override
	public void addCustomer(Customer c) {
		String sql = "insert into customer (name,address,phone) values (?,?,?)";
		update(sql,c.getName(),c.getAddress(),c.getPhone());
	}

	@Override
	public void updateCustomer(Customer c) {
		String sql = "update customer set name=?,address=?,value=? where id=?";
		update(sql,c.getName(),c.getAddress(),c.getPhone(),c.getId());
	}

	@Override
	public void deleteCustomer(Integer id) {
		String sql = "delete from customer where id=?";
		update(sql,id);
	}

	@Override
	public Customer getCustomer(Integer id) {
		String sql = "select * from customer where id=?";
		Customer customer = getOne(sql, id);
		return customer;
	}

	@Override
	public List<Customer> getForList() {
		String sql = "select * from customer";
		List<Customer> customers = getForList(sql);
		return customers;
	}

	@Override
	public List<Customer> getForListWithCondition(CustomerQueryReq req) {
		String sql = "select * from customer where name like ? " +
				"and address like ? " +
				"and phone like ?";
		return getForList(sql,req.getName(),req.getAddress(),req.getPhone());
	}

	@Override
	public Long getCount() {
		String sql = "select count(id) from customer";
		Long value = getValue(sql);
		return value;
	}

	@Override
	public Long getCountWithName(String name) {
		String sql = "select count(id) from customer where name=?";
		Long count = getValue(sql, name);
		if (count == null) {
			count = 0L;
		}
		return count;
	}
}
