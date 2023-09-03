package org.evan.hr_be.utils;

import org.evan.hr_be.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author Evan Feng
 * @Date 2/9/2023
 * @Github https://github.com/EvanFung
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
