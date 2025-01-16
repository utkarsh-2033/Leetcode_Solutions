class Solution {
    public void moveZeroes(int[] nums) {
        // using 2 pointer
        // j-to keep track where next non-0 to be placed
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            // to put j at its first place where non-0 should be place ,i.e, first 0
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if(j==-1) return;
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) { // finding non-0 and swappping it with j(where non-0 to be placed)
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }
        // 0s automatically moves to end-we just take care of placing non-0s at starting
        // in same order
    }
}