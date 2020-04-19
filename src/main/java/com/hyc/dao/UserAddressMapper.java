package com.hyc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyc.entity.User;
import com.hyc.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 20:43
 **/
@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress> {
}
