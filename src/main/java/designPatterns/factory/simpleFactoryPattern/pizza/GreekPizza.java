package designPatterns.factory.simpleFactoryPattern.pizza;

/**
 * @author KevenPotter
 * @date 2020-04-29 15:23:09
 */
public class GreekPizza extends Pizza {

    public void prepare() {
        System.out.println("准备制作希腊披萨的原材料;");
    }
}
