package designPatterns.factory.simpleFactoryPattern.order;

import designPatterns.factory.simpleFactoryPattern.SimpleFactory;

/**
 * 相当于一个客户端,发出订购
 *
 * @author KevenPotter
 * @date 2020-04-29 15:40:42
 */
public class PizzaStore {

    public static void main(String[] args) {
        // new OrderPizza();
        // 使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("退出了程序......");
    }
}
