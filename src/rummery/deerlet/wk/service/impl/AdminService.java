package rummery.deerlet.wk.service.impl;

import rummery.deerlet.wk.dao.AdminDao;
import rummery.deerlet.wk.dao.IAdminDao;
import rummery.deerlet.wk.entity.Admin;
import rummery.deerlet.wk.exception.UserExistsException;
import rummery.deerlet.wk.service.IAdminService;

public class AdminService implements IAdminService {

	//调用dao 
	
	private AdminDao adminDao = new AdminDao();
	
	@Override
	public void register(Admin admin) throws UserExistsException {
		
		try {
		
			//1.根据用户名查询用户是否存在 
			boolean flag = adminDao.userExists(admin.getUserName());
		
			//2.如果用户存在 ，不允许注册
			if(flag){
				// 不允许注册, 给调用者提示
				throw new UserExistsException("用户名已经存在，注册失败！");
			}
			
			// 3. 用户不存在，才可以注册
			adminDao.save(admin);
		}catch(UserExistsException e){
			throw e;
			
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	//登录
	@Override
	public Admin login(Admin admin) {
		return adminDao.findByNameAndPwd(admin);
	}

}
