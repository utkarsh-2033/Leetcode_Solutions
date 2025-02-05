class Solution {
    public boolean isPowerOfTwo(int n) {
        //bit manipulation
        if (n <= 0) return false; 
        return (n & (n - 1)) == 0;
    }
}