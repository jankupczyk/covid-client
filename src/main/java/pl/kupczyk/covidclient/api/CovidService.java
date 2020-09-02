package pl.kupczyk.covidclient.api;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kupczyk.covidclient.model.CovidData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CovidService {

    public String url = "https://raw.githubusercontent.com/" +
            "CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";

    public String generateFile(){
        LocalDate date = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        url = url + date.format(formatter) + ".csv";

        System.out.println(url);

        return url;
    }

    public void map() throws FileNotFoundException {
        CsvToBeanBuilder<CovidData> builder = new CsvToBeanBuilder<CovidData>(new InputStreamReader(new FileInputStream(generateFile())));

        builder.withType(CovidData.class);
        builder.build().parse().forEach(i -> i.toString());

    }
}
