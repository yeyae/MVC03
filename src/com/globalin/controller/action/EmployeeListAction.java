package com.globalin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.dao.EmployeesDao;
import com.globalin.model.Employees;

//�׼�Ŭ������ command=employee_list��û�� ó��
public class EmployeeListAction  implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//�� url�� ��û�Ŀ� �̵��� �������ּ�
		String url="/employee/employeeList.jsp";
		//���⼭ ó�������� db���� ������� ��� ��������
		//request�� ��Ƽ� ������
		EmployeesDao dao=EmployeesDao.getInstance();
		
		List<Employees> list=dao.selectAllEmployees();
		
		req.setAttribute("elist", list);
		System.out.println(list);
		//request��"elist"��� �̸�����list�� ��Ƽ� ������
		//���߿� request���� ���� ������ "elist"��� �̸����� ���� ���� �ȴ�
		
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
