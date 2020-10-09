package pl.kupczyk.covidclient.utils;

import org.springframework.web.client.RestTemplate;
import pl.kupczyk.covidclient.model.CovidData;
import pl.kupczyk.covidclient.model.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class DataUtils {

    public static final String URL = "https://covid-api.com/api/reports";

    public String generateFile(){
        String url = "https://raw.githubusercontent.com/" +
                "CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";

        LocalDate date = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        url = url + date.format(formatter) + ".csv";

        return url;
    }

    public List<Data> downloadData(){
        RestTemplate restTemplate = new RestTemplate();
        CovidData list = restTemplate.getForObject(URL, CovidData.class);

        return Objects.requireNonNull(list).getData();
    }

    public Integer listSum(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).sum();
    }

}
