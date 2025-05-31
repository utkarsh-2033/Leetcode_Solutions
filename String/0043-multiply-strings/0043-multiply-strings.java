class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        // Result can be at most n + m digits
        int[] res = new int[n + m];
        // Multiply each digit pair and add to the proper slot
        for (int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int product = a * b + res[i + j + 1];
                res[i + j + 1] = product % 10;         // unit digit
                res[i + j] += product / 10;            // carry to the next slot
            }
        }
        // Convert the int[] to a string,
        //skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append((char)('0' + num));
            }
        }
        //all were zeros, returning "0"
        return sb.length() == 0 ? "0" : sb.toString();
    }
}