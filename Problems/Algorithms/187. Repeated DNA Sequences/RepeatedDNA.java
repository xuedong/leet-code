class Solution {
    private static final Map<Character, Integer> nucleotides = new HashMap<>();
    static { 
        nucleotides.put('A',0);
        nucleotides.put('C',1); 
        nucleotides.put('G',2);
        nucleotides.put('T',3); 
    }
    private final int POW = (int) Math.pow(nucleotides.size(), 9);

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0, rollingHash = 0; i < s.length(); i++) {
            if (i > 9) {
                rollingHash -= POW * nucleotides.get(s.charAt(i-10));
            }
            rollingHash = nucleotides.size() * rollingHash + nucleotides.get(s.charAt(i));
            
            if (i > 8 && !hashes.add(rollingHash)) {
                res.add(s.substring(i-9,i+1));
            }
        }
        
        return new ArrayList<>(res);
    }
}

