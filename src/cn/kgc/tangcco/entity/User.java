package cn.kgc.tangcco.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
用户
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
	private String id;
	@NonNull
	private String email;
	private String nickname;
	@NonNull
	private String password;
	private String confirm;

	private List<Role> roles; //角色

	

}
