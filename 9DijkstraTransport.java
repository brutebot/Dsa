import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// P9: Dijkstra's shortest path on a city public transport network
public class DijkstraTransport {
    static final int INF = Integer.MAX_VALUE;

    static void dijkstra(int[][] graph, int src, String[] names) {
        int n = graph.length;
        int[] dist = new int[n];
        int[] parent = new int[n];
        boolean[] done = new boolean[n];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            if (done[u]) continue;
            done[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 && !done[v] && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("\nShortest travel time from " + names[src] + ":");
        System.out.println("Destination\tTime(min)\tRoute");
        for (int i = 0; i < n; i++) {
            System.out.print(names[i] + "\t\t");
            if (dist[i] == INF) { System.out.println("--\t\tNo route"); continue; }
            System.out.print(dist[i] + "\t\t");
            printPath(parent, names, i);
            System.out.println();
        }
    }

    static void printPath(int[] parent, String[] names, int j) {
        if (parent[j] == -1) { System.out.print(names[j]); return; }
        printPath(parent, names, parent[j]);
        System.out.print(" -> " + names[j]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Station", "Market", "College", "Hospital", "Airport", "Mall"};
        // graph[i][j] = travel time in minutes (0 = no direct route)
        int[][] graph = {
            //  S   M   C   H   A   Mall
            {   0,  4,  8,  0,  0,  0 },  // Station
            {   4,  0,  2,  5,  0,  0 },  // Market
            {   8,  2,  0,  3,  6,  0 },  // College
            {   0,  5,  3,  0,  2,  4 },  // Hospital
            {   0,  0,  6,  2,  0,  3 },  // Airport
            {   0,  0,  0,  4,  3,  0 }   // Mall
        };

        System.out.println("Locations:");
        for (int i = 0; i < names.length; i++) System.out.println(i + " - " + names[i]);
        System.out.print("Enter source location number: ");
        int src = sc.nextInt();
        if (src < 0 || src >= names.length) System.out.println("Invalid source.");
        else dijkstra(graph, src, names);
        sc.close();
    }
}
