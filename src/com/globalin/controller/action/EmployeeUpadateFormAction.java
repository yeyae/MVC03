package com.globalin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.dao.EmployeesDao;
import com.globalin.model.Employees;

public class EmployeeUpadateFormAction implements Action {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.globalin.controller.action.Action#execute(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");

		Employees emp = EmployeesDao.getInstance().getMember(id);

		req.setAttribute("employee", emp);

		String url = "employee/employeeUpdate.jsp";

		req.getRequestDispatcher(url).forward(req, resp);
	}

}
