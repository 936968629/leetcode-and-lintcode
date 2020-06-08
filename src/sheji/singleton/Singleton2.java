package sheji.singleton;

/**
 * 懒汉
 * 多线程不安全
 * 反射不安全
 */
public class Singleton2 {

    private static Singleton2 instance = null;

    private Singleton2(){

    }

    public static Singleton2 getInstance(){

        if (instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
