package com.example.restservice;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GreetingController {

    private static final Logger logger = LogManager.getLogger(GreetingController.class);
    private CounterThread counterThread = new CounterThread();
    @Autowired
    private Cache cache;

    @Autowired
    private Arithmetic arithmetic;

    @Autowired
    private Bd bd;

    @GetMapping("/greeting")
    public List<Greeting> greeting(@RequestParam(value = "string", defaultValue = "-") List<String> string,
                                   @RequestParam(value = "symbol", defaultValue = "-") List<String> symbol) {
        Synchronization.semaphore.release();
        logger.info("Ok");
        List<SearchMap> searchMapList = new ArrayList<>();
        List<Greeting> greetingList = new ArrayList<>();
        makeList(string, symbol, searchMapList);
        greetingList.addAll(searchMapList.stream()
                .filter(cache::searchGreeting)
                .map(searchMap -> cache.getGreeting(searchMap))
                .collect(Collectors.toList()));
        greetingList.addAll(searchMapList.stream()
                .filter(searchMap -> !cache.searchGreeting(searchMap))
                .map(searchMap ->
                {
                    Greeting greeting = new Greeting(searchMap.getString(), searchMap.getSymbol());
                    cache.addGreeting(searchMap, greeting);
                    return greeting;
                })
                .collect(Collectors.toList()));
        Comparator<Greeting> comparatorMin= Comparator.comparing(Greeting::getCounter);
        Comparator<Greeting> comparatorMax= Comparator.comparing(Greeting::getCounter);
        Comparator<Greeting> comparatorMinLength= Comparator.comparing(Greeting::getLength);
        Comparator<Greeting> comparatorMaxLength= Comparator.comparing(Greeting::getLength);
        Greeting min = greetingList.stream().min(comparatorMin).get();
        Greeting max = greetingList.stream().max(comparatorMax).get();
        Greeting minLength = greetingList.stream().min(comparatorMinLength).get();
        Greeting maxLength = greetingList.stream().max(comparatorMaxLength).get();
        double avr = greetingList.stream().mapToDouble(greeting -> greeting.getCounter()).average().getAsDouble();
        arithmetic.setMax(max.getCounter());
        arithmetic.setMin(min.getCounter());
        arithmetic.setMaxLength(maxLength.getLength());
        arithmetic.setMinLength(minLength.getLength());
        arithmetic.setAvr(avr);

        Collection<Greeting> greetingCollection = cache.getCache();
        bd.buildExcel(greetingCollection);

        return greetingList;
    }
    /*    if ("-".equals(string) || string.length() > 25 || "-".equals(symbol) || symbol.length() != 1) {
            throw new BadRequestException();
        } else {
            logger.info("Ok");
            SearchMap searchMap = new SearchMap(string, symbol);
            if (cache.searchGreeting(searchMap)) {
                logger.info("An instance is already in map");
            } else {
                Greeting greeting = new Greeting(string, symbol);
                cache.addGreeting(searchMap, greeting);
                logger.info("An instance added in map");
            }
            return cache.getGreeting(searchMap);
     */

    public void makeList(List<String> string, List<String> symbol, List<SearchMap> searchMapList) {
        if (string.size() == symbol.size()) {
            for (int i = 0; i < symbol.size(); i++) {
                if ("-".equals(string.get(i)) || string.get(i).length() > 25 || "-".equals(symbol.get(i)) || symbol.get(i).length() != 1) {
                    throw new BadRequestException();
                }
                SearchMap searchMap = new SearchMap(string.get(i), symbol.get(i));
                searchMapList.add(searchMap);
            }

        }
    }
}