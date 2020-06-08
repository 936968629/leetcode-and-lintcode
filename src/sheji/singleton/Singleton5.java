package sheji.singleton;

public class Singleton5 extends Handler{

    static {
        System.out.println("Singleton5 static");
    }

    public Singleton5(){
//        super();
        System.out.println("Singleton5 construct");
    }

    private static class Singleton5Handler{

        private static Singleton5 instance = new Singleton5();

        static {
            System.out.println("Singleton4Handler static");
        }

    }

    public static Singleton5 getInstance(){

        return Singleton5Handler.instance;
    }

}
