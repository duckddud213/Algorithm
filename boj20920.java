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
            if (input.length() < M) { // ���� ���� M���� ª�� ���
                continue;
            }
            if (notepad.containsKey(input)) { // ������ �ִ� �ܾ��� ��� -> ���� Ȯ�� ���� cnt ����
                cnt = notepad.get(input).cnt;
                wordInfo replaceWord = new wordInfo(input, cnt + 1);
                notepad.replace(input, replaceWord);
            } else { // ���ο� �ܾ��� ��� hashmap�� �߰�
                wordInfo wordinfo = new wordInfo(input, 1);
                notepad.put(input, wordinfo);
            }
        }

        Collection<wordInfo> values = notepad.values(); // hashmap�� ���� arraylist�� �̵�
        List<wordInfo> wordList = new ArrayList<>(values);
        Collections.sort(wordList);

        for (wordInfo a : wordList) {
            sb.append(a.word).append('\n');
        }
        System.out.println(sb);
    }

}