class palindrome {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();

        while (l < r) {
            char cl = s.charAt(l), cr = s.charAt(r);
            if (!Character.isLetterOrDigit(cl)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(cr)) {
                r--;
                continue;
            }
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}