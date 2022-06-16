package calculator;

import exceptions.NegativesAreNotAllowed;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringCalculator {
    private StringCalculator() {
    }

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        List<Integer> list = retrieveNumbersFromString(numbers);
        if (list.stream().anyMatch(n -> n < 0)) {
            throw new NegativesAreNotAllowed(negativeValuesToString(list));
        }
        return list.stream()
                .filter(n -> n <= 1000)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static String negativeValuesToString(List<Integer> list) {
        return list.stream()
                .filter(n -> n < 0)
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }

    public static List<Integer> retrieveNumbersFromString(String numbers) {
        List<Integer> list = new ArrayList<>();
        char[] chars = numbers.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            StringBuilder tmp = new StringBuilder();
            if (chars[i] == '-') {
                flag = true;
            }
            if (Character.isDigit(chars[i])) {
                while (i < chars.length && Character.isDigit(chars[i])) {
                    tmp.append(chars[i]);
                    i++;
                }
                if (flag) {
                    list.add(Integer.parseInt(tmp.toString()) * -1);
                    flag = false;
                } else {
                    list.add(Integer.parseInt(tmp.toString()));
                }
            }
        }
        return list;
    }
}
