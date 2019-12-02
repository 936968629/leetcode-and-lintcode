package sheji.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,3,4,5);
        //filter筛选条件
        List<Integer> result = list1.stream().filter(i -> i > 4).collect(Collectors.toList());
        System.out.println(result);
        //distinct去重
        System.out.println(list1.stream().distinct().collect(Collectors.toList()));

        List<Student> listS = new ArrayList<>();
        Student studeng1 = new Student(1, "wenjie", 10);
        Student studeng2 = new Student(2, "xiaohong", 20);
        listS.add(studeng1);
        listS.add(studeng2);
        System.out.println(listS.stream().map(Student::getAge).collect(Collectors.toList()));
//        System.out.println(listS.stream().filter(s -> s.getAge()).collect(Collectors.toList()));
    }
}
