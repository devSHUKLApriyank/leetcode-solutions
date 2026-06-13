import java.util.Arrays;
public class permutationString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] winCount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            winCount[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, winCount)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            winCount[s2.charAt(i) - 'a']++;
            winCount[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Count, winCount)) return true;
        }

        return false;
    }
}

