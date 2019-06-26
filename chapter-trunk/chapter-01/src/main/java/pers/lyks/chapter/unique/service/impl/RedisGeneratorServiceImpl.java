package pers.lyks.chapter.unique.service.impl;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import pers.lyks.chapter.unique.service.GeneratorService;

import javax.annotation.Resource;

/**
 * @author lawyerance
 * @version 1.0 2019-06-26
 */
@Service("redisGeneratorService")
public class RedisGeneratorServiceImpl implements GeneratorService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    private String key="object:id";
    @Override
    public String next() {
        Long increment = stringRedisTemplate.opsForValue().increment(key);
        return increment.toString();
    }
}
