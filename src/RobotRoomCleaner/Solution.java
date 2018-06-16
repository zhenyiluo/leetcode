/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public void cleanRoom(Robot robot) {
        HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();
        HashSet<Integer> zero = new HashSet<>();
        zero.add(0);
        visited.put(0, zero);
        dfs(robot, visited, 0, 0, 0);
    }

    private void dfs(Robot robot, HashMap<Integer, HashSet<Integer>> visited, int x, int y, int dir){
        robot.clean();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[(i + dir) % 4];
            int ny = y + dy[(i + dir) % 4];
            if(visited.containsKey(nx) && visited.get(nx).contains(ny)){
                robot.turnLeft();
            }else{
                if(!visited.containsKey(nx)){
                    visited.put(nx, new HashSet<>());
                }
                visited.get(nx).add(ny);
                boolean canMove = robot.move();
                if(canMove){
                    dfs(robot, visited, nx, ny, (i + dir)  % 4);
                    robot.turnLeft();
                    robot.turnLeft();
                    robot.move();
                    robot.turnRight();
                }else{
                    robot.turnLeft();
                }
            }
        }
    }
}