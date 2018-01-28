import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        Set<String> someWords = new HashSet<String>();
        System.out.print("Developed by /u03C9/");
        System.out.println("Словарь v0.2b");
        System.out.print("Чтение файла... ");
        try{
            FileReader fr = new FileReader("vocabulary.txt");
            Scanner read = new Scanner(fr);
            while (read.hasNextLine()){
                someWords.add(read.nextLine());
            }
            System.out.println("Ок");
        }
        catch (FileNotFoundException e){
            System.out.print("Файл не найден");
        }
        catch (Exception e){
            System.out.println("Непредвиденная ошибка");
            e.printStackTrace();
        }
        System.out.println("Вывод содержимого словаря...");
        for (String entry: someWords) {
            System.out.println(entry);
        }
        System.out.println("Чтобы внести новые слова введите Add, чтобы выйти - Exit");
        String responce = reader.next();
        responce = responce.toLowerCase();
        if (responce.equals("add")) {
            System.out.println("Вводите каждое слово с новой строки. Для выхода введите c");
            while (true){
                String stringToAdd=reader.next();
                if (stringToAdd.equals("c") || stringToAdd.equals("с")){ //Английская и русская
                    break;
                }
                else {
                    someWords.add(stringToAdd);
                }
            }
        }
        else if (responce.equals("exit")){
            System.out.print("Выход из программы.");
            return;
        }
        else {
            System.out.print("Неверное значение приводит к выходу.");
        }
        try {
            FileWriter fw = new FileWriter("vocabulary.txt");
            for (String entry: someWords){
                fw.write(entry+"\r\n");
                fw.flush();
            }
            fw.close();
        }
        catch (IOException e){
            System.out.print("Ошибка ввода-вывода");
        }
        catch (Exception e){
            System.out.println("Непредвиденная ошибка");
            e.printStackTrace();
        }
    }
}
