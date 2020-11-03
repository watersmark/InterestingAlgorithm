import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Sp2PrQ {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        int[] mass = new int[count];
        String[] maser = reader.readLine().split(" ");

        int tempInd = 0;
        for (String el : maser) {
            mass[tempInd] = Integer.parseInt(el);
            tempInd++;
        }

        maser = null;
        Arrays.sort(mass);

        long multiply = -1;

        for (int i = 0; i < mass.length - 2; i++) {
            long i_el = mass[i];

            for (int j = i + 1, k = mass.length - 1; j != k; ) {

                long j_el = mass[j];
                long k_el = mass[k];

                long tempSum = i_el + j_el + k_el;

                // Проверяем на равенство нулю
                if (tempSum == 0) {

                    if ((i_el * j_el * k_el) > 0 && i_el * j_el * k_el > multiply ) {
                        multiply = i_el * j_el * k_el;
                    }

                    if(k != j + 1 ) {
                        j++;
                        k--;
                        continue;
                    }
                    else {
                        break;
                    }
                }

                // Если tempSum > 0
                if (tempSum > 0) {
                    k--;
                    continue;
                }


                // Если tempSum < 0
                if (tempSum < 0) {
                    j++;
                }


            }
        }

        System.out.println(multiply);

    }
}
