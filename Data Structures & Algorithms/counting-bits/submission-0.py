class Solution:
    def countBits(self, n: int) -> List[int]:
        bit_counts = []
        for i in range(n+1):
            bit_counts.append(bin(i).count('1'))
        
        return bit_counts