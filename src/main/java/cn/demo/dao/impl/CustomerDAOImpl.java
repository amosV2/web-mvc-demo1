package cn.demo.dao.impl;

import java.util.List;

import cn.demo.dao.CustomerDAO;
import cn.demo.dao.DAO;
import cn.demo.entity.Customer;

public class CustomerDAOImpl extends DAO<Customer> implements CustomerDAO {
	@Override
	public void save(Customer customer) {
		String sql = "insert into customer(name,address,phone) values(?,?,?)";
		update(sql,customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public void update(Customer customer) {
		String sql = "update customer set name=?,address=?,phone=?"
				+ "where id=?";
		update(sql,customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from customer where id=?";
		update(sql,id);
	}

	@Override
	public List<Customer> getAll() {
		String sql = "select * from customer";
		return getForList(sql);
	}

	@Override
	public Customer getOne(Integer id) {
		String sql = "select * from customer where id=?";
		return get(sql,id);
	}
}
