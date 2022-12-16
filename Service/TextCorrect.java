package Service;

public class TextCorrect {
    public static boolean textCorrect(String... text){
        for (String string : text)
            if (!string.matches("[А-Я][а-я]{2,15}")) {
                return false;
            } return true;
    }
}
