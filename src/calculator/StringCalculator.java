package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private StringCalculator() {
    }

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return retrieveNumbersFromString(numbers).stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static List<Integer> retrieveNumbersFromString(String numbers) {
        List<Integer> list = new ArrayList<>();
        char[] chars = numbers.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder tmp = new StringBuilder();

            if (Character.isDigit(chars[i])) {
                while (i < chars.length && Character.isDigit(chars[i])) {
                    tmp.append(chars[i]);
                    i++;
                }
                list.add(Integer.parseInt(tmp.toString()));
            }
        }
        return list;
    }
}
