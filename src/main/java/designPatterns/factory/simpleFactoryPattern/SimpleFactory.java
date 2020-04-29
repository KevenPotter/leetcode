package designPatterns.factory.simpleFactoryPattern;

import designPatterns.factory.simpleFactoryPattern.pizza.CheesePizza;
import designPatterns.factory.simpleFactoryPattern.pizza.GreekPizza;
import designPatterns.factory.simpleFactoryPattern.pizza.Pizza;

/**
 * 看一个披萨的项目:要便于披萨种类的扩展,要便于维护
 * 1.披萨的种类很多(比如GreekPizza、CheesePizza等)
 * 2.披萨的制作有prepare,bake,cut,box
 * 3.完成披萨店订购功能
 *
 * @author KevenPotter
 * @date
 */
public class SimpleFactory {

    private Pizza pizza = null;

    public Pizza createPizza(String orderType) {
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }
        return pizza;
    }
}

/*
 * 简单工厂模式
 * 传统的方式的优缺点:
 * 1.优点是比较好理解的,简单易操作
 * 2.缺点是违反了设计模式的开闭原则(OCP),即对扩展开放,对修改关闭.即,当我们给类增加新功能的时候,尽量不修改代码,或者尽可能少修改
 * 代码
 * 3.比如我们这时要新增一个Pizza的种类(Pepper披萨),我们就需要新增种类代码和逻辑代码
 * 4.改进的思路分析:
 * 分析:修改代码可以接受,但是如果我们在其他的地方也有创建Pizza的代码,就意味着也需要修改.而创建Pizza代码往往有多处
 * 思路:把创建Pizza对象封装到一个类中,这样我们有新的Pizza种类时,只需要修改该类即可,其他有创建到Pizza对象的代码就不需要修改了
 * 以上就是简单工厂模式
 *
 * 基本介绍
 * 1.简单工厂模式是属于*创建型模式*,是工厂模式的一种.简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例.简单工厂模式是工
 * 厂模式家族中最简单实用的模式
 * 2.简单工厂模式:定义了一个创建对象的类,由这个类来封装实例化对象的行为(代码)
 * 3.在软件开发中,当我们会用到大量的创建某种、某类或者某批对象时,就会使用到工厂模式
 */
