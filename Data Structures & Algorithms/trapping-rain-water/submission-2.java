class Solution {
    public int trap(int[] height) {
        int rainWater = 0, left = 0, leftMax = height[left], right = height.length-1, rightMax = height[right];
        

        for (int high: height){
            System.out.print(high + " ");
        }
        System.out.println();
        System.out.println("left: " + left + " right: " + right);

        while (left < right) {
            int waterToAdd = 0;
            if (leftMax < rightMax){
                System.out.println("leftMax: " + leftMax + " left: " + height[left]);
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterToAdd = leftMax - height[left];
                System.out.println("left water: " + waterToAdd);
                System.out.println("leftMax: " + leftMax + " left: " + height[left]);
            } else{
                System.out.println("rightMax: " + rightMax + " right: " + height[right]);
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterToAdd = rightMax - height[right];
                System.out.println("right water: " + waterToAdd);
                System.out.println("rightMax: " + rightMax + " right: " + height[right]);
            }
            System.out.println();
            rainWater += waterToAdd;
        }

        return rainWater;
    }
}
