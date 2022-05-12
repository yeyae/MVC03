package com.globalin.test;



import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import com.globalin.dao.EmployeesDao;
import com.globalin.model.Employees;

public class DaoTest {
	
private static EmployeesDao dao =EmployeesDao.getInstance();	
	
	
	
	
	@Test
	public void testSelect() {
		Employees e =dao.getMember("admin");
		System.out.println(e);
		//"������":��밪
		//e.getName:������
		//assertEquals�޼ҵ�:�׽�Ʈ���� ��� �� ���̰��� ���̴ٶ����
		//�ΰ��� �ٸ��� �׽�Ʈ ����
		//�ΰ��� ������ �׽�Ʈ����
		assertEquals("������",e.getName());
		        List <Employees >list=dao.selectAllEmployees();
		        System.out.println(list.get(0));
		        //1:��밪
		        //list.size():������
		        //assertEquals(1, list.size());
		        
		       int result=dao.deleteMember("hyewon");
		       Employees e1= dao.getMember("hyewon");
		       //e1��ü�� null�ϰ��̴ٶ�� ����
		       assertNull(e1);
				
	
	}

}
