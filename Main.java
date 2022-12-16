import Entity.Human;
import Service.Search;
import Service.Strings;
import Service.TextCorrect;
import Service.Validate;
import org.w3c.dom.Entity;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    private static HashMap<Integer, Human> humans = new HashMap<>();
    private static ArrayList<Human> arrayList = new ArrayList<>();



    public static void main(String[] args) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String dateRegister = formatter.format(date);
        Human newHuman = new Human("Фатила", "Натья", "Гульнаровна", "2", "Богатая, много денег.", "Мужик 20+ Лет", dateRegister);
        humans.put(newHuman.getID(), newHuman);
        arrayList.add(newHuman);
        Human newHuman2 =  new Human("Август", "Цезарь", "ЯнвароВИЧ", "1", "Я ничего не имею, буду сидеть на твоей шее.", "Девушка , с перспективами", dateRegister);
        humans.put(newHuman2.getID(), newHuman2);
        arrayList.add(newHuman2);
    selectOption();

    }

    private static void selectOption() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("~ Выберите действие");
            System.out.println("| - Создать заявку на знакомства (1)");
            System.out.println("| - Удалить заявку с знакомств (2)");
            System.out.println();
            System.out.println("| - Выдать информацию об Созданных заявках (3)");
            System.out.println("| - Поиск знакомств (4)" + ANSI_RED+ " (ФУНКЦИОНАЛ ПОЛНОСТЬЮ НЕ ДОДЕЛАН)" + ANSI_RESET);
            System.out.println();
            System.out.println("| - Остановить программу (0)");

//           Выбор функции в главноем меню.
            String option = sc.nextLine();

            switch (option) {
                case "1" -> {
                        System.out.println("~ Раздел Создания анкеты:");
                        System.out.println("~ Вы уверены что хотите создать заявку?");
                        System.out.println();
                        System.out.println(ANSI_GREEN + "| - Да, я уверен (1)" + ANSI_RESET);
                        System.out.println(ANSI_RED + "| - Нет, я лучше вернусь обратно на главную страницу. (2)" + ANSI_RESET);

                        String profile  = sc.nextLine();

                        switch (profile) {
                            case "1" -> {
                                switch (profile) {
                                    case "1" -> {

                                        System.out.println("~ Введите фамилию: ");
                                        String family = sc.nextLine().strip();
                                        if (!TextCorrect.textCorrect(family)) {System.out.println(ANSI_YELLOW + "~ Неккоректно введена фамилия." + '\n' + "~ Пример правильного ввода: Иванов" + ANSI_RESET);continue;}

                                        System.out.println("~ Введите имя: ");
                                        String name = sc.nextLine().strip();
                                        if (!TextCorrect.textCorrect(name)) {System.out.println(ANSI_YELLOW + "~ Неккоректно введено имя." + '\n' + "~ Пример правильного ввода: Иван" + ANSI_RESET);continue;}

                                        System.out.println("~ Введите отчество: ");
                                        String patronymic = sc.nextLine().strip();
                                        if (!TextCorrect.textCorrect(patronymic)) {System.out.println(ANSI_YELLOW + "~ Неккоректно введено отчество." + '\n' + "~ Пример правильного ввода: Иванович" + ANSI_RESET);continue;}

                                        System.out.println("~ Выберите Пол:");
                                        System.out.println("| - Мужской (1)");
                                        System.out.println("| - Женский (2)");
                                        String selectGender = sc.nextLine().strip();
                                        switch (selectGender) {
                                            case "1" -> {
                                                System.out.println(ANSI_CYAN + "~ Вы выбрали мужской пол." + ANSI_RESET);
                                                break;
                                            }
                                            case "2" -> {
                                                System.out.println(ANSI_CYAN + "~ Вы выбрали женский пол." + ANSI_RESET);
                                                break;
                                            }
                                            default -> {
                                                System.out.println(ANSI_RED + "~ Ошибка в вводе пола!" + ANSI_RESET);
                                                continue;
                                            }
                                        }

                                        System.out.println("~ Расскажите о себе: ");
                                        String requirements = sc.nextLine().strip();
                                        if (!Validate.validate(requirements)) {System.out.println(ANSI_YELLOW + "~ Неккоректно ввели Информацию о себе. Скорее всего она пуста :(" + ANSI_RESET);continue;}

                                        System.out.println("~ Расскажите о ваших предпочтениях: ");
                                        String request = sc.nextLine().strip();
                                        if (!Validate.validate(requirements)) {System.out.println(ANSI_YELLOW + "~ Неккоректно ввели Требования к партнеру. Нужно все равно указать :(" + ANSI_RESET);continue;}

//                                      Доп.Проверка
                                        if (!TextCorrect.textCorrect(family, name, patronymic)) {
                                            System.out.println(ANSI_YELLOW + "~ Неккоректно введено ФИО." + ANSI_RESET);
                                            continue;
                                        }
                                            if (!Validate.validate(family, name, patronymic, selectGender, requirements, request)) {
                                                System.out.println(ANSI_YELLOW + "~ Вы не ввели один из аргументов." + ANSI_RESET);
                                                selectOption();
                                            }
                                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                                            Date date = new Date(System.currentTimeMillis());
                                            String dateRegister = formatter.format(date);
                                            Human newHuman = new Human(family, name, patronymic, selectGender, requirements, request, dateRegister);
                                            humans.put(newHuman.getID(), newHuman);
                                            arrayList.add(newHuman);
                                        System.out.println(ANSI_GREEN + "~ Вы успешно создали Анкету." + ANSI_RESET);

                                    }
                                        case "0" -> {
                                            selectOption();
                                        }
                                    }
                            }
                            case "2" -> {
                                selectOption();
                                }  default -> {
                                    System.out.println(ANSI_RED + "~ Неверный ввод!" + ANSI_RESET);
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
                            System.out.println(ANSI_GREEN +"~ Пользователь удален" + ANSI_RESET);
                        } else {
                            System.out.println(ANSI_RED +"~ Пользователя с таким ID не существует" + ANSI_RESET);
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println(ANSI_YELLOW + "Некорректно указан ID" + ANSI_RESET);
                    }
                }
                case "3" -> {
                    if (humans.isEmpty()) {
                        System.out.println(ANSI_YELLOW + "~ Анкеты еще не созданы." + ANSI_RESET);
                        continue;
                    }

                    System.out.println("~ Список всех Анкет: ");
                    System.out.println(Strings.join("", humans.values().stream().toList()));
                }

                case "4" -> {
                    Search.searchGender(arrayList);
                }

                case "0" -> {
                    System.out.println(ANSI_CYAN + "~ Вы остановили программу" + ANSI_RESET);
                    return;
                }
                default -> System.out.println(ANSI_RED + "~ Неверный ввод!" + ANSI_RESET);

            }
        }

    }

}