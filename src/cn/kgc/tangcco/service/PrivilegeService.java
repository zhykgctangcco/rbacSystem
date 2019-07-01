package cn.kgc.tangcco.service;

import java.util.List;

import cn.kgc.tangcco.entity.Privilege;

public interface PrivilegeService {
    public List<Privilege> queryPrivilegeByUser(String userId);
    public List<Privilege> queryPrivilegeByRole(int roleId);
    public List<Privilege> queryAllPrivilege();
    public int UpdateRolePrivilege(int roleId,String[]arr);
}
