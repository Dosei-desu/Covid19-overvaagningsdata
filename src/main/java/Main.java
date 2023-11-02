import covid19.CovidData;
import covid19.DataReader;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        System.out.printf("|%12s|%9s|%15s|%6s|%14s|%12s|%10s|\n",
                "-".repeat(12),"-".repeat(9),"-".repeat(15),"-".repeat(6),
                "-".repeat(14),"-".repeat(12),"-".repeat(10));

        System.out.printf("""
                |%12s|%9s|%15s|%6s|%14s|%12s|%10s|
                ""","---Region---","Age Group","Confirmed Cases","Deaths",
                "Intensive Care","Hospitalised","---Date---");

        System.out.printf("|%12s|%9s|%15s|%6s|%14s|%12s|%10s|\n",
                "-".repeat(12),"-".repeat(9),"-".repeat(15),"-".repeat(6),
                "-".repeat(14),"-".repeat(12),"-".repeat(10));

        int count = 0;
        for (CovidData data: dataReader.read()) {
            count++;
            System.out.printf("""
                |%12s|%9s|%15d|%6d|%14d|%12d|%10s|
                """,data.getRegion(),data.getAgeGroup(),data.getConfirmedCases(),data.getDeaths(),
                    data.getIntensiveCarePatients(),data.getHospitalised(),data.getDate());
            if (count == 5){
                System.out.printf("|%12s|%9s|%15s|%6s|%14s|%12s|%10s|\n",
                        "-".repeat(12),"-".repeat(9),"-".repeat(15),"-".repeat(6),
                        "-".repeat(14),"-".repeat(12),"-".repeat(10));
                count = 0;
            }
        }
    }
}
