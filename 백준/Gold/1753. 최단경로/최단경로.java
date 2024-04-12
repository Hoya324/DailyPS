import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end, weight;

	public Node(final int end, final int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(final Node o) {
		return weight - o.weight;
	}
}

public class Main {
	private static final int INF = 100000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Node>[] list;
		int[] dist;

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		list = new ArrayList[v + 1];
		dist = new int[v + 1];

		Arrays.fill(dist, INF);

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		// 리스트에 그래프 정보를 초기화
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// start에서 end로 가는 weight 가중치
			list[start].add(new Node(end, weight));
		}

		StringBuilder sb = new StringBuilder();
		// 다익스트라 알고리즘
		dijkstra(k, v, dist, list);
		// 출력 부분
		for (int i = 1; i <= v; i++) {
			if (dist[i] == INF)
				sb.append("INF\n");
			else
				sb.append(dist[i]).append("\n");
		}

		System.out.println(sb);
	}

	private static void dijkstra(int start, int v, int[] dist, List<Node>[] list) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[v + 1];
		queue.add(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			int current = currentNode.end;

			if (check[current])
				continue;
			check[current] = true;

			for (Node node : list[current]) {
				if (dist[node.end] > dist[current] + node.weight) {
					dist[node.end] = dist[current] + node.weight;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}