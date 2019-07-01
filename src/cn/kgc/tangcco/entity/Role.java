package cn.kgc.tangcco.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**
 *角色
 * @author Gaox
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Role {
	@NonNull
	private int id;
	@NonNull
	private String rolename;
	@NonNull
	private String description;
	private List<Privilege> privileges;//权限
}
