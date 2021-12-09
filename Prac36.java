// Substrings That Begin and End With the Same Letter

class Solution {
    public long numberOfSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, List<Integer>> map = new HashMap<>();
        long result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),new ArrayList<>());
                map.get(s.charAt(i)).add(i);
                result++;
            } else {
                map.get(s.charAt(i)).add(i);
                result += map.get(s.charAt(i)).size();
            }
        }
        return result;
    }
}

//Count Substrings with Only One Distinct Letter

class Solution {
    public int countLetters(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int count = 1;
        char prev = s.charAt(0);
        int result = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == prev) {
                count++;
            } else {
                result += (count) * (count+1) / 2;
                count = 1;
                prev = s.charAt(i);
            }
        }
        result += (count) * (count+1) / 2;
        return result;
    }
}