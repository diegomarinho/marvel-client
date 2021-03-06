
package com.marvel.developer.models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "language",
    "text"
})
public class TextObject {

    @JsonProperty("type")
    public String type;
    @JsonProperty("language")
    public String language;
    @JsonProperty("text")
    public String text;

}
