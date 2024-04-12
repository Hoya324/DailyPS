import java.util.*;

public class Main{

    public static int sum(int num){
        int result = num;
        while (num != 0) {
            int first = num % 10;
            result += first;
            num /= 10;
        }
        return result;
    }


    public static void main(String[] args) {

        List<Integer> notSelfList = new ArrayList<>();
        for (int i = 1; i < 10001; i++){
            notSelfList.add(sum(i)); 
        }
        for (int i = 1; i < 10001; i++) {
            if (notSelfList.contains(i) == false) {
                System.out.println(i);
            }
        }
        
    }   
}
