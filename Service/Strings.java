package Service;

import Entity.Human;

import java.util.List;

public class Strings {
    public static String join(String delimiter, List<Human> humans) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < humans.size(); i++) {
            Human human = humans.get(i);
            builder.append(human.toString());
            if (i + 1 != humans.size())
                builder.append(delimiter);
        }

        return builder.toString();
    }
}
