package Assignment2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

class SaveToDisk {
    void saveDetails(File filename, ArrayList<Student> st) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(st);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out!=null) {
                out.close();
            }
            if(fos!=null) {
                fos.close();
            }
        }
    }
}
