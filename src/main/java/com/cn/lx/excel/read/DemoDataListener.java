package com.cn.lx.excel.read;

import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.cn.lx.excel.dto.UserDTO;
import com.cn.lx.excel.entity.User;
import com.cn.lx.excel.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author StevenLu
 * @date 2019-09-16 12:44
 */
@Slf4j
@Component
public class DemoDataListener extends AnalysisEventListener<UserDTO> {

    @Autowired
    private IUserService iUserService;

    /**
     * 每隔3000条存储数据库
     */
    private static final int BATCH_COUNT = 300;
    private List<UserDTO> list = new ArrayList<UserDTO>();

    /**
     * 执行解析
     * @param userDTO
     * @param analysisContext
     */
    @Override
    public void invoke(UserDTO userDTO, AnalysisContext analysisContext) {
        log.info("解析一条数据:{}", JSON.toJSON(userDTO));
        list.add(userDTO);
        if(list.size() >= BATCH_COUNT){
            saveData(list);
            list.clear();
        }
    }

    /**
     * 结束后执行其他方法
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        saveData(list);
        log.info("所以数据解析完成");
    }

    private void saveData(List<UserDTO> userDTOList){

        log.info("{}条数据，开始存储数据库！", list.size());
        List<User> users = userDTOList.stream().map(e -> {
            User user = new User();
            BeanUtils.copyProperties(e, user);
            return user;
        }).collect(Collectors.toList());
        iUserService.insertUsers(users);
        log.info("存储结束");
    }
}
