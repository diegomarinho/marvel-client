
package com.marvel.developer.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "available",
    "returned",
    "collectionURI",
    "items"
})
public class CreatorList {

    @JsonProperty("available")
    public int available;
    @JsonProperty("returned")
    public int returned;
    @JsonProperty("collectionURI")
    public String collectionURI;
    @JsonProperty("items")
    public List<CreatorSummary> items = new ArrayList<CreatorSummary>();

}
