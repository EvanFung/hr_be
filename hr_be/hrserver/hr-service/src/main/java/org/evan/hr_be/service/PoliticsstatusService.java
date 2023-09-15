package org.evan.hr_be.service;

import org.evan.hr_be.mapper.PoliticsstatusMapper;
import org.evan.hr_be.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 12/9/2023
 * @Github https://github.com/EvanFung
 */
@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
