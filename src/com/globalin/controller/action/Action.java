package com.globalin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
//ACTION�̶�� �������̽���
	//SERVLET�� ó���� ��û�� ������ ����
	//���� EMPLOYEES�� �����ϴ� ��û�� �Ӵ�
	//�׿�û��EMPLOYEESWRITEACTION�̶���̸��� ������
	//EMPLOYEESWRITEACTION�� ��û�� �޾Ƽ� db�� ��������� �������ִ� ��Ȱ����
	//�츮�� ������ contexpath/requesturi�� ��θ� �߶� ó���ߴ�
	//else-if�б��ϳ��� action�ϳ��� ó���ϴ� ��ó�� ����
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
