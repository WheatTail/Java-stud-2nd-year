import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class compare {
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
            System.out.println("Ок");
        }
        catch (FileNotFoundException e){
            System.out.print("Основной словарь не найден");
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
            System.out.println("Ок");
        }
        catch (FileNotFoundException e){
            System.out.print("Дополнительный словарь не найден");
            return;
        }
        catch (Exception e){
            throw new Exception();
        }
        System.out.println("Чтобы проверить перекрытия введите Cover");
        System.out.println("Чтобы проверить вхождения, которых нет в основном словаре введите Right");
        System.out.println("Чтобы проверить вхождения, которых нет в дополнительном словаре введите Left");
        String response = reader.next();
        response=response.toLowerCase();
        switch (response){
            case "cover":
                System.out.println("Вывод вхождений, имеющихся в обоих словарях:");
                for (String mainEntry: mainVocabulary){
                    for (String additionalEntry: additionalVocabulary){
                        if(mainEntry.equals(additionalEntry)){
                            System.out.println(additionalEntry);
                        }
                    }
                }
                break;
            case "left":
                System.out.println("Вывод вхождений, имеющихся только в основном словаре:");
                try{
                    leftRightCompare(mainVocabulary, additionalVocabulary);
                }
                catch (Exception e){
                    System.out.println("Непредвиденная ошибка");
                    e.printStackTrace();
                }
                break;
            case "right":
                System.out.println("Вывод вхождений, имеющихся только в дополнительном словаре:");
                try{
                    leftRightCompare(additionalVocabulary, mainVocabulary);
                }
                catch (Exception e){
                    System.out.println("Непредвиденная ошибка");
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Неверное значение приводит к завершению");
                return;
        }
        return;
    }
    public static void leftRightCompare(Set<String> firstSet, Set<String> secondSet) throws Exception{
        try{
            for (String firstEntry: firstSet){
                boolean exist = false;
                for (String additionalEntry: secondSet){
                    if(firstEntry.equals(additionalEntry)){
                        exist=true;
                        break;
                    }
                }
                if (false==exist){
                    System.out.println(firstEntry);
                }
            }
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
