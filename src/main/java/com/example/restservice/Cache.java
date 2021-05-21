package com.example.restservice;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {
    private Map<SearchMap, Greeting> map = new HashMap<>();

    public boolean searchGreeting(SearchMap searchMap) {
        return map.containsKey(searchMap);
    }

    public void addGreeting(SearchMap searchMap, Greeting greeting) {
        map.put(searchMap, greeting);
    }

    public Greeting getGreeting(SearchMap searchMap) {
        return map.get(searchMap);
    }

    public Collection<Greeting> getCache() {
        return map.values();
    }
}

