import comparators.*;
import covid19.CovidData;
import covid19.DataReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        ArrayList<CovidData> dataList = dataReader.read();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = 0;
            while (choice != 9) {
                System.out.println("""
                        1. --- Sort by Region
                        2. --- Sort by Age Group
                        3. --- Sort by Confirmed Cases
                        4. --- Sort by Deaths
                        5. --- Sort by Intensive Care Cases
                        6. --- Sort by Hospitalised
                        7. --- Sort by Date
                        8. --- Sort by Region & Confirmed Cases
                        9. --- Close Program""");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> Collections.sort(dataList, new RegionComparator());
                    case 2 -> Collections.sort(dataList, new AgeGroupComparator());
                    case 3 -> Collections.sort(dataList, new ConfirmedCaseComparator().reversed());
                    case 4 -> Collections.sort(dataList, new DeathsComparator().reversed());
                    case 5 -> Collections.sort(dataList, new IntensiveCareComparator().reversed());
                    case 6 -> Collections.sort(dataList, new HospitalisedComparator().reversed());
                    case 7 -> Collections.sort(dataList, new DateComparator().
                            thenComparing(new RegionComparator()));
                    case 8 -> Collections.sort(dataList, new RegionComparator().
                            thenComparing(new ConfirmedCaseComparator().reversed()));
                }
                print(dataList);
            }

        }
    }

    public static void spacing() {
        System.out.printf("|%12s|%9s|%15s|%6s|%14s|%12s|%10s|\n",
                "-".repeat(12), "-".repeat(9), "-".repeat(15), "-".repeat(6),
                "-".repeat(14), "-".repeat(12), "-".repeat(10));
    }

    public static void print(ArrayList<CovidData> datalist) {
        spacing();
        System.out.printf("""
                        |%12s|%9s|%15s|%6s|%14s|%12s|%10s|
                        """, "---Region---", "Age Group", "Confirmed Cases", "Deaths",
                "Intensive Care", "Hospitalised", "---Date---");
        spacing();

        for (CovidData data : datalist) {
            System.out.printf("""
                            |%12s|%9s|%15d|%6d|%14d|%12d|%10s|
                            """, data.getRegion(), data.getAgeGroup(), data.getConfirmedCases(), data.getDeaths(),
                    data.getIntensiveCarePatients(), data.getHospitalised(), data.getDate());

        }
        spacing();
    }
}
