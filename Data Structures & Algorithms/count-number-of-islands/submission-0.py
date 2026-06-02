class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        num_islands = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    num_islands += 1
                    
                    def dfs(x: int, y:int):
                        if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] != '1': return
                        else:
                            grid[x][y] = '?'

                            dfs(x, y + 1)
                            dfs(x, y - 1)
                            dfs(x + 1, y)
                            dfs(x - 1, y)
                            return
                    
                    dfs(i, j)

        return num_islands
