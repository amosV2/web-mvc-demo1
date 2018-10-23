package test;

import java.sql.Connection;
import java.sql.SQLException;

import cn.demo.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

public class TestClass {

	@Test
	public void testGetConn() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}


}
