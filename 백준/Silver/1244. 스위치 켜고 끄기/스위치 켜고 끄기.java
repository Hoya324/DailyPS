import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(reader.readLine());
        Boolean[] switches = Arrays.stream(reader.readLine().split(" "))
            .map(Main::convertSwitchToBoolean)
            .toArray(Boolean[]::new);
        int studentCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < studentCount; i++) {
            String[] info = reader.readLine().split(" ");
            int targetNumber = Integer.parseInt(info[1]);
            int targetIndex = targetNumber - 1;
            if (info[0].equals("1")) {
                manSwitch(switches, targetNumber);
            } else {
                womanSwitch(switches, targetIndex);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < switchCount; i++) {
            sb.append(convertBooleanToSwitch(switches[i]));
            sb.append(" ");
            if ((i + 1) % 20 == 0) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }

    private static Boolean convertSwitchToBoolean(String s) {
        return s.equals("1");
    }
    
    private static String convertBooleanToSwitch(Boolean b) {
        if (b) {
            return "1";
        }
        return "0";
    }

    private static Boolean[] manSwitch(Boolean[] switches, int targetNumber) {
        for (int i = 1; targetNumber * i <= switches.length; i++) {
            int idx = targetNumber * i - 1;
            switches[idx] = !switches[idx];
        }
        return switches;
    }

    private static Boolean[] womanSwitch(Boolean[] switches, int targetIndex) {
        switches[targetIndex] = !switches[targetIndex];
        
        int left = targetIndex - 1;
        int right = targetIndex + 1;
        
        while (left >= 0 && right < switches.length && switches[left] == switches[right]) {
            switches[left] = !switches[left];
            switches[right] = !switches[right];
            left--;
            right++;
        }

        return switches;
    }
}
