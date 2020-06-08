package sheji.singleton;

public class Singleton4 {

    private Singleton4(){

    }

    private static class Singleton4Handler{

        private static Singleton4 instance = new Singleton4();

    }

    public static Singleton4 getInstance(){

        return Singleton4Handler.instance;
    }

}
