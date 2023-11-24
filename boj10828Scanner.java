import java.util.Scanner;

public class boj10828Scanner {
    public static void pushX(int idx[], int x, int[] stack) {
        stack[idx[0]] = x;
        idx[0]++;
    }

    public static void popNprint(int idx[], int[] stack) {
        if (idx[0] == 0) {
            System.out.println("-1");
            return;
        }

        System.out.println(stack[idx[0] - 1]);
        idx[0]--;
    }

    public static void printSize(int idx[], int[] stack) {
        System.out.println(idx[0]);
    }

    public static void isEmpty(int idx[], int[] stack) {
        if (idx[0] == 0) {
            System.out.println("1");
        } 
        else System.out.println("0");
    }

    public static void printTop(int idx[], int[] stack) {
        if (idx[0] == 0) {
            System.out.println("-1");
            return;
        }

        System.out.println(stack[idx[0] - 1]);
    }

    public static void main(String args[]) {
        int N, ord, in;
        int idx[] = new int[1];
        String inp;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int stack[] = new int[N];
        idx[0] = 0;
        for (int i = 0; i < N; i++) {
            inp = sc.next();
            if (inp.equals("push")) {
                System.out.println("****************push!****************");
                in = sc.nextInt();
                pushX(idx, in, stack);
            } 
            else if (inp.equals("pop")) {
                System.out.println("****************pop!****************");
                popNprint(idx, stack);
            } 
            else if (inp.equals("size")) {
                System.out.println("****************size!****************");                
                printSize(idx, stack);
            } 
            else if (inp.equals("empty")) {
                System.out.println("****************empty!****************");                
                isEmpty(idx, stack);
            } 
            else if (inp.equals("top")) {
                System.out.println("****************top!****************");                
                printTop(idx, stack);
            }
        }
    }
}
