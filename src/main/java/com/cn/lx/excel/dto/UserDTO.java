package com.cn.lx.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author StevenLu
 * @date 2019-09-17 16:39
 */
@Data
public class UserDTO extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String username;

    @ExcelProperty(index = 1)
    private String password;

    @ExcelProperty(index = 2)
    private String phone;
}
