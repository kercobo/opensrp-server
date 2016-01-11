package org.opensrp.register.mcare.service;

import java.util.ArrayList;
import java.util.List;

import org.opensrp.dto.AclDTO;
import org.opensrp.dto.RoleDTO;
import org.opensrp.register.mcare.domain.Acl;
import org.opensrp.register.mcare.domain.Role;
import org.opensrp.register.mcare.repository.AllRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class RoleService {

	private static Logger logger = LoggerFactory.getLogger(RoleService.class
			.toString());
	private AllRoles allRoles;
	
	@Autowired
	public RoleService(AllRoles allRoles)
	{
		this.allRoles = allRoles;
	}
	
	public String addRole(RoleDTO roleDTO)
	{
		
		Role roleByUserName = allRoles.findByUserName(roleDTO.getUserName());
		if (roleByUserName == null) {
			try{
				Role role = new Role();
				role.withUserName(roleDTO.getUserName());
				role.withRoleName(roleDTO.getRoleName());
				role.withStatus(roleDTO.getStatus());
				 
				allRoles.add(role);
				return "1";
			}catch(Exception e){
				return "0";
			}
		}else{
			return "2";
		}
	}
	
	public String editRole(RoleDTO roleDTO) {		
		Role roles = allRoles.get(roleDTO.getRoleId());		
		try{
			Role role = new Role();
			role.withRoleName(roleDTO.getRoleName());
			role.setId(roleDTO.getRoleId());
			role.setRevision(roles.getRevision());			
			role.withUserName(roleDTO.getUserName());
			role.withStatus(roleDTO.getStatus());
			allRoles.update(role);
			return "1";
		}catch(Exception e){
			return "0";
		}
		
	}
	public ArrayList<RoleDTO> getRolesAndUser(){
		List<Role> roles = allRoles.roles();		
		ArrayList<RoleDTO> roleList = new ArrayList<RoleDTO>();
		for (Role role : roles) {
			RoleDTO roleDTO = new RoleDTO()
			.withRoleName(role.getRoleName())
			.withRoleId(role.getId())
			.withStatus(role.getStatus())
			.withUserName(role.getUserName());			
			roleList.add(roleDTO);			
		}		
		return roleList;
	}
}
