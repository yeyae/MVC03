package com.globalin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.globalin.model.Employees;
import com.globalin.util.DBManager;

public class EmployeesDao {
	// �̱��� ����
	// 1.�⺻�����ڸ� �����̺���Ʈ ���������ڷ� �����
	private EmployeesDao() {

	}

	// 2.�ڱ��ڽ� Ÿ���� ���� ���� ���� �����(static Employeesdao),��������private
	private static EmployeesDao instance = new EmployeesDao();

	// 3.�ܺο��� ���� ������ �ִ� ������ ����Ҽ� �ֵ��� getter �޼ҵ� ������ֱ�
	public static EmployeesDao getInstance() {
		return instance;
		// EmployeesDao.getInstance()�� �ܺο��� ȣ���ؾ� ��밡��
		// �ܺο��� new EmployeesDao()�ΰ�ü������ �Ұ����ϴ�
	}

	// ������� 1�� ��������(id��)
	// ����Ÿ��:Employees
	// �Ķ����:String id
	public Employees getMember(String id) {
		// ������ ��� ����
		Employees result = null;
		// ���ᰴü
		Connection conn = null;
		// sql�� ���� ��ü
		PreparedStatement pstmt = null;
		// select�� ó���� ���� ��� ��ü
		ResultSet rs = null;
		// ������ sql��
		String sql = "select * from employees where id=?";
		// ���ᰡ������
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			// ��������
			rs = pstmt.executeQuery();
			// ���ó��
			if (rs.next()) {
				result = new Employees();
				result.setId(rs.getString("id"));
				result.setPass(rs.getString("pass"));
				result.setName(rs.getString("name"));
				result.setLev(rs.getString("lev"));
				result.setPhone(rs.getString("phone"));
				result.setGender(rs.getInt("gender"));
				result.setEnter(rs.getTimestamp("enter"));
				// rs.getDate("enter");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}

	public List<Employees> selectAllEmployees() {
		// ������ ��� ����
		List<Employees> result = new ArrayList<Employees>();
		// ���ᰴü
		Connection conn = null;
		// sql���� ��ü
		PreparedStatement pstmt = null;
		// ������ sql��
		String sql = "select * from employees order by enter desc";
		// sql������
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			// ��������
			rs = pstmt.executeQuery();
			// ���ó��
			while (rs.next()) {
				Employees e = new Employees();
				e.setId(rs.getString("id"));
				e.setPass(rs.getString("pass"));
				e.setName(rs.getString("name"));
				e.setLev(rs.getString("lev"));
				e.setPhone(rs.getString("phone"));
				e.setGender(rs.getInt("gender"));
				e.setEnter(rs.getTimestamp("enter"));
				result.add(e);
				// rs.getDate("enter");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}

//������� �����ϱ�
//����Ÿ��:int(���н� 0,������ ������ ������ŭ)
//�Ķ����:������� employees��ü
	public int insertMember(Employees member) {
		// ���԰��(����or����)
		int result = 0;
		// ���ᰴü
		Connection conn = null;
		// sql���ఴü
		PreparedStatement pstmt = null;
		// ������sql��
		String sql = "insert into employees values(?,?,?,?,sysdate,?,?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getLev());
			pstmt.setInt(5, member.getGender());
			pstmt.setString(6, member.getPhone());

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}

	public int updateMember(Employees member) {
		// ������
		int result = -1;
		// ���ᰴü
		Connection conn = null;
		// sql���ఴü
		PreparedStatement pstmt = null;
		// ������ sql��
		String sql = "update employees set name=?,gender=?,pass=?,lev=?," + "phone=?where id=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setInt(2, member.getGender());
			pstmt.setString(3, member.getPass());
			pstmt.setString(4, member.getLev());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getId());

			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}

//������� �������
//����Ÿ��:int(0�̸� ������ �� ����,0�� �ƴϸ� ������ �� ����)
//�Ķ����:String id
	public int deleteMember(String id) {
		// ������
		int result = -1;
		// ���ᰴü
		Connection conn = null;
		// sql���ఴü
		PreparedStatement pstmt = null;
		// ������ sql��
		String sql = "delete from employees where id=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}

}
