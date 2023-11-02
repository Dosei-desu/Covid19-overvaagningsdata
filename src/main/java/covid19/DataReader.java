package covid19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    private final String FILE_NAME = "covid19_data_per_region.csv";

    public ArrayList<CovidData> read(){
        ArrayList<CovidData> covidDataList = new ArrayList<>();
        try(Scanner dataReader = new Scanner(new File(FILE_NAME))){
            String[] stringArray;
            while(dataReader.hasNextLine()){
                stringArray = dataReader.nextLine().split(";");
                if (validateLine(stringArray)){
                    covidDataList.add(new CovidData(
                            stringArray[0],stringArray[1],
                            Integer.parseInt(stringArray[2]),
                            Integer.parseInt(stringArray[3]),
                            Integer.parseInt(stringArray[4]),
                            Integer.parseInt(stringArray[5]),
                            stringArray[6]
                    ));
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return covidDataList;
    }

    private boolean validateLine(String[] stringArray){
        if(stringArray.length == 7){
            switch (stringArray[0].toLowerCase()){
                case "hovedstaden","midtjylland","nordjylland","sjælland","syddanmark" -> {
                    return true;
                }
            }
        }
        return false;
    }
}
