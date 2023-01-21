package SerializationAndDeserialiation;

import java.io.*;

class Test implements Serializable{

    int i=10,j=20;

}
public class SerialiAndDeseriali {
    public static void main(String args[]) throws IOException, ClassNotFoundException {

        Test test1 = new Test();
        //Test test2 =new Test();

        //Serialization :-

        FileOutputStream fos = new FileOutputStream("test.txt"); //write our file to memory
        ObjectOutputStream Oss = new ObjectOutputStream(fos);   //Convert object to file file
        Oss.writeObject(test1); //exactly convert object to file format

        //Deserialization :-

        FileInputStream infos = new FileInputStream("test.txt");
        ObjectInputStream inOss = new ObjectInputStream(infos);
        Test test2 = (Test) inOss.readObject();
        System.out.println(test2.i+"  "+ test2.j);
    }
}
