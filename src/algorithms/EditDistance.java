package algorithms;

public class EditDistance {

    public static int calculate(String text, String pattern) {

        if (text == null || pattern == null) {
            return -1;
        }

        text = text.toLowerCase();
        pattern = pattern.toLowerCase();

        int n = text.length();
        int m = pattern.length();

        int[][] dp = new int[n + 1][m + 1];

        // Convert empty pattern to text
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // Convert empty text to pattern
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Calculate edit distance
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (text.charAt(i - 1) ==
                    pattern.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int insert =
                            dp[i][j - 1];

                    int delete =
                            dp[i - 1][j];

                    int replace =
                            dp[i - 1][j - 1];

                    dp[i][j] =
                            1 + Math.min(
                                    insert,
                                    Math.min(delete, replace)
                            );
                }
            }
        }

        return dp[n][m];
    }
}