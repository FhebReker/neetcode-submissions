class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh_oranges = 0
        rotten_queue = deque()
        rotted = set()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2: 
                    rotten_queue.append((i, j))
                    rotted.add((i, j))
                elif grid[i][j] == 1: fresh_oranges += 1
        
        if fresh_oranges == 0: return 0

        minutes = -1
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        while rotten_queue:
            
            for i in range(len(rotten_queue)):
                x, y = rotten_queue.popleft()

                def bfs (a, b):
                    nonlocal fresh_oranges
                    if 0 <= a < len(grid) and 0 <= b < len(grid[0]) and grid[a][b] == 1 and (a,b) not in rotted:
                        rotted.add((a, b))
                        fresh_oranges -= 1
                        rotten_queue.append((a, b))

                bfs(x - 1, y)
                bfs(x + 1, y)
                bfs(x, y - 1)
                bfs(x, y + 1)
            
            minutes += 1
        
        if fresh_oranges == 0: return minutes
        else: return -1