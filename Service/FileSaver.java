package Service;

import Entity.Human;

import java.io.*;
import java.util.ArrayList;

public class FileSaver {

    public static ArrayList<Human> arrayList = new ArrayList<>();

    public void fileSaver() {

        try{
            OutputStream f = new FileOutputStream("C:\\Generate\\File.txt", true);
            OutputStreamWriter writer = new OutputStreamWriter(f);

            BufferedWriter out = new BufferedWriter(writer);

            for (int i = 0; i < arrayList.size(); i++) {
                out.write(String.valueOf(arrayList.get(i)));
                out.flush();

            }
        }catch (IOException ex){ex.printStackTrace();}
    }
}
