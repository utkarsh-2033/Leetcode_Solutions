class Solution {
    public void helper(String num, int idx, int target, List<String> ans, String current, long value, long lastvalue) {
        if (idx == num.length()) {
            if (value == target)
                ans.add(current);
            return;
        }
        for (int i = idx; i < num.length(); i++) {
            String st = num.substring(idx, i + 1);
            long digit = Long.parseLong(st);
            // for skipping numbers starting with leading 0s except 0 itself
            if (st.length() > 1 && st.charAt(0) == '0')
                break;
            //no operator addition before first digit
            if (idx == 0) helper(num, i + 1, target, ans, current + st, digit, digit);
            else {
                helper(num, i + 1, target, ans, current + "+" + digit, value + digit, digit); //add
                helper(num, i + 1, target, ans, current + "-" + digit, value - digit, -digit); //subs
                helper(num, i + 1, target, ans, current + "*" + digit, value - lastvalue + (lastvalue * digit),
                        lastvalue * digit); //multiplication
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        helper(num, 0, target, ans, "", 0, 0);
        return ans;
    }
}