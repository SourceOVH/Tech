package Service;

public class Validate {
    public static boolean validate(String... strings) {
        for (String string : strings)
            if (string.isEmpty())
                return false;
        return true;
    }
}
