package algorithms;

public class RabinKarp {

    // Returns starting index if pattern is found
    // Returns -1 if pattern is not found
    public static int search(String text, String pattern) {

        if (text == null || pattern == null) {
            return -1;
        }

        text = text.toLowerCase();
        pattern = pattern.toLowerCase();

        int n = text.length();
        int m = pattern.length();

        if (m == 0) {
            return 0;
        }

        if (m > n) {
            return -1;
        }

        int prime = 101;
        int base = 256;

        int patternHash = 0;
        int textHash = 0;
        int h = 1;

        // Calculate base^(m-1) % prime
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % prime;
        }

        // Calculate initial hash values
        for (int i = 0; i < m; i++) {

            patternHash =
                    (base * patternHash + pattern.charAt(i))
                    % prime;

            textHash =
                    (base * textHash + text.charAt(i))
                    % prime;
        }

        // Slide pattern over text
        for (int i = 0; i <= n - m; i++) {

            // If hash values match, verify characters
            if (patternHash == textHash) {

                boolean match = true;

                for (int j = 0; j < m; j++) {

                    if (text.charAt(i + j)
                            != pattern.charAt(j)) {

                        match = false;
                        break;
                    }
                }

                if (match) {
                    return i;
                }
            }

            // Calculate next window hash
            if (i < n - m) {

                textHash =
                        (base * (textHash
                        - text.charAt(i) * h)
                        + text.charAt(i + m))
                        % prime;

                if (textHash < 0) {
                    textHash += prime;
                }
            }
        }

        return -1;
    }
}