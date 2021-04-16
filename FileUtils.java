import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    private static final long serialVersionUID = 1998L;

    public int id;
    public String name;
    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(this.id + " - " + this.name);
    }
}

public class FileUtils {
    public static void writeObjectToFile(Object object, String filePath) {
        try {
            // Create stream objects
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write object to file
            objectOutputStream.writeObject(object);

            // Close stream
            objectOutputStream.close();
            fileOutputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readObjectFromFile(String filePath) {
        Object object = null;
        try {
            // Create stream objects
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // Read object from file
            object = objectInputStream.readObject();

            // Close stream
            objectInputStream.close();
            fileInputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    public static void main(String[] args) {
        Student st1 = new Student(161, "PNT");
        String filePath = "st1.obj";

        // Write student
        writeObjectToFile(st1, filePath);

        // Read student
        Student st2 = (Student) readObjectFromFile(filePath);
        System.out.println(st2);
    }
}
