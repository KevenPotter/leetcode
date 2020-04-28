package designPatterns.singletonPattern;

/**
 * 单例模式:
 * 所谓类的单例设计模式就是采取一定的方法保证在整个的软件系统中,对某个类只能存在一个实例对象.并且,该类只提供一个取得其对象实例的
 * 方法.
 * <p>
 * 比如Hibernate的SessionFactory它充当数据存储源的代理,并负责创建Session对象.SessionFactory并不是轻量级的,一般情况下,一个项目
 * 通常只需要一个SessionFactory就足够了.这时,就会使用到单例模式.
 * <p>
 * 再比如,{@link Runtime}就是一个饿汉式单例模式
 * <p>
 * 单例模式-饿汉式(静态常量)
 * 步骤:
 * 1.构造器私有化(防止new)
 * 2.类的内部创建对象
 * 3.向外暴露一个静态的公共方法,返回实例对象-getInstance()
 * 4.代码实现
 *
 * @author KevenPotter
 * @date 2020-04-28 16:19:56
 */
public class SingleTon1 {

    public static void main(String[] args) {
        SingleTon_1 instance1 = SingleTon_1.getInstance();
        SingleTon_1 instance2 = SingleTon_1.getInstance();
        System.out.println(instance1 == instance2); // 输出结果: true
        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        System.out.println("instance2.hashCode(): " + instance2.hashCode());
    }
}

/**
 * 优缺点说明:
 * 1.优点:写法简单,在类装载的时候就完成实例化了.避免了线程同步问题.
 * 2.缺点:在类装载的时候就完成了实例化,并没有达到Lazy Loading的效果.如果从始至终从未使用过这个实例,则会造成内存的浪费.
 * 3.这种方式基于classLoader机制避免了多线程的同步问题,不过,instance在类装载时就实例化,在单例模式中大多数都是调用getInstance
 * 方法.然而,导致类装载的原因有很多种,因此不能确定有其他的方式(或者其他的静态方法)导致类装载,这时候初始化instance就没有达到
 * Lazy Loading的效果.
 * 4.结论:可用,但是可能会造成内存浪费
 */
class SingleTon_1 {

    // 1.构造器私有化(防止new)
    private SingleTon_1() {
    }

    // 2.在本类内部创建一个对象示实例
    private final static SingleTon_1 instance = new SingleTon_1();

    // 3.向外暴露一个静态的公共方法,返回实例对象-getInstance()
    public static SingleTon_1 getInstance() {
        return instance;
    }
}

/*
 * 单例模式注意事项和细节说明
 * 1.单例模式保证了系统内存中该类只存在一个对象,节省了系统资源.对于一些需要频繁创建销毁的对象,使用单例模式可以提高系统性能.
 * 2.当想实例化一个单例类的时候,必须要记住使用相应的获取对象的方法,而不是使用new.
 * 3.单例模式使用的场景:
 * 需要频繁的进行创建和销毁的对象;
 * 创建对象时耗时过多或耗费资源过多(即:重量级对象),但又经常用到的对象;
 * 工具类对象;
 * 频繁访问数据库或文件的对象(如数据源、session工厂等)
 */