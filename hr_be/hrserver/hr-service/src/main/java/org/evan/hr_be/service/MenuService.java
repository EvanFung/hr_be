package org.evan.hr_be.service;

import org.evan.hr_be.mapper.MenuMapper;
import org.evan.hr_be.mapper.MenuRoleMapper;
import org.evan.hr_be.model.Hr;
import org.evan.hr_be.model.Menu;
import org.evan.hr_be.model.MenuRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 17/8/2023
 * @Github https://github.com/EvanFung
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByHrId() {
        //can't use parameters which passed from front end
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

//    @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        //delete all the menus which have the same rid
        menuRoleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        return result==mids.length;
    }
}
