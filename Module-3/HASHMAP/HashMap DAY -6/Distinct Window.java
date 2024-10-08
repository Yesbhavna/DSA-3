import java.util.*;

public class Main {

    public static String DistinctWindow(String s){
        StringBuilder sb = new StringBuilder("");
        HashSet<Character> set = new HashSet();
        for (char ch: s.toCharArray()) {
            set.add(ch);
        }

        for (char ch: set) {
            sb.append(ch);
        }

        String t = sb.toString();
        
        // charFreqMap for String t
        HashMap<Character, Integer> charFreqMap2 = new HashMap<>();
        for (char ch: t.toCharArray()) {
            charFreqMap2.put(ch, charFreqMap2.getOrDefault(ch, 0) + 1);
        }

        int dmcnt = t.length();
        int mcnt = 0;

        // charFreqMap for String subString
        HashMap<Character, Integer> charFreqMap1 = new HashMap<>();

        int inc = -1;
        int exc = -1;

        String subStringAns = "";

        while (true) {
            boolean f1 = false, f2 = false;
            
            if (inc + 1 < s.length() && dmcnt != mcnt) {
                inc++;

                char ch = s.charAt(inc);
                charFreqMap1.put(ch, charFreqMap1.getOrDefault(ch, 0) + 1);

                if (charFreqMap2.containsKey(ch) == true && charFreqMap2.get(ch) >= charFreqMap1.get(ch)) {
                    mcnt++;
                }

                f1 = true;
            }
            
            if (exc < inc && mcnt == dmcnt) {
                String subString = s.substring(exc + 1, inc + 1);
                if (subStringAns.length() == 0 || subStringAns.length() > subString.length()) {
                    subStringAns = subString;
                }

                exc++;
                char ch = s.charAt(exc);
                charFreqMap1.put(ch, charFreqMap1.get(ch) - 1);

                if (charFreqMap2.containsKey(ch) == true && charFreqMap2.get(ch) > charFreqMap1.get(ch)) {
                    mcnt--;
                }

                if (charFreqMap1.get(ch) == 0) {
                    charFreqMap1.remove(ch);
                }

                f2 = true;
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return subStringAns;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}