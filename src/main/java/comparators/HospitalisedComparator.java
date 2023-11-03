package comparators;

import covid19.CovidData;

import java.util.Comparator;

public class HospitalisedComparator implements Comparator<CovidData> {

    @Override
    public int compare(CovidData covidData1, CovidData covidData2) {
        return Integer.compare(covidData1.getHospitalised(), covidData2.getHospitalised());
    }

}
