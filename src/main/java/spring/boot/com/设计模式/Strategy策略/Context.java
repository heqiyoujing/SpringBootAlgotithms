package spring.boot.com.设计模式.Strategy策略;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface(){
        strategy.AlgorithmInterface();
    }

}
