package org.evan.hr_be.controller.system.basic;

import org.evan.hr_be.model.Position;
import org.evan.hr_be.model.RespBean;
import org.evan.hr_be.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 24/8/2023
 * @Github https://github.com/EvanFung
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;
    @GetMapping ("/")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        if(positionService.addPosition(position) == 1) {
            return RespBean.ok("Added successfully");
        } else {
            return RespBean.error("Add failed");
        }
    }

    @PutMapping("/")
    public RespBean updatePositions(@RequestBody Position position) {
        if (positionService.updatePositions(position) == 1) {
            return RespBean.ok("Updated successfully");
        }
        return RespBean.error("Update failed");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id) {
        if(positionService.deletePositionById(id) == 1) {
            return RespBean.ok("Deleted successfully");
        } else {
            return RespBean.error("Delete failed");
        }
    }

    @DeleteMapping("/")
    public RespBean deletePositionsByIds(Integer[] ids) {
        if(positionService.deletePositionsByIds(ids) == ids.length) {
            return RespBean.ok("Deleted successfully");
        } else {
            return RespBean.error("Delete failed");
        }
    }
}
