import java.util.*;
import static java.lang.Math.*;
public class Pro3 {
	public static void main(String[]args) {
		System.out.println(lengthOfLongestSubstring("aaaa"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0)return 0;
		int len = s.length();
		int i = 0, j = 0;
		int longest = 1;
		Map<Character, Integer>m = new HashMap<Character, Integer>();
		while (i < len) {
			j=i;
			while (j < len&&m.get(s.charAt(j))==null) {
				m.put(s.charAt(j++),1);
				longest = max(j - i, longest);
			}
			m.remove(s.charAt(i++));
		}
		return longest;
	}
}