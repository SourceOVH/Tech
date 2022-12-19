package Entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Human {
    private static AtomicInteger idCounter = new AtomicInteger(0);
    private String family;
    private String name;
    private String patronymic;
    private String gender;
    private String requirements;
    private String request;
    private String dateRegister;
    private int ID;

    public Human(String family, String name, String patronymic, String gender, String requirements, String request, String dateRegister) {
        this.ID = idCounter.addAndGet(1);
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        if (gender.equalsIgnoreCase("1")) {
            this.gender = "Мужчина";
        } else {
            this.gender = "Женщина";
        }
        this.requirements = requirements;
        this.request = request;
        this.dateRegister = dateRegister;
    }

    @Override
    public String toString() {
        return "-----------------"
                + '\n'
                +"Фамилия: " + family + '\n'
                + "Имя: " + name + '\n'
                + "Отчество: " + patronymic + '\n'
                + "Пол: " + gender + '\n'
                + "О себе: " + requirements + '\n'
                + "Запрос от партнера: " + request + '\n'
                + "Дата регистрации: " + dateRegister + '\n'
                + "ID: " + getID() + '\n'
                + "-----------------"
                + '\n';
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
