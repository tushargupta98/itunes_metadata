package com.itunes.search.util;

/**
 * @author TUSHAR
 *
 * */

public enum ItunesApiQueryKeys {
    TERM("term"),
    ATTRIBUTE("attribute"),
    ENTITY("entity");
    private String key;
    ItunesApiQueryKeys(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
