import java.util.Scanner;

public class boj20436 {
    public static void main(String[] args) {
        char sl, sr;
        char[][] key = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
                { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', '!' },
                { 'z', 'x', 'c', 'v', 'b', 'n', 'm', '!', '!', '!' } };

        String conso = "qwertasdfgzxcv";// �ѱ� ���� ���ڿ�
        String vowel = "yuiophjklbnm"; // �ѱ� ���� ���ڿ�

        int i, j, idx, sum, lx, ly, rx, ry; // lx,ly : �������� Ž���� Ű�� ��ġ�� || rx,ry : �������� Ž���� Ű�� ��ġ��

        Scanner sc = new Scanner(System.in);

        String input[] = sc.nextLine().split(" ");
        sl = input[0].charAt(0);
        sr = input[1].charAt(0);

        lx = 0;
        ly = 0;
        rx = 0;
        ry = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 10; j++) {
                if (key[i][j] == sl) { // ������ Ž���� �հ��� ��ġ ������ ����
                    lx = i;
                    ly = j;
                } else if (key[i][j] == sr) { // ������ Ž���� �հ��� ��ġ ������ ����
                    rx = i;
                    ry = j;
                }
            }
        }

        String text[] = sc.nextLine().split("");

        sum = 0;
        for (idx = 0; idx < text.length; idx++) {

            for (i = 0; i < 3; i++) {
                for (j = 0; j < 10; j++) {
                    if (key[i][j] == text[idx].charAt(0)) { // �Է¹��� ���ڿ����� �ϳ��� �� ����
                        if (conso.contains(String.valueOf(key[i][j]))) { // �ش� ���ĺ��� ���� �ʿ� �ִ� ���
                            sum += (Math.abs(lx - i) + Math.abs(ly - j));
                            lx = i; // ���� Ž�� �� ����� ���� �̵��� ���� ����
                            ly = j;
                            sum++; //Ű ������ �ð� 1�� �߰�
                        } else if (vowel.contains(String.valueOf(key[i][j]))) { // �ش� ���ĺ��� ���� �ʿ� �ִ� ���
                            sum += (Math.abs(rx - i) + Math.abs(ry - j));
                            rx = i; // ���� Ž�� �� ����� ���� �̵��� ���� ����
                            ry = j;
                            sum++; //Ű ������ �ð� 1�� �߰�
                        }
                    }
                }
            }
        }
        
        System.out.println(sum);

    }
}