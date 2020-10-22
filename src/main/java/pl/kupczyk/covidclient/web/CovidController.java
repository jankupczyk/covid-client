package pl.kupczyk.covidclient.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kupczyk.covidclient.utils.DataUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CovidController {

    public final CovidService service;

    public CovidController() {
        service = new CovidService();
    }

    @RequestMapping("covid")
    public String getData(Model model){
        model.addAttribute("service", service);

        return "index";
    }

    @RequestMapping("total")
    public List<Integer> totalSum(){
        return Stream.of(DataUtils.total(service.getDeaths()), DataUtils.total(service.getConfirmed()), DataUtils.total(service.getRecovered()))
                .collect(Collectors.toList());
    }

    @RequestMapping("total2")
    public Map<String, Integer> totalSum2(){
        return Map.of("deaths", DataUtils.total(service.getDeaths()),
                "confirmed", DataUtils.total(service.getConfirmed()),
                "recovered", DataUtils.total(service.getRecovered()));
    }

}
