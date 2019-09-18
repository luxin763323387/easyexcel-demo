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

    /**
     * index取决与excel列的位置
     * 强制读取第三个 这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
     */
    @ExcelProperty(index = 0)
    private String username;


    @ExcelProperty(index = 1)
    private String password;

    @ExcelProperty(index = 2)
    private String phone;
}
