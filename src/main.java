import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        String addWord;
        int i=0;
        Set<String> someWords = new HashSet<String>();
        someWords.add("Окно");
        someWords.add("Пингвин");
        someWords.add("Яблоко");
        for (String entry: someWords){
            System.out.println(entry);
        }
        System.out.println("Выход из цикла после добавления пяти новых слов");
        System.out.println("Какие слова добавлять?");
        while (i<5) {
            if (someWords.contains(addWord = reader.next())) {
                System.out.println("Такое слово уже есть");
            } else {
                someWords.add(addWord);
                i++;
            }
        }
        for (String entry: someWords) {
            System.out.println(entry);
        }
    }
}