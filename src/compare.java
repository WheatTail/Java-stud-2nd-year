import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class compare {
    public static void main(String[] args) throws Exception{
        Set<String> mainVocabulary = new HashSet<String>();
        Set<String> additionalVocabulary = new HashSet<String>();
        System.out.print("Чтение основного словаря... ");
        try {
            FileReader fr = new FileReader("mainVocabulary.txt");
            Scanner read = new Scanner(fr);
            while (read.hasNextLine()){
                mainVocabulary.add(read.nextLine());
            }
            System.out.println("Ок");
        }
        catch (FileNotFoundException e){
            System.out.print("Основной словарь не найден");
        }
        catch (Exception e){
            throw new Exception();
        }
        System.out.print("Чтение дополнительного словаря... ");
        try {
            FileReader fr = new FileReader("additionalVocabulary.txt");
            Scanner read = new Scanner(fr);
            while (read.hasNextLine()){
                additionalVocabulary.add(read.nextLine());
            }
            System.out.println("Ок");
        }
        catch (FileNotFoundException e){
            System.out.print("Дополнительный словарь не найден");
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
