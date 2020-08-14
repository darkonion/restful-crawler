package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Hotel {

    @JsonProperty
    private String name;

    @JsonProperty
    private String price;

    @JsonProperty
    private double score;
}
