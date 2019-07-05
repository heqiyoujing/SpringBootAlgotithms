package spring.boot.com.pattern.Observer观察者;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description:
 */
public class Test {
    public static void main(String[] args) {

        XiaoMei xiao_mei = new XiaoMei();
        LaoWang lao_wang = new LaoWang();
        LaoLi lao_li = new LaoLi();

        //老王和老李在小美那里都注册了一下
        xiao_mei.addPerson(lao_wang);
        xiao_mei.addPerson(lao_li);

        //小美向老王和老李发送通知
        xiao_mei.notifyPerson();
    }
}
