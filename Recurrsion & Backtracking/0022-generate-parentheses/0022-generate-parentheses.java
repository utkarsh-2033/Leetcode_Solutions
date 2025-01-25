class Solution {
    // idea-at any point,no. of closing does not exceed no. of opening parentheses.
    // var open and close -to track no. of opening and closing parentheses used.
    public void helper(int open, int close, int n, List<String> ans, String s) {
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }
        // Adding an opening if we still have some left.
        if (open < n)
            helper(open + 1, close, n, ans, s + "(");

        // Add ')' only if open > close to maintain valid sequence
        if (close < open)
            helper(open, close + 1, n, ans, s + ")");
    }

    // n pairs=> n opening and n closing brackets
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, 0, n, ans, "");
        return ans;
    }
}