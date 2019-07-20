package spring.boot.com.设计模式.Observer观察者;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class XiaoMei {
    List<Person> list = new ArrayList<Person>();
    public XiaoMei(){
    }

    public void addPerson(Person person){
        list.add(person);
    }

    //遍历list，把自己的通知发送给所有暗恋自己的人
    public void notifyPerson() {
        for(Person person:list){
            person.getMessage("今天家里就我一个人，你们过来吧，谁先过来谁就能得到我!");
        }
    }

}
