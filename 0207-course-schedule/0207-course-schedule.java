class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfs(i, adj, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int[] visited) {
        if (visited[node] == 1) return true;
        if (visited[node] == 2) return false;
        visited[node] = 1;
        for (int next : adj.get(node)) {
            if (dfs(next, adj, visited)) {
                return true;
            }
        }
        visited[node] = 2;
        return false;
    }
}