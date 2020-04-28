package designPatterns.singletonPattern;

/**
 * 单例模式-懒汉式(线程不安全)
 * 步骤:
 * 1.构造器私有化(防止new)
 * 2.类的内部创建对象(通过静态代码块)
 * 3.提供一个静态的共有方法,当时候到该方法时,采取创建instance
 * 4.代码实现
 *
 * @author KevenPotter
 * @date 2020-04-28 16:46:57
 */
public class SingleTon3 {

    public static void main(String[] args) {
        SingleTon_3 instance1 = SingleTon_3.getInstance();
        SingleTon_3 instance2 = SingleTon_3.getInstance();
        System.out.println(instance1 == instance2); // 输出结果: true
        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        System.out.println("instance2.hashCode(): " + instance2.hashCode());
    }
}

/**
 * 优缺点说明:
 * 1.起到了Lazy Loading的效果,但是只能在单线程下使用.
 * 2.如果在多线程下,一个线程进入了<code>if (instance == null)</code>判断语句块,还未来得及往下执行,另一个线程也通过了这个判断
 * 语句,这时便会产生多个实例.所以在多线程环境下不可使用这种方式.
 * 3.结论:可用,但是实际开发中不要使用这种方式
 */
class SingleTon_3 {

    // 1.构造器私有化(防止new)
    private SingleTon_3() {
    }

    // 2.在本类内部创建一个对象示实例
    private static SingleTon_3 instance;

    // 3.提供一个静态的共有方法,当时候到该方法时,采取创建instance
    public static SingleTon_3 getInstance() {
        if (instance == null) {
            instance = new SingleTon_3();
        }
        return instance;
    }
}