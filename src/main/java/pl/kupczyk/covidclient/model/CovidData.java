package pl.kupczyk.covidclient.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CovidData {
    @CsvBindByName(column = "Province_State")
    private String state;
    @CsvBindByName(column = "Country_Region")
    private String country;
    @CsvBindByName(column = "Last_Update")
    private String lastUpdate;
    @CsvBindByName(column = "Lat")
    private Float lat;
    @CsvBindByName(column = "Long_")
    private Float lon;
    @CsvBindByName(column = "Confirmed")
    private int confirmed;
    @CsvBindByName(column = "Deaths")
    private int deaths;
    @CsvBindByName(column = "Recovered")
    private int recovered;
    @CsvBindByName(column = "Active")
    private int active;
    @CsvBindByName(column = "Incidence_Rate")
    private BigDecimal incidenceRate;
    @CsvBindByName(column = "Case-Fatality_Ratio")
    private BigDecimal fatalityRatio;
}
