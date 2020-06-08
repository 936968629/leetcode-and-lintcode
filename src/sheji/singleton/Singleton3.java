package sheji.singleton;

public class Singleton3 {

    private volatile static Singleton3 instacnce = null;

    private Singleton3(){

    }

    public static Singleton3 getInstance(){
        if (instacnce == null){
            synchronized (Singleton3.class){
                if (instacnce == null){
                    instacnce = new Singleton3();
                }
            }

        }
        return instacnce;
    }

}
