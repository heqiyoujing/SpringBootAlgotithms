package spring.boot.com.设计模式.Builder建造者;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 装机人员装机
 */
public class Director {
    public void Construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainBoard();
        builder.buildHD();
    }
}
