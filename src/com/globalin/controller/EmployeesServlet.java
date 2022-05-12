package com.globalin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.controller.action.Action;

@WebServlet("/employee")
public class EmployeesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(req, resp);
	}

	protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// command�Ķ���� ��������

		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		System.out.println(command);
		// ��û�� ó������ action��ü�� ���� �����ϱ�
		// 1.action ���丮 �����
		ActionFactory af = ActionFactory.getInstance();
		// 2.action���丮�� getAction(command)�޼ҵ� ȣ���ؼ�
		// command�� �´� action��ü����
		Action action = af.getAction(command);
		// 3.action��ü�� excute()�޼ҵ� ����

		if (action != null) {
			action.execute(req, resp);
		}
	}

}
