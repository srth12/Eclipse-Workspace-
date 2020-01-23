package com.trial.streams;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class AggregateConcurrentStreams implements GroupingBy{
    public static void main(String[] args) {

    }

    public void testMethod() {
        ConcurrentMap<String, AverageAccumulator> map = new ConcurrentHashMap<>();
        map.computeIfAbsent("a", key -> new AverageAccumulator());

    }

    @Override
    public Map<YearCountry, Double> average(Collection<Person> persons) {
        return persons.parallelStream().collect(Collectors.groupingBy(YearCountry::new, Collectors.averagingDouble(Person::salary)));
    }

    private final class AverageAccumulator{
        int count;
        double sum;
        synchronized void add(double term) {
            count++;
            sum += term;
        }
        double average() {
            return sum / count;
        }
    }

}

final class Person {
    private final String firstName;
    private final String lastName;
    private final int birthYear;
    private final String country;
    private final double salary;
    public Person(String firstName,
                  String lastName,
                  int birthYear,
                  String country,
                  double salary) {
        this.firstName = requireNonNull(firstName);
        this.lastName = requireNonNull(lastName);
        this.birthYear = birthYear;
        this.country = requireNonNull(country);
        this.salary = salary;
    }
    public String firstName() { return firstName; }
    public String lastName() { return lastName; }
    public int birthYear() { return birthYear; }
    public String country() { return country; }
    public double salary() { return salary; }
    // equals, hashCode and toString not shown for brevity
}

final class YearCountry {
    private final int birthYear;
    private final String country;
    public YearCountry(Person person) {
        this.birthYear = person.birthYear();
        this.country = person.country();
    }
    public int birthYear() { return birthYear; }
    public String country() { return country; }
    // equals, hashCode and toString not shown for brevity
}

interface GroupingBy {
    Map<YearCountry, Double> average(Collection<Person> persons);
}

