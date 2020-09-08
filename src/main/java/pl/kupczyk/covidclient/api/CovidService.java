package pl.kupczyk.covidclient.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kupczyk.covidclient.model.CovidData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CovidService {

    public String url = "https://raw.githubusercontent.com/" +
            "CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";

    public String URL = "https://covid-api.com/api/reports";

    public String generateFile(){
        LocalDate date = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        url = url + date.format(formatter) + ".csv";

        return url;
    }

    public CovidData downloadData(){
        RestTemplate restTemplate = new RestTemplate();
        CovidData list = restTemplate.getForObject(URL, CovidData.class);

        return list;
    }

    public List<int> getConfirmed(){

    }

}
