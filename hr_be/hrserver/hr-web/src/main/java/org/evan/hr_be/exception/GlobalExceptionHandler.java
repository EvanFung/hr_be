package org.evan.hr_be.exception;

import org.evan.hr_be.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @Author Evan Feng
 * @Date 24/8/2023
 * @Github https://github.com/EvanFung
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error("Cannot delete this data because it is used by other tables");
        }
        return RespBean.error("Database error, please contact the administrator");
    }
}
