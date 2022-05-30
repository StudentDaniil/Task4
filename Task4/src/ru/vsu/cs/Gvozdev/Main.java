package ru.vsu.cs.Gvozdev;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ваш текст:");

        StringBuilder s = new StringBuilder();

        try(FileReader reader = new FileReader("C:\\Users\\Данила\\Desktop\\Учёба\\АИСДсем2\\Task4\\src\\ru\\vsu\\cs\\Gvozdev\\text.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                s.append((char) c);

            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


        Map<String, Integer> map = new HashMap<>(100, 0.75f);

        String s2 = String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(1));



        map.put(s2, 1);
        for (int i = 1; i < s.length() - 1; i++) {
            s2 = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
            if (map.containsKey(s2)) {
                String key = s2;
                map.computeIfPresent(key, (k, v) -> v + 1);
            } else map.put(s2, 1);
        }
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        System.out.println(sortedMap);
    }
}
