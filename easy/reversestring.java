public class reversestring {
    public void reverseString(char[] s) {
        int L = 0, R = s.length - 1;
        while (L < R) {
            char tmp = s[L];   // swap
            s[L] = s[R];
            s[R] = tmp;
            L++;
            R--;
        }
    }
} 
    

