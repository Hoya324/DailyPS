import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
	int height;
	int stepsBack;

	public Student(int height) {
		this.height = height;
		this.stepsBack = 0;
	}

	public int getHeight() {
		return height;
	}

	public void setStepsBack(final int stepsBack) {
		this.stepsBack = stepsBack;
	}
}

public class Main {
	
	private final static int INIT_STUDENT_NUMBER = 21;
	private final static int FIRST_STUDENT_NUMBER = 1;
	private final static int LAST_STUDENT_NUMBER = 20;
	private final static int INIT_STUDENT_ARRAY_FIRST_NUMBER = -1;
	private final static int INIT_STEP = 0;
	
	public static void main(String[] args) throws IOException {
		Scanner br = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();

		int N = br.nextInt();

		for (int testCaseCount = 0; testCaseCount < N; testCaseCount++) {
			int testCase = br.nextInt();
			ArrayList<Student> students = new ArrayList<>(INIT_STUDENT_NUMBER);
			students.add(0, new Student(INIT_STUDENT_ARRAY_FIRST_NUMBER));

			for (int j = FIRST_STUDENT_NUMBER; j <= LAST_STUDENT_NUMBER; j++) {
				students.add(j, new Student(br.nextInt()));
			}

			int totalStepsBack = INIT_STEP;
			for (int j = FIRST_STUDENT_NUMBER; j <= LAST_STUDENT_NUMBER; j++) {
				int stepsBack = INIT_STEP;
				for (int k = FIRST_STUDENT_NUMBER; k < j; k++) {
					if (students.get(k).getHeight() > students.get(j).getHeight()) {
						stepsBack++;
					}
				}
				students.get(j).setStepsBack(stepsBack);
				totalStepsBack += stepsBack;
			}

			stringBuilder.append(testCase).append(" ").append(totalStepsBack).append("\n");
		}
		System.out.println(stringBuilder);
	}
}
