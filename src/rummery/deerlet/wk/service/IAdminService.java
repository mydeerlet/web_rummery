package rummery.deerlet.wk.service;

import rummery.deerlet.wk.entity.Admin;
import rummery.deerlet.wk.exception.UserExistsException;

public interface IAdminService {

	/**
	 * 注册
	 * @throws UserExistsException 
	 */

	void register(Admin admin) throws UserExistsException;
	
	
	/**
	 * 登录
	 */
	Admin login(Admin admin);
}
