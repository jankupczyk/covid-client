package pl.kupczyk.covidclient.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kupczyk.covidclient.model.Data;
import pl.kupczyk.covidclient.model.Region;
import pl.kupczyk.covidclient.utils.DataUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class CovidService {
    public List<Integer> getConfirmed(){
        return DataUtils.downloadData().stream().map(Data::getConfirmed)
                .collect(Collectors.toList());
    }

    public List<Integer> getDeaths(){
        return DataUtils.downloadData().stream().map(Data::getDeaths)
                .collect(Collectors.toList());
    }

    public List<Integer> getRecovered(){
        return DataUtils.downloadData().stream().map(Data::getRecovered)
                .collect(Collectors.toList());
    }

    public List<String> getCountryIso(){
        return DataUtils.downloadData().stream().map(Data::getRegion)
                .collect(Collectors.toList())
                .stream()
                .map(Region::getIso)
                .collect(Collectors.toList());
    }

    public List<String> getDateAsAt(){
        return DataUtils.downloadData().stream().map(Data::getLast_update)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getInfectionCityRate(){
        return IntStream.range(0, getCountryIso().size()).boxed()
                .collect(Collectors.toMap(getCountryIso()::get, getConfirmed()::get));
    }
}
