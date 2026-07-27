class Solution {
    public String solution(String s) {
        String answer = "";
        boolean newWord;
        
        newWord = Character.isDigit(s.charAt(0)) ? false : true;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                newWord = true;
                answer += Character.toString(s.charAt(i));
            }
            else{
                if(newWord){
                    answer += Character.toUpperCase(s.charAt(i));
                }
                else{
                    answer += Character.toLowerCase(s.charAt(i));
                }
                newWord = false;
            }
        }
        
        return answer;
    }
}