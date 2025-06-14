class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        //finding the first digit !=9 from left to right
        char toReMapforMax = 0;
        for (char ch : s.toCharArray()) {
            if (ch != '9') {
                toReMapforMax = ch;
                break;
            }
        }
        String max = toReMapforMax == 0? s : s.replace(toReMapforMax, '9');
        //first digit → '0'
        char toReMapforMin = s.charAt(0);
        String min = s.replace(toReMapforMin, '0');
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}
