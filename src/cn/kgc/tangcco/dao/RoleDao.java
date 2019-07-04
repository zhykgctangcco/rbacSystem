package cn.kgc.tangcco.dao;

import java.util.List;

import cn.kgc.tangcco.entity.Role;

public interface RoleDao {
	List<Role>  queryRoleList();
	List<Role>  queryRoleByUserId(String userId);
    int updateUserRole(String userId,String[] roleIds) ;
}
