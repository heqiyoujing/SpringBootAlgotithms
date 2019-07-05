package spring.boot.com.pattern.Builder建造者;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:  具体的产品---电脑
 */
public class Computer {
    /**
     * 电脑组件集合
     */
    private List<String> parts = new ArrayList<String>();

    public void Add(String part) {
        parts.add(part);
    }

    public void print() {
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("组件:" + parts.get(i) + "装好了...");
        }
        System.out.println("电脑组装完毕...");
    }

}
