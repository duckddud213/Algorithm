import java.util.Scanner;

class LinkedList {
    int num;
    LinkedList next;

    LinkedList(int num, LinkedList next) {
        this.num = num;
        this.next = next;
    }
}

public class boj2751 {
    public static void arrangeNode(LinkedList Head, LinkedList newNode) {
        LinkedList pointer;

        if (Head.next.num > newNode.num) {
            newNode.next = Head.next;
            Head.next = newNode;
        } else {
            pointer = Head;
            while (pointer.next != null) {
                if (pointer.next.num > newNode.num) {
                    newNode.next = pointer.next;
                    pointer.next = newNode;
                    break;
                } else {
                    pointer = pointer.next;
                }
            }
            if (pointer.next == null) {
                pointer.next = newNode;
            }

        }
    }

    public static void main(String args[]) {
        int N, i, num;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        LinkedList Head = new LinkedList(-11111111, null);

        for (i = 0; i < N; i++) {
            num = sc.nextInt();
            LinkedList newNode = new LinkedList(num, null);
            if (i == 0) {
                Head.next = newNode;
            } else {
                arrangeNode(Head, newNode);
            }
        }

        LinkedList pointer = Head.next;

        if (pointer.next == null) {
            System.out.println(pointer.num);
        } else {
            while (pointer.next != null) {
                System.out.println(pointer.num);
                pointer = pointer.next;
            }
            System.out.println(pointer.num);
        }
    }
}
