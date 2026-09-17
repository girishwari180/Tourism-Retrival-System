package algorithms;

public class KMP {

    // Build LPS array
    private static int[] buildLPS(String pattern) {

        int[] lps = new int[pattern.length()];

        int length = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(length)) {

                length++;
                lps[i] = length;
                i++;

            } else {

                if (length != 0) {

                    length = lps[length - 1];

                } else {

                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // KMP search
    // Returns starting index if found
    // Returns -1 if not found
    public static int search(String text, String pattern) {

        if (text == null || pattern == null) {
            return -1;
        }

        text = text.toLowerCase();
        pattern = pattern.toLowerCase();

        if (pattern.isEmpty()) {
            return 0;
        }

        int[] lps = buildLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;

                // Pattern completely matched
                if (j == pattern.length()) {

                    return i - j;
                }

            } else {

                if (j != 0) {

                    j = lps[j - 1];

                } else {

                    i++;
                }
            }
        }

        return -1;
    }
}