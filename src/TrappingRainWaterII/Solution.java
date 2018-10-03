class Solution {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        int ans = 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> (a.height - b.height));
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.add(new Cell(i, 0, heightMap[i][0]));
            pq.add(new Cell(i, n-1, heightMap[i][n-1]));
        }

        for(int j = 1; j < n-1; j++){
            visited[0][j] = true;
            visited[m-1][j] = true;
            pq.add(new Cell(0, j, heightMap[0][j]));
            pq.add(new Cell(m-1, j, heightMap[m-1][j]));
        }

        while(!pq.isEmpty()){
            Cell c = pq.poll();
            for(int i = 0; i < 4; i++){
                int nx = c.row + dx[i];
                int ny = c.col + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    ans += Math.max(0, c.height - heightMap[nx][ny]);
                    pq.add(new Cell(nx, ny, Math.max(c.height, heightMap[nx][ny])));
                }
            }
        }
        return ans;
    }
}

class Cell{
    int row;
    int col;
    int height;
    public Cell(int row, int col, int height){
        this.row = row;
        this.col = col;
        this.height = height;
    }
}