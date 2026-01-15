import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        boolean ee;

        ee = true;
        while (ee) {

            try {
                int minLength = checker.chInt("Введите мин. длину пароля:");
                checker.setMinLength(minLength);
                ee = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        ee = true;
        while (ee) {
            try {
                int maxRepeats = checker.chInt("Введите макс. допустимое количество повторений символа подряд:");
                checker.setMaxRepeats(maxRepeats);
                ee = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.println("Введите пароль или end:");
            String pass = scanner.nextLine();

            if ("end".equals(pass)) {
                break;
            }

            try {
                boolean result = checker.verify(pass);
                System.out.println(result ? "Пароль подходит." : "Пароль не подходит.");
            } catch (IllegalStateException e) {
                System.out.println("ОШИБКА!  " + e.getMessage());
            }

        }
    }
}
