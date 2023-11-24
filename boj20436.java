import java.util.Scanner;

public class boj20436 {
    public static void main(String[] args) {
        char sl, sr;
        char[][] key = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' },
                { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', '!' },
                { 'z', 'x', 'c', 'v', 'b', 'n', 'm', '!', '!', '!' } };

        String conso = "qwertasdfgzxcv";// 한글 자음 문자열
        String vowel = "yuiophjklbnm"; // 한글 모음 문자열

        int i, j, idx, sum, lx, ly, rx, ry; // lx,ly : 자음쪽을 탐색할 키의 위치값 || rx,ry : 모음쪽을 탐색할 키의 위치값

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
                if (key[i][j] == sl) { // 자음쪽 탐색할 손가락 위치 시작점 지정
                    lx = i;
                    ly = j;
                } else if (key[i][j] == sr) { // 모음쪽 탐색할 손가락 위치 시작점 지정
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
                    if (key[i][j] == text[idx].charAt(0)) { // 입력받은 문자열에서 하나씩 비교 시작
                        if (conso.contains(String.valueOf(key[i][j]))) { // 해당 알파벳이 자음 쪽에 있는 경우
                            sum += (Math.abs(lx - i) + Math.abs(ly - j));
                            lx = i; // 다음 탐색 시 사용을 위해 이동한 지점 저장
                            ly = j;
                            sum++; //키 누르는 시간 1초 추가
                        } else if (vowel.contains(String.valueOf(key[i][j]))) { // 해당 알파벳이 모음 쪽에 있는 경우
                            sum += (Math.abs(rx - i) + Math.abs(ry - j));
                            rx = i; // 다음 탐색 시 사용을 위해 이동한 지점 저장
                            ry = j;
                            sum++; //키 누르는 시간 1초 추가
                        }
                    }
                }
            }
        }
        
        System.out.println(sum);

    }
}