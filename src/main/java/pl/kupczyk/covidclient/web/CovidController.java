package pl.kupczyk.covidclient.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("deaths")
    public Integer getData(){
        return service.utils.listSum(service.getDeaths());
    }

}
