import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] inorder, postorder;
	static int n;
	static int[] inorderIndex;
	static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer orderToken;

		n = Integer.parseInt(bufferedReader.readLine());

		inorder = new int[n];
		postorder = new int[n];
		inorderIndex = new int[n];

		orderToken = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < n; i++) {
			inorder[i] = Integer.parseInt(orderToken.nextToken());
			inorderIndex[inorder[i] - 1] = i; // inorder의 인덱스 저장
		}

		orderToken = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			postorder[i] = Integer.parseInt(orderToken.nextToken());
		}

		getPreOrder(0, n - 1, 0, n - 1);

		System.out.println(stringBuilder);
	}

	private static void getPreOrder(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {

		if (inorderStart > inorderEnd || postorderStart > postorderEnd)
			return;

		int root = postorder[postorderEnd];
		stringBuilder.append(root).append(" ");

		int currentInorderRootIndex = inorderIndex[root - 1];

		// 왼쪽 자식 트리를 가지고 다시 똑같은 과정을 반복한다.
		getPreOrder(inorderStart, currentInorderRootIndex - 1, postorderStart,
			postorderEnd - (inorderEnd - currentInorderRootIndex) - 1);
		// 오른쪽 자식 트리를 가지고 다시 똑같은 과정을 반복한다.
		getPreOrder(currentInorderRootIndex + 1, inorderEnd, postorderEnd - (inorderEnd - currentInorderRootIndex),
			postorderEnd - 1);
	}
}
