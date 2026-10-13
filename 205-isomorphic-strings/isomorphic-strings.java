
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (hm.containsKey(a)) {
                if (hm.get(a) != b) {
                    return false;
                }
            } else {
                if (set.contains(b)) {
                    return false;
                }

                hm.put(a, b);
                set.add(b);
            }
        }

        return true;
    }
}
