package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.subjects().stream()).mapToInt(Subject::score).average().orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.name(), x.subjects().stream().mapToInt(Subject::score).average().orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score)
                ))
                .entrySet().stream().map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.name(), x.subjects().stream().mapToInt(Subject::score).sum()))
                .max(Comparator.comparing(Tuple::score)).get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::score)
                ))
                .entrySet().stream().map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparing(Tuple::score)).get();
    }
}