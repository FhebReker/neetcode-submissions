class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # Initialize heap and map
        closest_distances = []

        # Add points to heap and map
        for (x,y) in points: 
            # Use negative since popping removes from lowest value
            distance = -(x*x + y*y)

            # If at max capacity, push-pop; otherwise just push
            if len(closest_distances) == k:
                heapq.heappushpop(closest_distances, (distance, x, y))
            else:
                heapq.heappush(closest_distances, (distance, x, y))

        # Return list of co-ordinates from the heap
        return [[x, y] for (dist, x, y) in closest_distances]