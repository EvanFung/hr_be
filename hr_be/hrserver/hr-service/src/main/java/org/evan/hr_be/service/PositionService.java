package org.evan.hr_be.service;

import org.evan.hr_be.mapper.PositionMapper;
import org.evan.hr_be.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Evan Feng
 * @Date 24/8/2023
 * @Github https://github.com/EvanFung
 */
@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;
    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public int updatePositions(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public int deletePositionById(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public int deletePositionsByIds(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }
}
