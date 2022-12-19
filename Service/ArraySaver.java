package Service;

import Entity.Human;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArraySaver {
    public HumanGenerator saveList;

    public void fileSaver() throws IOException {
        saveList = new HumanGenerator();
        ArrayList<Human> arrayList = saveList.getArrayList();

        FileWriter writer = new FileWriter("C:\\Generate\\Arrays.txt");
        for(Human str: arrayList) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

}
