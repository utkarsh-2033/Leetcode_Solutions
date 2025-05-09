class Solution {
    int n;
    int totalDigitSum;
    int M = (int) 1e9 + 7;
    long totalPermPossible = 0;

    // Binary exponentiation
    int pow(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long half = pow(a, b / 2);
        long result = (half * half) % M;
        if (b % 2 == 1) {
            result = (result * a) % M;
        }
        return (int) result;
    }

    int solve(int digit, int eidx, int currSum,
            int[] freq, long[] fermatFact,
            int[][][] t) {
        if (digit == 10) {
            if (currSum == totalDigitSum / 2 && eidx == (n + 1) / 2) {
                return (int) totalPermPossible;
            }
            return 0;
        }
        if (t[digit][eidx][currSum] != -1) {
            return t[digit][eidx][currSum];
        }

        long ways = 0;

        for (int count = 0; count <= Math.min(freq[digit], (n + 1) / 2 - eidx); count++) {
            int evenPosCount = count;
            int oddPosCount = freq[digit] - count;

            long x = (fermatFact[evenPosCount] * fermatFact[oddPosCount]) % M;

            long val = solve(digit + 1, eidx + evenPosCount, currSum + digit * count, freq, fermatFact,
                    t);

            ways = (ways + (val * x) % M) % M;
        }

        return t[digit][eidx][currSum] = (int) ways;
    }

    public int countBalancedPermutations(String num) {
        n = num.length();
        totalDigitSum = 0;

        int[] freq = new int[10];
        for (int i = 0; i < n; i++) {
            totalDigitSum += num.charAt(i) - '0';
            freq[num.charAt(i) - '0']++;
        }
        if (totalDigitSum % 2 != 0) {
            return 0;
        }

        // Precomputing factorial
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % M;
        }

        // Precomputing inverse factorial
        long[] fermatFact = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            fermatFact[i] = pow(fact[i], M - 2);
        }

        totalPermPossible = (fact[(n + 1) / 2] * fact[n / 2]) % M;

        int[][][] t = new int[10][(n + 1) / 2 + 1][totalDigitSum + 1];
        for (int[][] arr2D : t)
            for (int[] arr1D : arr2D)
                Arrays.fill(arr1D, -1);

        return solve(0, 0, 0, freq, fermatFact, t);
    }
}