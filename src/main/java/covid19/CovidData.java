package covid19;

public class CovidData {
    private String region;
    private String ageGroup;
    private int confirmedCases;
    private int deaths;
    private int intensiveCarePatients;
    private int hospitalised;
    private String date;

    public CovidData(String region, String ageGroup, int confirmedCases,
                     int deaths, int intensiveCarePatients, int hospitalised, String date) {
        this.region = region;
        this.ageGroup = ageGroup;
        this.confirmedCases = confirmedCases;
        this.deaths = deaths;
        this.intensiveCarePatients = intensiveCarePatients;
        this.hospitalised = hospitalised;
        this.date = date;
    }

    public String getRegion() {
        return region;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public int getConfirmedCases() {
        return confirmedCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getIntensiveCarePatients() {
        return intensiveCarePatients;
    }

    public int getHospitalised() {
        return hospitalised;
    }

    public String getDate() {
        return date;
    }
}
