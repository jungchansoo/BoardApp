package com.ssamz.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssamz.biz.common.JDBCUtil;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String USER_LIST = "select * from users";
	private String USER_INSERT = "insert into users values(?,?,?,?)";
	private String USER_UPDATE = "update users set name=?, role=? where id=?";
	private String USER_DELETE = "delete users where id=?";
	private String USER_GET = "select * from users where id=?";
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	
	public void deleteUser(String id) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, id);
			
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public void updateUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getRole());
			stmt.setString(3, vo.getId());
			
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				userList.add(user);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return userList;
	}
}
