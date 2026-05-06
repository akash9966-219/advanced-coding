import java.io.*;

public class main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        String doubled = s + s;
        boolean[] seen = new boolean[26];

        int left = 0, sum = 0, maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {
            char ch = doubled.charAt(right);

            // Remove duplicates
            while (seen[ch - 'a']) {
                char leftChar = doubled.charAt(left);
                seen[leftChar - 'a'] = false;
                sum -= (leftChar - 'a' + 1);
                left++;
            }

            // Maintain window size <= n
            while (right - left + 1 > n) {
                char leftChar = doubled.charAt(left);
                seen[leftChar - 'a'] = false;
                sum -= (leftChar - 'a' + 1);
                left++;
            }

            seen[ch - 'a'] = true;
            sum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
//input:abc
//output:6