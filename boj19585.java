import java.io.*;
import java.util.*;

public class boj19585 {
    static Words color;
    static HashSet<String> name;
    static StringBuilder sb;
    static int C, N, Q;
    
    public static boolean validTeam(String s) {
        Words tmp = color;
        for (int i = 0; i < s.length(); i++) {
            tmp = tmp.getWords(s.charAt(i));
            if (tmp == null) {
                break;
            }

            if (tmp.isEnd) {
                if (name.contains(s.substring(i + 1))) { //i��° ������ �ܾ �̸� hashset�� �����ϴ� ���
                    return true;
                }
            }
        }
        return false;
    }

    public static void pre() throws IOException {
        int i,j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        color = new Words();
        name = new HashSet<>();

        for (i = 0; i < C; i++) {
            String inputColor = br.readLine();
            
            Words cTrie = color;
            for (j = 0; j < inputColor.length(); j++) {
                cTrie = cTrie.init(inputColor.charAt(j));
            }
            cTrie.setWordEnd();
        }

        for (i = 0; i < N; i++) {
            String inputName = br.readLine();
            name.add(inputName);
        }

        Q = Integer.parseInt(br.readLine());

        for (i = 0; i < Q; i++) {
            String inputTeam = br.readLine();
            boolean checkTeam = validTeam(inputTeam); //�Է¹��� Team�̸� Ȯ��

            if (checkTeam) { //���� Ʈ���̿� ���� �� �̸� �ؽ��� �����ϴ� ���
                sb.append("Yes");
            }
            else{
                sb.append("No");
            }
            sb.append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }

    static class Words {
        Words[] nextWord = new Words[26];
        boolean isEnd;

        public Words() {
            nextWord = new Words[26];
            isEnd = false;
        }

        public Words init(char c) {
            if (nextWord[c - 'a'] == null) { // ���� �ܾ� ����
                nextWord[c - 'a'] = new Words();
            }
            return nextWord[c - 'a'];
        }

        public void setWordEnd() {
            this.isEnd = true;
        }

        public Words getWords(char c) {
            return nextWord[c - 'a'];
        }

    }
}
