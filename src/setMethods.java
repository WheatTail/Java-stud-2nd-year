import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.invoke.SwitchPoint;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class setMethods {
    static Scanner reader = new Scanner(System.in);
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
            System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
        }
        catch (FileNotFoundException e){
            System.out.print("[ERR]Основной словарь не найден");
            return;
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
            System.out.println("["+(char)27+"[32mOK"+(char)27+"[30m"+"]");
        }
        catch (FileNotFoundException e){
            System.out.print("["+(char)27+"[31mERR"+(char)27+"[30m]дополнительный словарь не найден");
            return;
        }
        catch (Exception e){
            throw new Exception();
        }
        System.out.println("1) Добавить элемент в первый словарь");
        System.out.println("2) Добавить в первый словарь второй");
        System.out.println("3) Очистка словаря");
        System.out.println("4) Проверить содержание элемента в первом словаре");
        System.out.println("5) Проверить содержание в первом словаре полностью второго");
        System.out.println("6) Сравнить первый и второй словари");
        System.out.println("7) Проверить, пуст ли первый словарь");
        System.out.println("8) Удалить запись из первого словаря");
        System.out.println("9) Удалить все записи из первого словаря, совпадающие со вторым");
        System.out.println("10) Удалить все записи из первого словаря, которых нет во втором");
        System.out.println("11) Размер первого словаря");
        System.out.println("12) Сделать из первого словаря - массив");
        int responce = reader.nextInt();
        switch (responce){
            case 1:
                System.out.println("Введите слово для добавления");
                mainVocabulary.add(reader.next());
                System.out.println("Готово.");
                break;
            case 2:
                System.out.println("Добавляпем второй словарь в первый...");
                mainVocabulary.addAll(additionalVocabulary);
                System.out.println("Готово.");
                break;
            case 3:
                System.out.println("Очищаем словарь...");
                mainVocabulary.clear();
                System.out.println("Готово.");
                break;
            case 4:
                System.out.println("Проверить на содержание слова?..");
                if(mainVocabulary.contains(reader.next())){
                    System.out.println("Есть.");
                } else{
                    System.out.println("Нет.");
                }
                break;
            case 5:

                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
             default:
                break;
        }
    }
}
