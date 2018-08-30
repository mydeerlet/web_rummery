package rummery.deerlet.wk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import javax.persistence.Temporal;

import org.junit.Test;

import rummery.deerlet.wk.entity.Admin;
import rummery.deerlet.wk.utils.JDBCUtil;



/**
 * 2.数据接口层的实现类
 * @author Administrator
 *
 */

public  class AdminDao implements IAdminDao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;


	@Override
	public void save(Admin admin) {
		
		String sql= "INSERT INTO admin (userName , pwd) VALUES (? , ?);";
		
		con = JDBCUtil.getConnection();
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getUserName());
			pstmt.setString(2, admin.getPwd());
			//执行
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally{
			JDBCUtil.closeAll(con, pstmt, null);
		}
	}

	@Override
	public Admin findByNameAndPwd(Admin admin) {
		String sql= "SELECT * FROM admin where userName=? and pwd=?;";
		Admin ad=null;
		
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getUserName());
			pstmt.setString(2, admin.getPwd());
			
			//执行
			rs= pstmt.executeQuery();
			
			while (rs.next()) {
	
				ad = new Admin();
				ad.setId(rs.getInt("id"));
				ad.setUserName(rs.getString("userName"));
				ad.setPwd(rs.getString("pwd"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(con, pstmt, rs);
		}
		return ad;
		
	}

	@Override
	public boolean userExists(String name) {
		
		
		String sql= "SELECT 1 FROM admin where userName=? ;";
		
		con = JDBCUtil.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			
			//执行
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				int id=rs.getInt(1);
				if(id>0){
					return true;
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(con, pstmt, rs);
		}
		
		
		return false;
		
	}

}
