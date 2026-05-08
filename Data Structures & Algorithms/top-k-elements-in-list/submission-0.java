class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Make a hashmap to store frequencies of each number
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int num : nums){
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
        }

        // Make a list to store the top k frequent numbers and sort it by frequency
        List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(numberMap.entrySet());
        freqList.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {result[i] = freqList.get(i).getKey();}

        return result;
    }
}
