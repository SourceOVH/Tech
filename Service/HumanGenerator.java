package Service;

import Entity.Human;
import Service.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class HumanGenerator {
    public static HashMap<Integer, Human> humans = new HashMap<>();
    public static ArrayList<Human> arrayList = new ArrayList<>();

    public static void selectOption() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("~ Выберите действие");
            System.out.println("| - Создать заявку на знакомства (1)");
            System.out.println("| - Удалить заявку с знакомств (2)");
            System.out.println();
            System.out.println("| - Выдать информацию об Созданных заявках (3)");
            System.out.println("| - Поиск знакомств (4)" + Utils.ANSI_RED + " (ФУНКЦИОНАЛ ПОЛНОСТЬЮ НЕ ДОДЕЛАН)" + Utils.ANSI_RESET);
            System.out.println();
            System.out.println("| - Остановить программу (0)");

//           Выбор функции в главноем меню.
            String option = sc.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.println("~ Раздел Создания анкеты:");
                    System.out.println("~ Вы уверены что хотите создать заявку?");
                    System.out.println();
                    System.out.println(Utils.ANSI_GREEN + "| - Да, я уверен (1)" + Utils.ANSI_RESET);
                    System.out.println(Utils.ANSI_RED + "| - Нет, я лучше вернусь обратно на главную страницу. (2)" + Utils.ANSI_RESET);

                    String profile = sc.nextLine();

                    switch (profile) {
                        case "1" -> {
                            switch (profile) {
                                case "1" -> {

                                    System.out.println("~ Введите фамилию: ");
                                    String family = sc.nextLine().strip();
                                    if (!TextCorrect.textCorrect(family)) {
                                        System.out.println(Utils.ANSI_YELLOW + "~ Неккоректно введена фамилия." + '\n' + "~ Пример правильного ввода: Иванов" + Utils.ANSI_RESET);
                                        continue;
                                    }

                                    System.out.println("~ Введите имя: ");
                                    String name = sc.nextLine().strip();
                                    if (!TextCorrect.textCorrect(name)) {
                                        System.out.println(Utils.ANSI_YELLOW + "~ Неккоректно введено имя." + '\n' + "~ Пример правильного ввода: Иван" + Utils.ANSI_RESET);
                                        continue;
                                    }

                                    System.out.println("~ Введите отчество: ");
                                    String patronymic = sc.nextLine().strip();
                                    if (!TextCorrect.textCorrect(patronymic)) {
                                        System.out.println(Utils.ANSI_YELLOW + "~ Неккоректно введено отчество." + '\n' + "~ Пример правильного ввода: Иванович" + Utils.ANSI_RESET);
                                        continue;
                                    }

                                    System.out.println("~ Выберите Пол:");
                                    System.out.println("| - Мужской (1)");
                                    System.out.println("| - Женский (2)");
                                    String selectGender = sc.nextLine().strip();
                                    switch (selectGender) {
                                        case "1" -> {
                                            System.out.println(Utils.ANSI_CYAN + "~ Вы выбрали мужской пол." + Utils.ANSI_RESET);
                                            break;
                                        }
                                        case "2" -> {
                                            System.out.println(Utils.ANSI_CYAN + "~ Вы выбрали женский пол." + Utils.ANSI_RESET);
                                            break;
                                        }
                                        default -> {
                                            System.out.println(Utils.ANSI_RED + "~ Ошибка в вводе пола!" + Utils.ANSI_RESET);
                                            continue;
                                        }
                                    }

                                    System.out.println("~ Расскажите о себе: ");
                                    String requirements = sc.nextLine().strip();
                                    if (!Validate.validate(requirements)) {
                                        System.out.println(Utils.ANSI_YELLOW + "~ Неккоректно ввели Информацию о себе. Скорее всего она пуста :(" + Utils.ANSI_RESET);
                                        continue;
                                    }

                                    System.out.println("~ Расскажите о ваших предпочтениях: ");
                                    String request = sc.nextLine().strip();
                                    if (!Validate.validate(requirements)) {
                                        System.out.println(Utils.ANSI_YELLOW + "~ Неккоректно ввели Требования к партнеру. Нужно все равно указать :(" + Utils.ANSI_RESET);
                                        continue;
                                    }

//                                      Доп.Проверка
                                    if (!TextCorrect.textCorrect(family, name, patronymic)) {
                                        System.out.println(Utils.ANSI_YELLOW + "~ Неккоректно введено ФИО." + Utils.ANSI_RESET);
                                        continue;
                                    }
                                    if (!Validate.validate(family, name, patronymic, selectGender, requirements, request)) {
                                        System.out.println(Utils.ANSI_YELLOW + "~ Вы не ввели один из аргументов." + Utils.ANSI_RESET);
                                        selectOption();
                                    }
                                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                                    Date date = new Date(System.currentTimeMillis());
                                    String dateRegister = formatter.format(date);
                                    Human newHuman = new Human(family, name, patronymic, selectGender, requirements, request, dateRegister);
                                    humans.put(newHuman.getID(), newHuman);
                                    arrayList.add(newHuman);
                                    new ArraySaver().fileSaver();
                                    System.out.println(Utils.ANSI_GREEN + "~ Вы успешно создали Анкету." + Utils.ANSI_RESET);

                                }
                                case "0" -> selectOption();
                            }
                        }
                        case "2" -> selectOption();
                        default -> {
                            System.out.println(Utils.ANSI_RED + "~ Неверный ввод!" + Utils.ANSI_RESET);
                            selectOption();
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Введите ID пользователя, которого Вы хотите удалить");
                    try {
                        int currentID = Integer.parseInt(sc.nextLine().strip());
                        if (humans.containsKey(currentID)) {
                            humans.remove(currentID);
                            arrayList.remove(humans.get(currentID));
                            System.out.println(Utils.ANSI_GREEN + "~ Пользователь удален" + Utils.ANSI_RESET);
                        } else {
                            System.out.println(Utils.ANSI_RED + "~ Пользователя с таким ID не существует" + Utils.ANSI_RESET);
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println(Utils.ANSI_YELLOW + "Некорректно указан ID" + Utils.ANSI_RESET);
                    }
                }
                case "3" -> {
                    if (humans.isEmpty()) {
                        System.out.println(Utils.ANSI_YELLOW + "~ Анкеты еще не созданы." + Utils.ANSI_RESET);
                        continue;
                    }

                    System.out.println("~ Список всех Анкет: ");
                    System.out.println(Strings.join("", humans.values().stream().toList()));
                }

                case "4" -> Search.searchGender(arrayList);

                case "0" -> {
                    System.out.println(Utils.ANSI_CYAN + "~ Вы остановили программу" + Utils.ANSI_RESET);
                    return;
                }
                default -> System.out.println(Utils.ANSI_RED + "~ Неверный ввод!" + Utils.ANSI_RESET);

            }
        }
    }

    public static ArrayList<Human> getArrayList() {
        return arrayList;
    }

}