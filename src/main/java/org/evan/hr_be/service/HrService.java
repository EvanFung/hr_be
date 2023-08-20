package org.evan.hr_be.service;

import org.evan.hr_be.mapper.HrMapper;
import org.evan.hr_be.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if (hr == null) {
            throw new UsernameNotFoundException("username is incorrect");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        hr.getRoles().forEach((role) -> {
            System.out.println(hr.getName() + " " +role.getName());
        });
        return hr;
    }
}