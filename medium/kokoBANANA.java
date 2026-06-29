public class kokoBANANA {
    
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int p : piles) r = Math.max(r, p);

        while (l < r) {
            int mid = (l + r) / 2;
            long hours = 0;
            for (int p : piles) hours += (p + mid - 1) / mid;

            if (hours <= h) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}

