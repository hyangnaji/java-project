package ems.ele.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
		//����̹� �ε�
		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//Connection ��ü ���� �� ��ȯ
		public static Connection getConnection() {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userid = "track_java";
			String password = "1234";
			
			Connection conn = null;
			
			try {
				conn = DriverManager.getConnection(url, userid, password);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
			
		}		
		
		
		//�ڿ��� �ݱ� ���� �۾�
		public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Transaction ó���� ���� �۾�
		//cmdâ���� �����ͺ��̽��� ������ �� ����/���з� �Ǿ��ٴ� ���� �˷��ִ� ��
		//commit ���������� ���� �Ϸ�, rollback ���н� ���� �����ͺ��̽� ���·� �����ִ� ��
		public static void commit(Connection conn) {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void rollback(Connection conn) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
}//end of JdbcUtils 
