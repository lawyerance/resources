package pers.lyks.chapter.unique;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pers.lyks.chapter.unique.service.GeneratorService;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;

/**
 * @author lawyerance
 * @version 1.0 2019-06-26
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    final int threadNum = 100;
    private CountDownLatch downLatch = new CountDownLatch(threadNum);

    @Autowired
    @Qualifier("redisGeneratorService")
    private GeneratorService generatorService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("start......");
        for (int i = 0; i < threadNum; i++) {
            Runnable r = () -> {
                String next = generatorService.next();
                System.out.println(next);
                downLatch.countDown();
            };
            new Thread(r).start();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
}
