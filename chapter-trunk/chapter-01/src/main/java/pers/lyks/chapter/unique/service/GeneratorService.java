package pers.lyks.chapter.unique.service;

/**
 * 生成主键id的接口
 *
 * @author lawyerance
 * @version 1.0 2019-06-22
 */
public interface GeneratorService {

    /**
     * 调用方法生成主键方法
     *
     * @return 主键值
     */
    String next();

}
