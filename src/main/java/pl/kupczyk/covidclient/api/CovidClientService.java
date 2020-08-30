package pl.kupczyk.covidclient.api;

import com.opencsv.CSVParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CovidClientService {

    public static final String url = "https://raw.githubusercontent.com/" +
            "CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/08-29-2020.csv";



    }
}
