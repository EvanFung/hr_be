package org.evan.hr_be.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.evan.hr_be.model.Nation;

import java.util.List;
@Mapper
public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    List<Nation> getAllNations();
}