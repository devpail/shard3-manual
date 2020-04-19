package com.hyc.util;

import com.hyc.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhangzhb
 * @create: 2020-04-18 21:16
 **/
@Service
public class SnowflakeIdGenerator {

    SnowflakeShardingKeyGenerator generator = new SnowflakeShardingKeyGenerator(0,0);

    public Long nextId() {
        return generator.generateKey().longValue();
    }
}
