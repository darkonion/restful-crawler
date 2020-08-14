package config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class BasicConfig extends Configuration {

    @NotNull
    private final String remoteAddress;

    @JsonCreator
    public BasicConfig(@JsonProperty("remoteAddress") String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }
}
