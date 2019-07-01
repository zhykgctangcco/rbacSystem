package cn.kgc.tangcco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限
 * 
 * @author love5
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Privilege {

	private int id;
	private String privilegename;
	private String privilegeUrl;
	private String requestaction;
	private String description;
}
