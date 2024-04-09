import java.io.*;

public class Main {

    private static final int BYTE_DIVIDED_NUMBER = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int NByte = Integer.parseInt(br.readLine());
        int dataCount = NByte / BYTE_DIVIDED_NUMBER;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataCount; i++) {
            sb.append("long").append(" ");
        }
        sb.append("int");
        System.out.print(sb);
    }
}
