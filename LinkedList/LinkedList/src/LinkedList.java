import java.util.LinkedHashMap;

class Node {

    public Node(int value) {
        this.value = value;
    }

    public int value;

    public Node next;

}


public class LinkedList {

    public Node getElemInd(int index) {
        return new Node(5);
    }

    // Выводим элементы связного списка
    public void printElem(Node head) {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;

        }
        System.out.println();
    }

    // Удаляем элемент связного списка
    public Node delElemIndex(int index, Node head) {
        Node temp = head;

        if (index == 0) {
            if (head.next == null) return new Node(-1);
            return head.next;
        }

        while (index != 1 && head != null) {
            head = head.next;
            index--;
        }

        head.next = head.next.next;
        return temp;
    }


}

class Start {
    public static void main(String[] args) {
        Node n5 = new Node(5);
        Node n4 = new Node(4);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        LinkedList list = new LinkedList();
        list.printElem(n1);

        n1 = list.delElemIndex(2, n1);
        list.printElem(n1);

        n1 = list.delElemIndex(0, n1);
        list.printElem(n1);
    }
}


