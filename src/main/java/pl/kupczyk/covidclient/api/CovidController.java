package pl.kupczyk.covidclient.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
@RequiredArgsConstructor
public class CovidController {

    public final CovidService service;

    @RequestMapping("covid")
    public String getData(Model model){
        model.addAttribute("service", service);
        return "index";
    }

}
