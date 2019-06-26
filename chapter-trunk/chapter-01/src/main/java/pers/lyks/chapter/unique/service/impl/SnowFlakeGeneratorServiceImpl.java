package pers.lyks.chapter.unique.service.impl;

import org.springframework.stereotype.Service;
import pers.lyks.chapter.unique.generator.SnowflakeWorker;
import pers.lyks.chapter.unique.service.GeneratorService;

/**
 * @author lawyerance
 * @version 1.0 2019-06-22
 */
@Service("snowFlakeGeneratorService")
public class SnowFlakeGeneratorServiceImpl implements GeneratorService {

    SnowflakeWorker worker = new SnowflakeWorker(2, 3);

    @Override
    public String next() {
        return String.valueOf(worker.nextId());
    }
}
