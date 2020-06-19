/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

abc -> hask ->

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

public List<Integer> getIndicesOfAnagram(String s, String p){// abcd, bca

        //char[] sArray =  s.toCharArray();
        List<Integger> result = new ArrayList<>();
        char[] pArray =  p.toCharArray();
        Arrays.sort(pArray);  //[a,b,c]
        Integer lenS = s.length(); //4
        Integer lenP = pArray.length(); //3
        if(lenS == 0 || lenS < lenP)
        return Collections.emptyList();

        n = (lenS - lenP) + 1; // 2
        for(int i = 0; i < n; i ++){
        char[] subArray = Arrays.sort(s.substring(i, i + lenP).toCharArray()); //abc; bcd
        int j = 0;
        for(char charS : subArray){//a, b, c;
        if(charS == pArray[j]){
        j++;
        }else{
        break;
        }
        }
        if(j == lenP)
        result.append(i); //0,

        }

        return result;
        }