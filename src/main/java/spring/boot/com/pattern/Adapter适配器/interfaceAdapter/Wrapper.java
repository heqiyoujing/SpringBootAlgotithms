package spring.boot.com.pattern.Adapter适配器.interfaceAdapter;

/**
 * @author: yiqq
 * @date: 2019/1/11
 * @description: 定义抽象类实现端口接口，但是什么事情都不做
 */
abstract  class Wrapper implements Port {
    @Override
    public void SSH() {

    }

    @Override
    public void NET() {

    }

    @Override
    public void Tomcat() {

    }

    @Override
    public void MySQL() {

    }

}
