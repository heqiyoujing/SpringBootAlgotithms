package spring.boot.com.设计模式.Builder建造者;


/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 具体的建造
 */
public class ConcreteBuilder  extends  Builder{
    Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.Add("装CPU");
    }

    @Override
    public void buildMainBoard() {
        computer.Add("装主板");
    }

    @Override
    public void buildHD() {
        computer.Add("装硬盘");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

}
