class Solution {
    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRem = 0;
        int rightRem = 0;

        // Minimum removals calculate karo
        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRem++;

            } else if (c == ')') {

                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        backtrack(s, 0, 0, leftRem, rightRem, "");

        return new ArrayList<>(result);
    }

    private void backtrack(
            String s,
            int index,
            int balance,
            int leftRem,
            int rightRem,
            String current) {

        // String complete ho gayi
        if (index == s.length()) {

            if (balance == 0 &&
                leftRem == 0 &&
                rightRem == 0) {

                result.add(current);
            }

            return;
        }

        char c = s.charAt(index);

        // Case 1: '('
        if (c == '(') {

            // '(' ko remove karo
            if (leftRem > 0) {
                backtrack(
                    s,
                    index + 1,
                    balance,
                    leftRem - 1,
                    rightRem,
                    current
                );
            }

            // '(' ko keep karo
            backtrack(
                s,
                index + 1,
                balance + 1,
                leftRem,
                rightRem,
                current + c
            );
        }

        // Case 2: ')'
        else if (c == ')') {

            // ')' ko remove karo
            if (rightRem > 0) {
                backtrack(
                    s,
                    index + 1,
                    balance,
                    leftRem,
                    rightRem - 1,
                    current
                );
            }

            // ')' ko keep karo
            if (balance > 0) {
                backtrack(
                    s,
                    index + 1,
                    balance - 1,
                    leftRem,
                    rightRem,
                    current + c
                );
            }
        }

        // Case 3: normal character
        else {

            backtrack(
                s,
                index + 1,
                balance,
                leftRem,
                rightRem,
                current + c
            );
        }
    }
}
