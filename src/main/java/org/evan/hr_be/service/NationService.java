package org.evan.hr_be.service;

import org.apache.ibatis.annotations.Mapper;
import org.evan.hr_be.mapper.NationMapper;
import org.evan.hr_be.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 12/9/2023
 * @Github https://github.com/EvanFung
 */
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
