import java.io.*;
import java.util.*;

public class boj20920 {
    static class wordInfo implements Comparable<wordInfo> {
        String word;
        int cnt, length;

        wordInfo(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
            this.length = word.length();
        }

        @Override
        public int compareTo(wordInfo o1) {
            if (o1.cnt == this.cnt) {
                if (o1.length == this.length) {
                    return this.word.compareTo(o1.word);
                }
                return o1.length - this.length;
            }
            return o1.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        int N, M, i, cnt;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, wordInfo> notepad = new HashMap<String, wordInfo>();

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.length() < M) { // 일정 길이 M보다 짧은 경우
                continue;
            }
            if (notepad.containsKey(input)) { // 기존에 있는 단어인 경우 -> 갯수 확인 변수 cnt 갱신
                cnt = notepad.get(input).cnt;
                wordInfo replaceWord = new wordInfo(input, cnt + 1);
                notepad.replace(input, replaceWord);
            } else { // 새로운 단어인 경우 hashmap에 추가
                wordInfo wordinfo = new wordInfo(input, 1);
                notepad.put(input, wordinfo);
            }
        }

        Collection<wordInfo> values = notepad.values(); // hashmap의 값을 arraylist로 이동
        List<wordInfo> wordList = new ArrayList<>(values);
        Collections.sort(wordList);

        for (wordInfo a : wordList) {
            sb.append(a.word).append('\n');
        }
        System.out.println(sb);
    }

}