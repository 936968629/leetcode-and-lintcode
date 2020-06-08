package sheji.singleton;

/**
 * 饿汉
 * 不是反射安全
 */
public class SingleTon1 {

    private static SingleTon1 instance = new SingleTon1();

    private SingleTon1(){

    }

    public static SingleTon1 getInstance(){
        return instance;
    }


}
