class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final List<List<String>> listGroups = new ArrayList<>();
        final Set<Integer> indexNotToCheck = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            if (indexNotToCheck.contains(i)) {
                continue; 
            }
            final List<String> matchedList = new ArrayList<>();
            matchedList.add(strs[i]);
            indexNotToCheck.add(i);
            final Map<Character, Integer> charMap1 = new HashMap<>();
            for (int k = 0; k < strs[i].length(); k++) {
                charMap1.put(strs[i].charAt(k), charMap1.getOrDefault(strs[i].charAt(k), 0) + 1);
            }
            for (int j = i+1; j < strs.length; j++) {
                if (strs[i].length() == strs[j].length()) {
                    boolean matched = true;
                    final Map<Character, Integer> charMap = new HashMap<>();
                    for (int k = 0; k < strs[j].length(); k++) {
                        charMap.put(strs[j].charAt(k), charMap.getOrDefault(strs[j].charAt(k), 0) + 1);
                    }
                    for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                        if (charMap1.containsKey(entry.getKey()) && charMap1.get(entry.getKey()) == entry.getValue()) {
                             continue;
                        } else {
                            matched = false;
                            break;
                        }    
                        
                    }
                    /*
                    if (charSet.contains(strs[i].charAt(k))) {
                           
                    */
                    if (matched) {
                        matchedList.add(strs[j]);
                        indexNotToCheck.add(j);
                    }
                }
            }
            listGroups.add(matchedList);
        }
        
        return listGroups;
    }
}
