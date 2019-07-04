package cn.kgc.tangcco.service.impl;

import java.util.List;

import cn.kgc.tangcco.dao.RoleDao;
import cn.kgc.tangcco.entity.Role;
import cn.kgc.tangcco.service.RoleService;
import cn.kgc.tangcco.util.PropertiesFactory;

public class RoleServiceImpl implements RoleService{
	private RoleDao roleDao;
	public RoleServiceImpl() {
		roleDao=(RoleDao) PropertiesFactory.getInstance("roleDao");
	}

	@Override
	public List<Role> queryRoleList() {
		return roleDao.queryRoleList();
	}

	@Override
	public List<Role> queryRoleByUserId(String userId) {
		return roleDao.queryRoleByUserId(userId);
	}

	@Override
	public int updateUserRole(String userId, String[] roleIds) {
		return roleDao.updateUserRole(userId, roleIds);
	}
	

}
