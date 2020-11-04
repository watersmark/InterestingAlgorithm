import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Stack {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> massMax = new ArrayList<>();

    //Добавляем элемент в стек
    public void push(int elem) {
        list.add(elem);

        if(massMax.size() == 0){
            massMax.add(elem);
            return;
        }

        if(massMax.get(massMax.size() - 1) <= elem){
            massMax.add(elem);
        }

    }

    // Удаляем элемент из стека
    public void pop() {
        if (list.size() == 0) {
            System.out.println("error");
            return;
        }

        // Удаляем последний элемент
        if (list.get(list.size() - 1) - massMax.get(massMax.size() - 1) == 0) {
            massMax.remove(massMax.size() - 1);
        }

        // Печатаем и удаляем элемент
        //System.out.println(list.get(list.size() - 1));
        list.remove(list.size() - 1);
    }

    // Получаем максимум со стека
    public void getMax() {

        if(massMax.size() == 0){
            System.out.println("None");
            return;
        }

        System.out.println(massMax.get(massMax.size() - 1));
    }


}

public class Start {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Колличество команд
        int count = Integer.parseInt(reader.readLine());

        Stack stack = new Stack();

        for (int i = 0; i < count; i++) {
            String[] command = reader.readLine().split(" ");
            if (command[0].equals("push")) {
                stack.push(Integer.parseInt(command[1]));
            }
            if (command[0].equals("pop")) {
                stack.pop();
            }
            if (command[0].equals("get_max")) {
                stack.getMax();
            }
        }

    }
}
