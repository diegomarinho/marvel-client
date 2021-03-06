
package com.marvel.developer.models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "code",
    "status",
    "copyright",
    "attributionText",
    "attributionHTML",
    "data",
    "etag"
})
public class CharacterDataWrapper {

    @JsonProperty("code")
    public int code;
    @JsonProperty("status")
    public String status;
    @JsonProperty("copyright")
    public String copyright;
    @JsonProperty("attributionText")
    public String attributionText;
    @JsonProperty("attributionHTML")
    public String attributionHTML;
    @JsonProperty("data")
    public CharacterDataContainer data;
    @JsonProperty("etag")
    public String etag;

}
