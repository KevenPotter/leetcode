package designPatterns.singletonPattern;

/**
 * 单例模式-饿汉式(静态代码块)
 * 步骤:
 * 1.构造器私有化(防止new)
 * 2.类的内部创建对象(通过静态代码块)
 * 3.向外暴露一个静态的公共方法,返回实例对象-getInstance()
 * 4.代码实现
 *
 * @author KevenPotter
 * @date 2020-04-28 16:30:22
 */
public class SingleTon2 {

    public static void main(String[] args) {
        SingleTon_2 instance1 = SingleTon_2.getInstance();
        SingleTon_2 instance2 = SingleTon_2.getInstance();
        System.out.println(instance1 == instance2); // 输出结果: true
        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        System.out.println("instance2.hashCode(): " + instance2.hashCode());
    }
}

/**
 * 优缺点说明:
 * 1.这种方式和{@link SingleTon_1}的方式类似,只不过将类实例化的过程放在了静态代码块中.也是在类装载的时候,就执行静态代码块中的
 * 代码,初始化类的实例.优缺点和{@link SingleTon_1}所描述的一致.
 * 2.结论:可用,但是可能会造成内存浪费
 */
class SingleTon_2 {

    // 1.构造器私有化(防止new)
    private SingleTon_2() {
    }

    // 2.在本类内部创建一个对象示实例
    private final static SingleTon_2 instance;

    static {
        // 在静态代码块中创建单例对象
        instance = new SingleTon_2();
    }

    // 3.向外暴露一个静态的公共方法,返回实例对象-getInstance()
    public static SingleTon_2 getInstance() {
        return instance;
    }
}