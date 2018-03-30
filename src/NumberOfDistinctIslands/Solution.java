class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length ==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> vals = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    ArrayList<Point> list = new ArrayList<>();
                    dfs(grid, i, j, list);
                    String val = calculate(list);
                    vals.add(val);
                }
            }
        }
        return vals.size();
    }

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};
    private void dfs(int[][] grid, int x, int y, List<Point> points){
        grid[x][y] = 0;
        points.add(new Point(x, y));
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1){
                dfs(grid, nx, ny, points);
            }
        }
    }

    private String calculate(List<Point> points){
        StringBuilder ret = new StringBuilder();
        Collections.sort(points, (a, b) -> {
            if(a.x != b.x){
                return a.x - b.x;
            }else{
                return a.y - b.y;
            }
        });
        Point min = points.iterator().next();
        for(Point point: points){
            ret.append(String.valueOf(point.x - min.x));
            ret.append(".");
            ret.append(String.valueOf(point.y - min.y));
            ret.append(".");
        }
        return ret.toString();
    }

}

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}