package common;

import java.util.ArrayList;
import java.util.List;

public class exceDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try{
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
