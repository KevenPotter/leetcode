package designPatterns.singletonPattern;

/**
 * 单例模式-静态内部类
 * 步骤:
 * 1.构造器私有化(防止new)
 * 2.类的内部创建对象(通过静态代码块)
 * 3.提供一个静态的共有方法,当时候到该方法时,采取创建instance
 * 4.代码实现
 *
 * @author KevenPotter
 * @date 2020-04-28 23:00:55
 */
public class SingleTon7 {

    public static void main(String[] args) {
        SingleTon_7 instance1 = SingleTon_7.getInstance();
        SingleTon_7 instance2 = SingleTon_7.getInstance();
        System.out.println(instance1 == instance2); // 输出结果: true
        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        System.out.println("instance2.hashCode(): " + instance2.hashCode());
    }
}

/**
 * 优缺点说明:
 * 1.这种方式采用了类装载的机制来保证初始化实例时只有一个线程.
 * 2.静态内部类方式在SingleTOn类被装载时并不会立即实例化,而是在需要实例化时,调用getInstance()方法,才会装载SingleTonInstance类,
 * 从而完成SingleTon的实例化.
 * 3.类的静态属性只会在第一次加载类的时候初始化,所以在这里,JVM帮助我们保证了线程的安全性,在类进行初始化时,别的线程是无法进入的.
 * 4.优点:避免了线程不安全,利用静态内部类特点实现延迟加载,效率高.
 * 5.结论:推荐使用
 */
class SingleTon_7 {

    // 1.构造器私有化(防止new)
    private SingleTon_7() {
    }

    // 2.写一个静态内部类,该类中有一个静态属性SingleTon_7
    private static class SingleTonInstance {
        private static final SingleTon_7 INSTANCE = new SingleTon_7();
    }

    // 3.提供一个静态的共有方法,加入双重检查代码,解决线程安全问题,同时解决懒加载问题
    public static SingleTon_7 getInstance() {
        return SingleTonInstance.INSTANCE;
    }
}