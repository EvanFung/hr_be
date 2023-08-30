package org.evan.hr_be.service;

import org.evan.hr_be.mapper.RoleMapper;
import org.evan.hr_be.model.Menu;
import org.evan.hr_be.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 27/8/2023
 * @Github https://github.com/EvanFung
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if(!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insertSelective(role);
    }
}
