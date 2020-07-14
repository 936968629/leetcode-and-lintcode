package leetcode._401_500._470;

public class Solution {

    public int rand10() {
        while (true) {
            //1-49
            int rand49 = (rand7() - 1) * 7 + rand7()-1;
            if (rand49 <= 39) {
                return rand49 % 10 + 1;
            }
        }
        // 0-48
//        int num = (rand7() - 1) * 7 + rand7();
//        // 只要它还大于10，那就给我不断生成，因为我只要范围在1-10的，最后直接返回就可以了
//        while (num > 10){
//            num = (rand7() - 1) * 7 + rand7();
//        }
//        return num;
    }

    // 1- 7
    public int rand7() {
        return 1;
    }

}
