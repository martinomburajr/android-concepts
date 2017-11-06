package com.martinomburajr.concepts.threading.loaders.asynctaskloader.retrofitapi;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "searchinfo",
        "search",
        "success"
})
public class WikipediaModel {

    @JsonProperty("searchinfo")
    private Searchinfo searchinfo;
    @JsonProperty("search")
    private List<Search> search = null;
    @JsonProperty("success")
    private Integer success;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("searchinfo")
    public Searchinfo getSearchinfo() {
        return searchinfo;
    }

    @JsonProperty("searchinfo")
    public void setSearchinfo(Searchinfo searchinfo) {
        this.searchinfo = searchinfo;
    }

    @JsonProperty("search")
    public List<Search> getSearch() {
        return search;
    }

    @JsonProperty("search")
    public void setSearch(List<Search> search) {
        this.search = search;
    }

    @JsonProperty("success")
    public Integer getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Integer success) {
        this.success = success;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}