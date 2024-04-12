import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main{

    
	public static void main(String[] args) throws IOException{

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(scan.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(scan.readLine()));
        }
        StringBuilder sb = new StringBuilder();

        // 산술평균
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr.get(i);
        }
        sb.append(Math.round((double)(sum)/N) + "\n");
     
        Collections.sort(arr);

        // 중앙값
        sb.append(arr.get(N/2) + "\n");

        // 최빈값
        int count = 1;
        int max = 0;
        ArrayList<Integer> mostFrequency = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            
            if (i == N - 1) {
                if (max == count) {
                    mostFrequency.add(arr.get(i));
                }
                else if (max < count) {
                    mostFrequency.clear();
                    mostFrequency.add(arr.get(i));
                }
                break;
            }
            
            if (arr.get(i + 1).equals(arr.get(i))) {
                count++;
            }
                
            else if (!arr.get(i + 1).equals(arr.get(i))) {

                if (max == count) {
                    mostFrequency.add(arr.get(i));
                    count = 1; 
                } 
                
                else if (max < count) {
                    mostFrequency.clear();
                    mostFrequency.add(arr.get(i));
                    max = count;
                    count = 1; 
                }
                else {
                    count = 1; 
                }
                
            }
        }
 
        Collections.sort(mostFrequency);

        
        if (mostFrequency.size() > 2) {
            sb.append(mostFrequency.get(1) + "\n");
        }
        else if (mostFrequency.size() == 1){
            sb.append(mostFrequency.get(0) + "\n");
        }
        else if (mostFrequency.size() == 2) {
            sb.append(mostFrequency.get(1) + "\n");
            
        }

        // 범위
        sb.append(arr.get(N - 1) - arr.get(0));
        
        System.out.print(sb.toString());
    }
}   