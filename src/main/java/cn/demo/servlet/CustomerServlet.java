package cn.demo.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.demo.dao.CustomerDAO;
import cn.demo.dao.impl.CustomerJdbcDAOImpl;
import cn.demo.dto.CustomerQueryReq;
import cn.demo.entity.Customer;

public class CustomerServlet extends HttpServlet {

	private CustomerDAO customerDAO = new CustomerJdbcDAOImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1,servletPath.indexOf("."));
		try {
			Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request,response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("query");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		CustomerQueryReq req = new CustomerQueryReq(name, address, phone);
//		List<Customer> customers = customerDAO.getForList();
		List<Customer> customers = customerDAO.getForListWithCondition(req);
		request.setAttribute("customers",customers);
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Long countWithName = customerDAO.getCountWithName(name);
		if (countWithName > 0) {
			request.setAttribute("error_msg","名字重复");
			request.getRequestDispatcher("/add_customer.jsp").forward(request,response);
			return;
		}
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhone(phone);
		customerDAO.addCustomer(customer);
		response.sendRedirect("/mvc/success.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete");
		String idStr = request.getParameter("id");
		int id = 0;
		try{
			id = Integer.parseInt(idStr);
			customerDAO.deleteCustomer(id);
		}catch (Exception e){

		}
		response.sendRedirect("/mvc/query.do");

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("edit");
	}

}
