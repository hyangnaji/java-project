package ems.ele.dao;

import static ems.ele.db.JdbcUtils.close;
import static ems.ele.db.JdbcUtils.getConnection;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ems.ele.db.JdbcUtils;
import ems.ele.dto.Element;

public class ElementDAO {
	Connection conn = null;
	
	public int makedata() {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
				Scanner sc = new Scanner(new File("C:\\Users\\JSLHRD\\Desktop\\element\\element.txt"));
				Element element = null;
				conn = getConnection();
				
				while(sc.hasNextLine()) {
					String sql = "insert into element values(?, ?, ?, ?, ?)";
					String[] data = sc.nextLine().split(",");
					pstmt = conn.prepareStatement(sql);
					
					if(data[0].equals("") || data[0]==null) {
						break;
					}
					element = new Element();
					element.setNum(Integer.parseInt(data[0].trim()));
					element.setSymbol(data[1].trim());
					element.setName(data[2].trim());
					element.setCycle(Integer.parseInt(data[3].trim()));
					element.setRower(Integer.parseInt(data[4].trim()));
					
					pstmt.setInt(1, element.getNum());
					pstmt.setString(2, element.getSymbol());
					pstmt.setString(3, element.getName());
					pstmt.setInt(4, element.getCycle());
					pstmt.setInt(5, element.getRower());
					
					result = pstmt.executeUpdate();
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
		return result;
	}
	
	public int deletedata() {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "delete from element";
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
		return result;
	}
	
	//원자번호로 찾기
	public Element num(int num) {
		String sql = "select * from element where num = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Element ele = null;
		
		conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ele = new Element(rs.getInt("num"),rs.getString("symbol"),rs.getString("name"),rs.getInt("cycle"),rs.getInt("rower"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
			
		
		return ele;
	}
	
	//원소기호로 찾기
		public Element symbol(String symbol) {
			String sql = "select * from element where symbol = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Element ele = null;
			String symbol_1 = null, symbol_2 = null;
			
			if(symbol.length()==1) {
				symbol_1 = symbol.toUpperCase();
			}else {
				symbol_1 = symbol.substring(0, 1).toUpperCase();
				symbol_2 = symbol_1+symbol.substring(1, 2).toLowerCase();
			}			
			
			conn = getConnection();
						
			try {
				pstmt = conn.prepareStatement(sql);
				
				if(symbol.length()==1) {
					pstmt.setString(1, symbol_1);
				}else {
					pstmt.setString(1, symbol_2);
				}		
							
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					ele = new Element(rs.getInt("num"),rs.getString("symbol"),rs.getString("name"),rs.getInt("cycle"),rs.getInt("rower"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			return ele;
		}
	
	
		//원소이름으로 찾기
		public Element name(String name) {
			String sql = "select * from element where name = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Element ele = null;
			
			conn = getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, name);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ele = new Element(rs.getInt("num"),rs.getString("symbol"),rs.getString("name"),rs.getInt("cycle"),rs.getInt("rower"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
				
			
			return ele;
		}
		
		//주기로 찾기
		public List<Element> cycle(int cycle) {
			String sql = "select * from element where cycle = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Element> list = null;
			
			conn = getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				list = new ArrayList<Element>();
				
				pstmt.setInt(1, cycle);
				
				rs = pstmt.executeQuery();
				Element ele = null;
				
				while(rs.next()) {
					ele = new Element(rs.getInt("num"),rs.getString("symbol"),rs.getString("name"),rs.getInt("cycle"),rs.getInt("rower"));
					list.add(ele);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			
			return list;
		}
		
		//족으로 찾기
		public List<Element> rower(int rower) {
			String sql = "select * from element where rower = ?";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Element> list = null;
			
			
			conn = getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				list = new ArrayList<Element>();
				
				pstmt.setInt(1, rower);
				
				rs = pstmt.executeQuery();
				Element ele = null;
				
				while(rs.next()) {
					ele = new Element(rs.getInt("num"),rs.getString("symbol"),rs.getString("name"),rs.getInt("cycle"),rs.getInt("rower"));
					list.add(ele);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
				
			
			return list;
		}
		
		//전체보기
		public ArrayList<Element> view() {
			String sql = "select * from element order by num asc";
			
			ArrayList<Element> list = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				list = new ArrayList<Element>();
				Element ele = null;
				
				while(rs.next()) {
					ele = new Element(rs.getInt("num"),rs.getString("symbol"),rs.getString("name"),rs.getInt("cycle"),rs.getInt("rower"));
					list.add(ele);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			
			return list;
		}
	
}
