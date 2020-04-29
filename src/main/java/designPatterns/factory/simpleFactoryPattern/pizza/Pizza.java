package designPatterns.factory.simpleFactoryPattern.pizza;

/**
 * @author KevenPotter
 * @date 2020-04-29 15:18:51
 */
public abstract class Pizza {

    /*披萨的名字*/
    protected String name;

    /**
     * 准备原材料,不同的披萨原材料不一样.所以我们做成抽象方法即可.
     */
    public abstract void prepare();

    /**
     * 烘烤
     */
    public void bake() {
        System.out.println(name + " baking;");
    }

    /**
     * 切割
     */
    public void cut() {
        System.out.println(name + " cutting;");
    }

    /**
     * 打包
     */
    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}
