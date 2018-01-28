import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException{
        Set<String> someWords = new HashSet<String>();
        String addWord;
        String exitWord;
        System.out.println("Словарь v0.1b");
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
            System.out.print("Непредвиденная ошибка");
            e.printStackTrace();
        }
        System.out.println("Вывод содержимого словаря...");
        for (String entry: someWords) {
            System.out.println(entry);
        }
        //FileWriter fw = new FileWriter("vocabulary.txt");
        //fw.write("окно");
        //fw.close();

        for (String entry: someWords){
            System.out.println(entry);
        }
        //System.out.println("Выход из цикла после добавления пяти новых слов");
        //System.out.println("Какие слова добавлять?");
        /*while (true) {
            if (someWords.contains(addWord = reader.next())) {
                System.out.println("Такое слово уже есть");
            } else {
                someWords.add(addWord);
            }
        }*/

    }
}
