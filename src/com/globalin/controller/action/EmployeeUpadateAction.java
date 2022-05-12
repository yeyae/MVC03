package com.globalin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.dao.EmployeesDao;
import com.globalin.model.Employees;

public class EmployeeUpadateAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// employee��ü�ϳ�����
		Employees emp = new Employees();
		// �� �ʵ带 �Ķ���� �����ͼ� ä���ְ�
		emp.setId(req.getParameter("id"));
		emp.setPass(req.getParameter("pass"));
		emp.setName(req.getParameter("name"));
		emp.setLev(req.getParameter("lev"));
		emp.setGender(Integer.parseInt(req.getParameter("gender")));
		emp.setPhone(req.getParameter("phone"));

		// dao�����ؼ� db�� ���� ���ָ� �˴ϴ�
		int result = EmployeesDao.getInstance().updateMember(emp);
		// EmployeesDao dao=EmployeesDao.getInstance();
		// dao.insertMember(emp);

		// �����ϰ� ���� list�������� �̵�
		new EmployeeListAction().execute(req, resp);
	}

}
