package ru.job4j.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.map(Pupil::getSubjects)
                .flatMap(List::stream)
                .mapToInt(x -> x.getScore())
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(
                x.getName(),
                x.getSubjects().stream()
                        .mapToInt(y -> y.getScore())
                        .average()
                        .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        var lstTupl = stream.map(x -> x.getSubjects())
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(y -> new Tuple(y.getKey(), y.getValue()))
                .collect(Collectors.toList());
        Collections.reverse(lstTupl);
        return lstTupl;
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(),
                x.getSubjects().stream()
                        .mapToInt(y -> y.getScore())
                        .sum()))
                .max((left, right) -> Double.compare(left.getScore(), right.getScore()))
                .orElse(new Tuple("Ivanov", 0D));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.map(x -> x.getSubjects())
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(y -> new Tuple(y.getKey(), y.getValue()))
                .max((left, right) -> Double.compare(left.getScore(), right.getScore()))
                .orElse(new Tuple("Math", 0D));
    }
}