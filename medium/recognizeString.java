class Solution {
    public String reorganizeString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder result = new StringBuilder();

        char previousChar = '#';
        int previousFreq = 0;

        while (!pq.isEmpty()) {

            char currentChar = pq.poll();

            result.append(currentChar);

            map.put(currentChar, map.get(currentChar) - 1);

            if (previousFreq > 0) {
                pq.offer(previousChar);
            }

            previousChar = currentChar;
            previousFreq = map.get(currentChar);
        }

        if (result.length() == s.length()) {
            return result.toString();
        }

        return "";
    }
}