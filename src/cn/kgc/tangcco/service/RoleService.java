package cn.kgc.tangcco.service;

import java.util.List;

import cn.kgc.tangcco.entity.Role;

public interface RoleService {
	List<Role>  queryRoleList();
	List<Role>  queryRoleByUserId(String userId);
	int updateUserRole(String userId,String[] roleIds) ;
}
