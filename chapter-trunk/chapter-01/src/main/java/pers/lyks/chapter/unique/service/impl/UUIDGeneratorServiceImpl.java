package pers.lyks.chapter.unique.service.impl;

import org.springframework.stereotype.Service;
import pers.lyks.chapter.unique.service.GeneratorService;

import java.util.UUID;

/**
 * @author lawyerance
 * @version 1.0 2019-06-22
 */
@Service("uuidGeneratorService")
public class UUIDGeneratorServiceImpl implements GeneratorService {
    @Override
    public String next() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
