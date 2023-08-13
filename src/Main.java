/*  5.95. Дано натуральное число. Найти сумму его последних n цифр. Величины для
    хранения всех n последних цифр числа не использовать
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*  Суть идеи проста -- извлечь нужную часть числа и провести известные операции на ней */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num;
        /*  Ctrl + Alt + T позволяет делать такие обертки */
        try {
            num = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.print("Введите сколько последних цифр: ");
        int nLast;
        try {
            nLast = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*  Извлекаем последние nLast цифр */
        num %= Math.pow(10, nLast);
        /*  Печатаем результат */
        /*  Это не Chat-GPT */
        System.out.println("Результат: " + sumDigits(num));
    }

    /*  Бессовестный копипаст с предыдущей задачи */
    /*  Найти количество цифр в числе используя целочисленное деление */
    static int getNumDigits(int num) {
        int ctr = 0;
        while (num > 0) {
            num /= 10;
            ctr++;
        }
        return ctr;
    }

    /*  Можно совместить два цикла но уже написал.
        Переменные sum и num у меня подчеркиваются Reassigned local variable
        Почему такое предупреждение? Параметры же передаются по значению
        Плюс я не понимаю почему у sum та же проблема, я с таким впервые столкнулся
    */
    static int sumDigits(int num) {
        int numDigits = getNumDigits(num);
        int sum = 0;
        for (int i = 0; i < numDigits; i++) {
            sum += num % 10;
            num = (num - num % 10) / 10;
        }
        return sum;
    }
}
