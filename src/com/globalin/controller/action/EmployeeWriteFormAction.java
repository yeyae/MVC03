package com.globalin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeWriteFormAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������� �߰��ϴ�form�� ���� �������� �̵��� ���ָ� �ȴ�
		String url="/employee/employeewrite.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
		
	}
	

}
