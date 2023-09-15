package org.evan.hr_be.controller.system.basic;

import org.evan.hr_be.model.JobLevel;
import org.evan.hr_be.model.RespBean;
import org.evan.hr_be.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 26/8/2023
 * @Github https://github.com/EvanFung
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;
    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if(jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("Added successfully");
        } else {
            return RespBean.error("Add failed");
        }
    }

    @PutMapping("/")
    public RespBean updateJobLevelById(@RequestBody  JobLevel jobLevel) {
        if(jobLevelService.updateJobLevelById(jobLevel) == 1) {
            return RespBean.ok("Updated successfully");
        } else {
            return RespBean.error("Update failed");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if(jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("Deleted successfully");
        } else {
            return RespBean.error("Delete failed");
        }
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(Integer[] ids) {
        if(jobLevelService.deleteJobLevelByIds(ids) == ids.length) {
            return RespBean.ok("Deleted successfully");
        } else {
            return RespBean.error("Delete failed");
        }
    }


}
