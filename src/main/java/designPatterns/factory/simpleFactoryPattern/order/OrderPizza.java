package designPatterns.factory.simpleFactoryPattern.order;

import designPatterns.factory.simpleFactoryPattern.SimpleFactory;
import designPatterns.factory.simpleFactoryPattern.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author KevenPotter
 * @date 2020-04-29 15:25:30
 */
public class OrderPizza {

//    public OrderPizza() {
//        Pizza pizza;
//        String orderType; // 订购Pizza的类型
//        do {
//            orderType = getType();
//            if (orderType.equals("greek")) {
//                pizza = new GreekPizza();
//                pizza.setName("希腊披萨");
//            } else if (orderType.equals("cheese")) {
//                pizza = new CheesePizza();
//                pizza.setName("奶酪披萨");
//            } else {
//                break;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        } while (true);
//    }

    /**
     * 写一个方法,可以动态获取客户希望订购的披萨的种类
     */
    private String getType() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String string = bufferedReader.readLine();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 定义一个简单工厂对象
     */
    private SimpleFactory simpleFactory;
    Pizza pizza = null;

    // 构造器
    public OrderPizza(SimpleFactory simpleFactory) {
        this.setSimpleFactory(simpleFactory);
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        // 用户输入订单类型
        String orderType = "";
        // 设置简单工厂对象
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            pizza = simpleFactory.createPizza(orderType);
            // 订购成功
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购披萨失败");
                break;
            }
        } while (true);
    }
}
