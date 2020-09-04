package pl.kupczyk.covidclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Region {
    private String iso;
    private String name;
    private String province;
    private String lat;
    @JsonProperty("long")
    private String lon;
}