package designPatterns.singletonPattern;

/**
 * 单例模式-枚举
 *
 * @author KevenPotter
 * @date 2020-04-28 23:12:54
 */
public class SingleTon8 {

    public static void main(String[] args) {
        SingleTon_8 instance1 = SingleTon_8.INSTANCE;
        SingleTon_8 instance2 = SingleTon_8.INSTANCE;
        System.out.println(instance1 == instance2); // 输出结果: true
        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        System.out.println("instance2.hashCode(): " + instance2.hashCode());
        instance1.sayOK();
        instance2.sayOK();
    }
}

/**
 * 使用枚举可以实现单例,推荐使用
 * 1.这借助JDK1.5中添加的枚举来实现单例模式.不仅能避免多线程同步问题,而且还能防止反序列化重新创建新的对象.
 * 2.这种方式是Effective Java的作者Josh Bloch提倡的方式.
 * 3.结论:推荐使用
 */
enum SingleTon_8 {
    INSTANCE;

    public void sayOK() {
        System.out.println("OK");
    }
}