class Solution {
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private int[] trans1 = new int[]{1, 1, -1, -1};
    private int[] trans2 = new int[]{1, -1, 1, -1};
    public int numDistinctIslands2(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> vals = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    List<List<Integer>> val = new ArrayList<>();
                    dfs(grid, i, j, val);
                    String key = norm(val);
                    vals.add(key);
                }
            }
        }
        return vals.size();
    }

    private void dfs(int[][] grid, int x, int y, List<List<Integer>> list){
        grid[x][y] = 0;
        list.add(Arrays.asList(x, y));
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1){
                dfs(grid, nx, ny, list);
            }
        }
    }

    private String norm(List<List<Integer>> lists){
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            List<List<Integer>> list1 = new ArrayList<>();
            List<List<Integer>> list2 = new ArrayList<>();
            for(List<Integer> list: lists){
                int x = list.get(0);
                int y = list.get(1);
                list1.add(Arrays.asList(x * trans1[i], y * trans2[i]));
                list2.add(Arrays.asList(y * trans1[i], x * trans2[i]));
            }
            ret.add(getKey(list1));
            ret.add(getKey(list2));
        }
        Collections.sort(ret);
        return ret.get(0);
    }

    private String getKey(List<List<Integer>> lists){
        Collections.sort(lists, (a, b) -> {
            if(a.get(0) != b.get(0)){
                return a.get(0) - b.get(0);
            }else{
                return a.get(1) - b.get(1);
            }
        });
        StringBuilder sb = new StringBuilder();
        int x = lists.get(0).get(0);
        int y = lists.get(0).get(1);
        for(List<Integer> list: lists){
            sb.append(list.get(0) - x);
            sb.append(".");
            sb.append(list.get(1) - y);
            sb.append(".");
        }
        return sb.toString();
    }
}

