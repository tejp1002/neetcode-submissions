class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final Map<Character, Integer> charToCount = new HashMap();

        for (int index = 0; index < s.length();  index++) {
            if (charToCount.containsKey(s.charAt(index))) {
                //System.out.println(" ----- ");
                charToCount.put(s.charAt(index), charToCount.get(s.charAt(index)) + 1);
            } else {
                charToCount.put(s.charAt(index), 1);
            }
        }

        final Map<Character, Integer> charToCount1 = new HashMap();

        for (int index = 0; index < t.length();  index++) {
            if (charToCount1.containsKey(t.charAt(index))) {
                //System.out.println(" ----- ");
                charToCount1.put(t.charAt(index), charToCount1.get(t.charAt(index)) + 1);
            } else {
                charToCount1.put(t.charAt(index), 1);
            }
        }

        //System.out.println(charToCount);
        //System.out.println(charToCount1);
        for (Map.Entry<Character, Integer> entry : charToCount.entrySet()) {
            final Character key = entry.getKey();
            final Integer value = entry.getValue();

            if (!charToCount1.containsKey(key) || !charToCount1.get(key).equals(value)) {
                return false;
            }
        }
    
        return true;
    }
}
