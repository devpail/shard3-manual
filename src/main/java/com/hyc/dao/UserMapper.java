package com.hyc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 20:43
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByPrimaryKey(Long userId);

    List<User> selectByAge(int age);
}
