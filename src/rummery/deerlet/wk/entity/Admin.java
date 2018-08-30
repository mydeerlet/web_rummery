package rummery.deerlet.wk.entity;


/**
 * 1.管理员模块。javabean 实体类设计
 * @author Administrator
 *
 */

public class Admin {

	private int id;
	private String userName;
	private String pwd;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
