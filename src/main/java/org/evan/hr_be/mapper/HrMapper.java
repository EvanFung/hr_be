package org.evan.hr_be.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.evan.hr_be.model.Hr;
@Mapper
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);
}