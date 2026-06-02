class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh_oranges = 0
        rotten_queue = deque()

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2: rotten_queue.append((i, j))
                elif grid[i][j] == 1: fresh_oranges += 1
        
        if fresh_oranges == 0: return 0
        elif not rotten_queue: return -1
        else:
            minutes = -1
            dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

            while rotten_queue:
                current_rotten_oranges = len(rotten_queue)
                while current_rotten_oranges > 0:
                    x, y = rotten_queue.popleft()
                    current_rotten_oranges -= 1

                    for dx, dy in dirs:
                        a,b = x + dx, y + dy

                        if 0 <= a < len(grid) and 0 <= b < len(grid[0]) and grid[a][b] == 1:
                            grid[a][b] = 2
                            fresh_oranges -= 1
                            rotten_queue.append((a, b))
                
                minutes += 1
            
            if fresh_oranges == 0: return minutes
            else: return -1