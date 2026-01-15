import java.util.Scanner;

public class PasswordChecker {
    private Integer minLength;
    private Integer maxRepeats;

    public PasswordChecker() {
    }

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("ОШИБКА! Минимальная длина пароля не может быть отрицательной!");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("ОШИБКА! Максимальное количество повторений должно быть больше 0!");
        }
        this.maxRepeats = maxRepeats;
    }

    public int chInt(String txt) {
        int num;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(txt);
            String str = scanner.nextLine();
            try {
                num = Integer.parseInt(str);
                return num;
            } catch (NumberFormatException e) {
                System.out.println("ОШИБКА! Введите число!");
            }
        }
    }

    public boolean verify(String password) {
        if (minLength == null || maxRepeats == null) {
            throw new IllegalStateException("ОШИБКА! Настройки чекера заданы не полностью!");
        }

        // Проверка минимальной длины
        if (password.length() < minLength) {
            throw new IllegalStateException("Пароль меньше минимальной длины!");
        }

        // Проверка повторяющихся символов подряд
        int count = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                count++;
                if (count > maxRepeats) {
                    throw new IllegalStateException("Пароль содержит больше допустимых повторений одного символа!");
                }
            } else {
                count = 1;
            }
        }
        System.out.println("Проверка пройдена!");
        return true;
    }
}
