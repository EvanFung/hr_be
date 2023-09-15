package org.evan.hr_be.model;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 8/9/2023
 * @Github https://github.com/EvanFung
 */
public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
