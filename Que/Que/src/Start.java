import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;

class Que {

    Integer[] queMass;

    int maxSize = 0;
    int head = 0;
    int tail = 0;
    int sizeNow = 0;


    public Que(int size) {
        this.maxSize = size;
        queMass = new Integer[size];
    }

    // Добавляем элемент
    public void push(int elem) {
        if (maxSize == sizeNow) {
            System.out.println("error");
            return;
        }

        queMass[head] = elem;
        head = (head + 1) % maxSize;
        sizeNow++;
    }

    // Удалем элемент
    public void pop() {
        if (sizeNow == 0) {
            System.out.println("None");
            return;
        }

        System.out.println(queMass[tail]);
        queMass[tail] = null;

        tail = (tail + 1) % maxSize;
        sizeNow--;
    }

    // Печатаем первое число в очереди
    public void peek() {
        if (sizeNow == 0) {
            System.out.println("None");
            return;
        }

        System.out.println(queMass[tail]);
    }

    //Возвращаем размер очереди
    public void size() {
        System.out.println(sizeNow);
    }

}


public class Start {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Колличество команд
        int count = Integer.parseInt(reader.readLine());
        int queSize = Integer.parseInt(reader.readLine());

        Que que = new Que(queSize);

        for (int i = 0; i < count; i++) {
            String[] command = reader.readLine().split(" ");
            if (command[0].equals("push")) {
                que.push(Integer.parseInt(command[1]));
            }
            if (command[0].equals("pop")) {
                que.pop();
            }
            if (command[0].equals("size")) {
                que.size();
            }
            if (command[0].equals("peek")) {
                que.peek();
            }
        }


    }
}
