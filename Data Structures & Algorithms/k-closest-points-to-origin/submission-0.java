class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Initialize priority queue for points (using big to small for easier pops)
        PriorityQueue<int[]> pointQueue = new PriorityQueue<>(
            (a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        // Loop through all points, kicking out the point in the queue furthest away if distance is greater than the new point's
        for (int[] point : points) {
            pointQueue.offer(point);
            if (pointQueue.size() > k) pointQueue.poll();
        }

        // Collect the valid points in a 2D array, then return
        int[][] validPoints = new int[k][2];
        return pointQueue.toArray(validPoints);
    }
}
