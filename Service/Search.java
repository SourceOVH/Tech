package Service;

import Entity.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Search {
    private static HashMap<Integer, Human> humans = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void searchGender(ArrayList<Human> searchGendering) {
        try {

            System.out.print("~ Введите пол для поиска (Мужчина, Женщина): ");
            String gender = scanner.nextLine();

            while (!gender.equals("Мужчина") && !gender.equals("Женщина")) {
                System.out.println("~ Вы ввели некорректные параметры пола. Попробуйте еще раз. \n~ Возможные варианты - 'Мужчина', 'Женщина'");
                gender = scanner.nextLine();
            }

            System.out.println("~ Введите 1 из Параметров для поиска: ");
            System.out.println("| - Фамилия (1)");
            System.out.println("| - Имя (2)");
            System.out.println("| - Отчество (3)");
            System.out.println("| - Что вы хотите от партнера (4)");

            String textSearch = scanner.nextLine();
            while (!textSearch.equals("1") && !textSearch.equals("2") && !textSearch.equals("3") && !textSearch.equals("4")) {
                System.out.println("~ Вы ввели некорректный параметр для поиска. \n ~ Введите цифру от 1 до 4");
                textSearch = scanner.nextLine();
            }

            System.out.print("~ Введите значение параметра: ");
            String paramValue = scanner.nextLine().toLowerCase();

            List<Human> result = new ArrayList<>();

            switch (textSearch) {
                case "1" -> {
                    for (Human human : searchGendering) {
                        if (human.getFamily().toLowerCase().equalsIgnoreCase(paramValue) || human.getFamily().toLowerCase().contains(paramValue)) {
                            if (human.getGender().equals(gender)) {
                                result.add(human);
                            }
                        }
                    }
                }
                case "2" -> {
                    for (Human human : searchGendering) {
                        if (human.getName().toLowerCase().equalsIgnoreCase(paramValue) || human.getName().toLowerCase().contains(paramValue)) {
                            if (human.getGender().equals(gender)) {
                                result.add(human);
                            }
                        }
                    }
                }
                case "3" -> {
                    for (Human human : searchGendering) {
                        if ((human.getPatronymic().toLowerCase().equalsIgnoreCase(paramValue) || human.getPatronymic().toLowerCase().contains(paramValue))) {
                            if (human.getGender().equals(gender)) {
                                result.add(human);
                            }
                        }
                    }
                }
                case "4" -> {
                    for (Human human : searchGendering) {
                        if ((human.getRequest().toLowerCase().equalsIgnoreCase(paramValue) || human.getRequest().toLowerCase().contains(paramValue))) {
                            if (human.getGender().equals(gender)) {
                                result.add(human);
                            }
                        }
                    }
                }
            }

            if (result.isEmpty()) {
                System.out.println("~ Поиск: Ничего не найдено");
            } else {
                System.out.println("~ Поиск: Все найденые анкеты: ");
                System.out.println(Strings.join("", result));
            }
        } catch (NullPointerException ex) {
            System.out.println("~ Тут тех Ошибка :(");
        }
    }
}