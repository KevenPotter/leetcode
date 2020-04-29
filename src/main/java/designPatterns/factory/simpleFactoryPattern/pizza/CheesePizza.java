package designPatterns.factory.simpleFactoryPattern.pizza;

/**
 * @author KevenPotter
 * @date 2020-04-29 15:22:46
 */
public class CheesePizza extends Pizza {

    public void prepare() {
        System.out.println("准备制作奶酪披萨的原材料;");
    }
}
