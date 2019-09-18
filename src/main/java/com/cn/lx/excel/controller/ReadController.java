package com.cn.lx.excel.controller;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.EasyExcelTempFile;
import com.alibaba.fastjson.JSON;
import com.cn.lx.excel.dto.UserDTO;
import com.cn.lx.excel.entity.User;
import com.cn.lx.excel.read.DemoDataListener;
import com.cn.lx.excel.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.tomcat.util.file.ConfigFileLoader.getInputStream;

/**
 * @author StevenLu
 * @date 2019-09-17 13:38
 */
@Slf4j
@RestController
@RequestMapping("/test/")
public class ReadController {

    @Autowired
    private IUserService userService;

    @Autowired
    private DemoDataListener demoDataListener;

    @GetMapping("readExcel")
    public void readExcel() throws IOException {
        InputStream inputStream = getInputStream("/Users/stevenlu/Desktop/User.xls");
        //String fileName = "/Users/stevenlu/Desktop/User.xls";
        try {
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, demoDataListener);
            excelReader.read(new Sheet(1,1,UserDTO.class));
        }catch (Exception e){
            log.info("异常信息:{}",e.getMessage());
        }finally {
            try {
                inputStream.close();
            }catch (IOException e){
                e.getMessage();
            }
        }
    }

    /**
     * 多个sheet读
     * @throws IOException
     */
    @GetMapping("readExcels")
    public void readExcels() throws IOException {
        InputStream inputStream = getInputStream("/Users/stevenlu/Desktop/User.xls");
        //String fileName = "/Users/stevenlu/Desktop/User.xls";
        try {
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, demoDataListener);
            excelReader.read(new Sheet(1,1,UserDTO.class));
            excelReader.read(new Sheet(2,1,UserDTO.class));
        }catch (Exception e){
            log.info("异常信息:{}",e.getMessage());
        }finally {
            try {
                inputStream.close();
            }catch (IOException e){
                e.getMessage();
            }
        }
    }



    @GetMapping("hello")
    public String helloworld(){

        List<User> users = new ArrayList<>();
        users.add(new User("lx","123","1415"));
        users.add(new User("lx","123","1415"));
        users.add(new User("lx","123","1415"));

        log.info("测试:{}", JSON.toJSON(users));
        userService.insertUsers(users);
        return "hello";
    }

}
