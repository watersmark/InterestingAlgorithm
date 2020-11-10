import java.awt.image.renderable.RenderableImage;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// реализация быстрой сортировки на массиве
// применяем принцип разделяй и властвуй
// создаём два курсора и пока левцй курсор не
// правый продолжаем выполнять цикл действий
// алгоритм реализован на основе рекурсии и
// похож на алгоритм поиска k-й степени
public class QuickSort {

    // Модуль для сортировки
    // Изначально передаём левую границу = 0
    // Правую границу равную = massDigit.length - 1
    public static void quickSort(int[] massDigit, int leftBorder, int rightBorder) {

        //Получили левый маркер и правый маркер границ на текущий момент
        // В каждой иттерации они будут смещаться
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = massDigit[(leftMarker + rightMarker) / 2];

        do {

            while (massDigit[leftMarker] < pivot) {
                leftMarker++;
            }

            while (massDigit[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {

                // делаем замену элементов в ячейках
                // если условие не соблюдается, то левый маркер уже
                // обогнал правый
                // тогда пора переходить к сортировки подмассивов
                if (leftMarker < rightMarker) {
                    int tempMarker = massDigit[leftMarker];
                    massDigit[leftMarker] = massDigit[rightMarker];
                    massDigit[rightMarker] = tempMarker;
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Условие нового рекурсивного шага
        if (leftMarker < rightBorder) {
            quickSort(massDigit, leftMarker, rightBorder);
        }
        if (rightMarker > leftBorder) {
            quickSort(massDigit, leftBorder, rightMarker);
        }

    }

    public static void main(String[] args) {

        // Открываем поток на чтение данных
        Scanner scanner = new Scanner(System.in);

        // Считываем число входных элементов
        int countDigit = scanner.nextInt();

        // Создаём входной масссив
        int[] massDigit = new int[countDigit];

        // Считываем данные в массив
        for (int i = 0; i < countDigit; i++) {
            massDigit[i] = scanner.nextInt();
        }

        // передаём в метод для сортировки массив
        // c данными, ставим стандартные ганицы
        quickSort(massDigit, 0, massDigit.length - 1);

        // Проверяем массив с числами
        for (int i = 0; i < massDigit.length - 1; i++) {

            if (massDigit[i] > massDigit[i + 1]) {
                System.out.println("Error");
            }

            System.out.print(massDigit[i] + " ");
        }

        // Печатаем оставшийся элемент
        System.out.println(massDigit[massDigit.length - 1]);

    }
}
