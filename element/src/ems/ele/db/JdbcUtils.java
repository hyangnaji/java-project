package ems.ele.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
		//드라이버 로딩
		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//Connection 객체 생성 후 반환
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
		
		
		//자원을 닫기 위한 작업
		public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Transaction 처리를 위한 작업
		//cmd창에서 데이터베이스를 수정할 시 성공/실패로 되었다는 것을 알려주는 것
		//commit 성공적으로 수정 완료, rollback 실패시 원래 데이터베이스 상태로 돌려주는 것
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
