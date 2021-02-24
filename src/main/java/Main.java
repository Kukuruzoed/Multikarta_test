import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /**
     *
     * @param string основная строка со списком Id
     * @param array массив строк элементы которого должны проверяться на наличие в них Id из основной строки
     * @return список строк в которые содержат все Id из основной строки
     */
    public static List<String> getArrayStrings(String string, String[] array){
        List<String> list = new ArrayList<>();
        List<String> mainIdList = getIdListFromString(string);
        if(mainIdList.size() > 3 || mainIdList.isEmpty())
            return list;

        for(String stringForCheck : array){
            if(compareIds(mainIdList, stringForCheck)){
                list.add(stringForCheck);
            }
        }

        writeToCSV(list);

        return list;
    }

    /**
     * записывает все элементы списка в файл *.csv
     * @param list список строк
     */
    public static void writeToCSV(List<String> list){
        String csv = "list.csv";
        try(CSVWriter writer = new CSVWriter(new FileWriter(csv))){
            String[] array = new String[list.size()];
            writer.writeNext(list.toArray(array));
        }catch (IOException ignored){}
    }

    /**
     * Проверяет содержит ли строка compareString значения из списка mainIdList
     * @param mainIdList
     * @param compareString
     * @return
     */
    public static boolean compareIds(List<String> mainIdList, String compareString){
        return getIdListFromString(compareString).containsAll(mainIdList);
    }

    /**
     * 
     * @param string
     * @return
     */
    public static List<String> getIdListFromString(String string){
        return Arrays.stream(string.trim().split("[ ,]+")).filter(x->!x.isEmpty()).collect(Collectors.toList());
    }
}
