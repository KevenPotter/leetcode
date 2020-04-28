package designPatterns.singletonPattern;

/**
 * 单例模式-懒汉式(线程安全,同步方法)
 * 步骤:
 * 1.构造器私有化(防止new)
 * 2.类的内部创建对象(通过静态代码块)
 * 3.提供一个静态的共有方法,当时候到该方法时,采取创建instance
 * 4.代码实现
 *
 * @author KevenPotter
 * @date 2020-04-28 21:33:12
 */
public class SingleTon4 {

    public static void main(String[] args) {
        SingleTon_4 instance1 = SingleTon_4.getInstance();
        SingleTon_4 instance2 = SingleTon_4.getInstance();
        System.out.println(instance1 == instance2); // 输出结果: true
        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        System.out.println("instance2.hashCode(): " + instance2.hashCode());
    }
}

/**
 * 优缺点说明:
 * 1.解决了线程不安全问题
 * 2.效率太低了,每个线程在想获得类的实例的时候,执行getInstance()方法都要进行同步.而其实这个方法只执行一次实例化代码就够了,后面
 * 的想要获得该类实例,直接return即可.方法进行同步的话,效率太低.
 * 3.结论:可用,但是实际开发中不要使用这种方式
 */
class SingleTon_4 {

    // 1.构造器私有化(防止new)
    private SingleTon_4() {
    }

    // 2.在本类内部创建一个对象示实例
    private static SingleTon_4 instance;

    // 3.提供一个静态的共有方法,加入同步处理的代码,解决线程安全问题
    public static synchronized SingleTon_4 getInstance() {
        if (instance == null) {
            instance = new SingleTon_4();
        }
        return instance;
    }
}