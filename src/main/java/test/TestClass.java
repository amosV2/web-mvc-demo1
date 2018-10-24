package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.demo.dao.impl.CustomerDAOImpl;
import cn.demo.entity.Customer;
import cn.demo.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

public class TestClass {

	@Test
	public void testGetConn() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}

	@Test
	public void testGetAll(){
		CustomerDAOImpl customerDAO = new CustomerDAOImpl();
		List<Customer> all = customerDAO.getAll();
		System.out.println(all);
	}

	@Test
	public void testGetOne(){
		CustomerDAOImpl customerDAO = new CustomerDAOImpl();
		Customer one = customerDAO.getOne(1);
		System.out.println(one);
	}

}
