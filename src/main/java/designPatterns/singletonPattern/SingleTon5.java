package designPatterns.singletonPattern;

/**
 * 单例模式-懒汉式(线程安全,同步代码块)
 * 步骤:
 * 1.构造器私有化(防止new)
 * 2.类的内部创建对象(通过静态代码块)
 * 3.提供一个静态的共有方法,当时候到该方法时,采取创建instance
 * 4.代码实现
 *
 * @author KevenPotter
 * @date 2020-04-28 21:45:23
 */
public class SingleTon5 {

    public static void main(String[] args) {
        SingleTon_5 instance1 = SingleTon_5.getInstance();
        SingleTon_5 instance2 = SingleTon_5.getInstance();
        System.out.println(instance1 == instance2); // 输出结果: true
        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        System.out.println("instance2.hashCode(): " + instance2.hashCode());
    }
}

/**
 * 优缺点说明:
 * 1.这种方法是错误的,本意是想对{@link SingleTon_4}实现方式的改进,因为前面同步方法效率太低,改为同步产生实例化的代码块.
 * 2.但是这种同步并不能起到线程同步的作用.跟{@link SingleTon_3}实现方式遇到的情形一致,假如一个线程进入了<code>if (instance == null)</code>
 * 判断语句块,还未来得及往下执行,另一个线程也通过了这个判断语句,这时候便会产生多个实例.
 * 3.结论:可用,但是实际开发中不要使用这种方式
 */
class SingleTon_5 {

    // 1.构造器私有化(防止new)
    private SingleTon_5() {
    }

    // 2.在本类内部创建一个对象示实例
    private static SingleTon_5 instance;

    // 3.提供一个静态的共有方法,加入同步处理的代码,解决线程安全问题
    public static SingleTon_5 getInstance() {
        if (instance == null) {
            synchronized (SingleTon_5.class) {
                instance = new SingleTon_5();
            }
        }
        return instance;
    }
}