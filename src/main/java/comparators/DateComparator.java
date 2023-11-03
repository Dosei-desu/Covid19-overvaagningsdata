package comparators;

import covid19.CovidData;

import java.util.Comparator;

public class DateComparator implements Comparator<CovidData> {

    @Override
    public int compare(CovidData covidData1, CovidData covidData2) {
        return String.CASE_INSENSITIVE_ORDER.compare(covidData1.getDate(), covidData2.getDate());
    }

}
