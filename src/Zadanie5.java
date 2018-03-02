import java.io.*;
import java.util.Scanner;

public class Zadanie5 {
    public static void main(String[] args) {

        System.out.println("Podaj wyraz do zamiany");
         Scanner sc = new Scanner(System.in);
           String old = sc.nextLine();
          System.out.println("Podaj na co chcesz zamienić");
          String nowy = sc.nextLine();


        File file = new File("C:\\Users\\Marcin\\Desktop\\zakupy.txt");
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int read;
            while ((read = fileInputStream.read()) != -1) {
                stringBuilder.append((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
        }


        String tekst = stringBuilder.toString();

     //   System.out.println(tekst);

       String nowyNapis = tekst.replace(old, nowy);

        System.out.println(nowyNapis);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file); //////true czyli dołącz zapist nadpisz(nie usuwa całej zawartósci pliku
            try {
                fileOutputStream.write((nowyNapis + "\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}



