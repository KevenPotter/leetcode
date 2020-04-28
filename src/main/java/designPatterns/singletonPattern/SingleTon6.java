package designPatterns.singletonPattern;

/**
 * 单例模式-双重检查
 * 步骤:
 * 1.构造器私有化(防止new)
 * 2.类的内部创建对象(通过静态代码块)
 * 3.提供一个静态的共有方法,当时候到该方法时,采取创建instance
 * 4.代码实现
 *
 * @author KevenPotter
 * @date 2020-04-28 22:07:09
 */
public class SingleTon6 {

    public static void main(String[] args) {
        SingleTon_6 instance1 = SingleTon_6.getInstance();
        SingleTon_6 instance2 = SingleTon_6.getInstance();
        System.out.println(instance1 == instance2); // 输出结果: true
        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        System.out.println("instance2.hashCode(): " + instance2.hashCode());
    }
}

/**
 * 优缺点说明:
 * 1.Double-Check概念是多线程开发中常使用到的,如代码中所示,我们进行了两次<code>if (instance == null)</code>检查,这样就可以保
 * 证线程安全了.
 * 2.这样,实例化代码只用执行一次,后面再次访问时,判断<code>if (instance == null)</code>,直接return实例化对象,也避免反复的进行
 * 方法同步.
 * 3.优点就是线程安全、延迟加载、效率较高
 * 4.结论:推荐使用
 */
class SingleTon_6 {

    // 1.构造器私有化(防止new)
    private SingleTon_6() {
    }

    // 2.在本类内部创建一个对象示实例
    private static volatile SingleTon_6 instance;

    // 3.提供一个静态的共有方法,加入双重检查代码,解决线程安全问题,同时解决懒加载问题
    public static SingleTon_6 getInstance() {
        if (instance == null) {
            synchronized (SingleTon_6.class) {
                if (instance == null) {
                    instance = new SingleTon_6();
                }
            }
        }
        return instance;
    }
}