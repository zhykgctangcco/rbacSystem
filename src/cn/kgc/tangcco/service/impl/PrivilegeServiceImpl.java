package cn.kgc.tangcco.service.impl;

import java.util.List;

import cn.kgc.tangcco.dao.PrivilegeDao;
import cn.kgc.tangcco.entity.Privilege;
import cn.kgc.tangcco.service.PrivilegeService;
import cn.kgc.tangcco.util.PropertiesFactory;

public class PrivilegeServiceImpl implements PrivilegeService{
    private PrivilegeDao privilegedao;
    public PrivilegeServiceImpl() {
    	privilegedao=(PrivilegeDao)PropertiesFactory.getInstance("privilegeDao");
	}
	@Override
	public List<Privilege> queryPrivilegeByUser(String userId) {
		return privilegedao.queryPrivilegeByUser(userId);
	}
	@Override
	public List<Privilege> queryPrivilegeByRole(int roleId) {
		return privilegedao.queryPrivilegeByRole(roleId);
	}
	@Override
	public List<Privilege> queryAllPrivilege() {
		return privilegedao.queryAllPrivilege();
	}
	@Override
	public int UpdateRolePrivilege(int roleId, String[] arr) {
		return privilegedao.UpdateRolePrivilege(roleId, arr);
	}

}
