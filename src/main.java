import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        Set<String> someWords = new HashSet<String>();
        String addWord;
        String exitWord;
        FileReader fr = new FileReader("vocabulary.txt");
        Scanner read = new Scanner(fr);
        while (read.hasNextLine()){
            someWords.add(read.nextLine());
        }

        FileWriter fw = new FileWriter("vocabulary.txt");
        fw.write("окно");
        fw.close();

        //someWords.add("Окно");
        //someWords.add("Пингвин");
        //someWords.add("Яблоко");
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
        //for (String entry: someWords) {
        //    System.out.println(entry);
        //}
    }
}
