package ru.geekbrains.lesson3;

import java.util.*;

public class CollectionApp {

    public static void main(String[] args) {

        // Увеличение размера массива
        int[] arr = new int[10];

        for (int i=0; i<arr.length; i++) {
            arr[i] = i * 10;
        }

        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[arr.length * 2];
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        arr = arr1;

        arr[10] = 1010;

        System.out.println(Arrays.toString(arr));

        // Коллекции
        // ArrayList - динамический массив
        List<Integer> arrList = new ArrayList<>(); // не нужно указывать размер при создании

        // размер автоматически увеличивается при добавлении элементов
        for (int i=0; i<10; i++) {
            arrList.add(i * 10);
        }

        System.out.println(arrList);

        for (int i=0; i<5; i++) {
            arrList.add(i * 10);
        }

        // !!! так делать не желательно. Нужно использовать Set.
        arrList.contains(5);

        System.out.println(arrList);
        System.out.println(arrList.size());

        System.out.printf("Элемет по индексу [%d]: %d%n", 5, arrList.get(5));

        // можно удалять элементы по индексу
        // остальные элементы будут при этом нужным образом сдвигаться
        arrList.remove(1);

        System.out.println(arrList);

        // с динамическими массивами можно использовать цикл for each
        for (Integer val : arrList) {
            System.out.printf("Элемет массива %d%n", val);
        }

        // двумерный ArrayList
        List<List<Integer>> twoDimArrList = new ArrayList<>();

        twoDimArrList.add(new ArrayList<>());
        twoDimArrList.get(0).add(123);

        // LinkedList и Queue
        System.out.println("Работа с очередью");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        // Map - словарь
        Map<String, String> dict = new HashMap<>();
        dict.put("hello", "привет");
        dict.put("I", "я");
        dict.put("you", "ты");

        String word = "hello";
        System.out.printf("%s - %s%n", word, dict.get(word));

        // если нужно несколько переводов для слов
        // такую структуру иногда называют Multimap
        Map<String, List<String>> dict2 = new HashMap<>();

        Integer val = 10;
        int hashCode = val.hashCode();

        // val1 == val2 => val1.hashCode() == val2.hashCode()
        // val1 != val2 => val1.hashCode() == val2.hashCode() || val1.hashCode() != val2.hashCode()

        // Множества
        Set<String> userRules = new HashSet<>();

        userRules.add("read");
        userRules.add("write"); // во множестве всегда хранятся элементы с одинаковыми значениями
        userRules.add("write");
        userRules.add("write");

        System.out.println("Права на чтение " + userRules.contains("read"));
        System.out.println("Права на удаление " + userRules.contains("delete"));

        Set<Integer> set = new TreeSet<>(); // элементы отсортированы
        //new LinkedHashSet<>(); // элементы в порядке добавления
        // new HashSet<>(); // порядок элементов не определен

        for (int i=15; i>1; i--) {
            set.add(i * 10);
        }

        set.add(81);

        for (Integer iVal : set) {
            System.out.println(iVal);
        }

        // Классы с методами для работы с массивами и коллекциями
        List<Object> list = Collections.emptyList();

        List<String> strList = new ArrayList<>(10);
        Collections.fill(strList, "asdasdasd");

        List<String> sdfsdf = Arrays.asList("1", "2232", "sdfsdf");
        List<Integer> ints1 = Arrays.asList(1, 2, 3, 4);
    }
}
