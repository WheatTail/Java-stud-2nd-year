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
        try{
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
                    System.out.println("проверяем первый словарь на вхождение в него второго...");
                    if(mainVocabulary.containsAll(additionalVocabulary)){
                        System.out.println("Есть.");
                    } else{
                        System.out.println("Нет.");
                    }
                    break;
                case 6:
                    System.out.println("Сравниваем первый и второй словари...");
                    if(mainVocabulary.equals(additionalVocabulary)){
                        System.out.println("Есть.");
                    } else{
                        System.out.println("Нет.");
                    }
                    break;
                case 7:
                    System.out.println("Проверяем, пуст ли первый словарь...");
                    if(mainVocabulary.isEmpty()){
                        System.out.println("Пуст.");
                    } else{
                        System.out.println("Не пуст.");
                    }
                    break;
                case 8:
                    System.out.println("Удалить из первого словаря слово?..");
                    mainVocabulary.remove(reader.next());
                    System.out.println("Готово.");
                    break;
                case 9:
                    System.out.println("Удаляем из первого словаря второй...");
                    mainVocabulary.removeAll(additionalVocabulary);
                    System.out.println("Готово.");
                    break;
                case 10:
                    System.out.println("Удаляем из первого словаря всё, кроме второго...");
                    mainVocabulary.retainAll(additionalVocabulary);
                    System.out.println("Готово.");
                    break;
                case 11:
                    System.out.println("Узнаём размер первого словаря...");
                    System.out.println(mainVocabulary.size());
                    System.out.println("Готово.");
                    break;
                case 12:
                    System.out.println("Делаем из первого словаря массив...");
                    String[] stringFromArray = mainVocabulary.toArray(new String[mainVocabulary.size()]);
                    System.out.println("Готово.");
                    break;
                default:
                    break;
            }
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
