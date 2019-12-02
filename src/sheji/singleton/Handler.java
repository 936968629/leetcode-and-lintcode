package sheji.singleton;

public class Handler {

    static {
        System.out.println("Handler static");
    }

    public Handler(){
        System.out.println("Handler construct");
    }
}
