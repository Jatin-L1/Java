import java.util.Scanner;

public class patterns {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    scanner.close();

    if (N <= 0 || N >= 100) {
        return;
    }

    int[] fibonacci = new int[N * (N + 1) / 2];
    fibonacci[0] = 0;
    if (N > 1) {
        fibonacci[1] = 1;
    }

    for (int i = 2; i < fibonacci.length; i++) {
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
    }

    int index = 0;
    for (int i = 1; i <= N; i++) {
        for (int j = 0; j < i; j++) {
            System.out.print(fibonacci[index++] + "\t");
        }
        System.out.println();
    }
}
}
