package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumOfScores = 0.0;
        int numberOfSubjects = 0;
        for (Pupil pupil : pupils) {
            numberOfSubjects += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sumOfScores += subject.score();
            }
        }
        return sumOfScores / numberOfSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> listOfPupils = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumOfScores = 0.0;
            int numberOfSubjects = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sumOfScores += subject.score();
            }
            listOfPupils.add(new Label(pupil.name(),
                    sumOfScores / numberOfSubjects));
        }
        return listOfPupils;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> listOfSubjects = new LinkedHashMap<>();
        List<Label> labelSubjects = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!listOfSubjects.containsKey(subject.name())) {
                    listOfSubjects.put(subject.name(), 0);
                }
                listOfSubjects.put(subject.name(), listOfSubjects.get(subject.name()) + subject.score());
            }
        }
        for (String name : listOfSubjects.keySet()) {
            labelSubjects.add(new Label(name, (double) listOfSubjects.get(name) / pupils.size()));
        }
        return labelSubjects;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> listOfPupils = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumOfScores = 0.0;
            for (Subject subject : pupil.subjects()) {
                sumOfScores += subject.score();
            }
            listOfPupils.add(new Label(pupil.name(), sumOfScores));
        }
        Label bestPupil = listOfPupils.get(0);
        for (Label pupil : listOfPupils) {
            if (pupil.compareTo(bestPupil) > 0) {
                bestPupil = pupil;
            }
        }
        return bestPupil;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> listOfSubjects = new LinkedHashMap<>();
        List<Label> labelSubjects = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!listOfSubjects.containsKey(subject.name())) {
                    listOfSubjects.put(subject.name(), 0);
                }
                listOfSubjects.put(subject.name(), listOfSubjects.get(subject.name()) + subject.score());
            }
        }
        for (String name : listOfSubjects.keySet()) {
            labelSubjects.add(new Label(name, listOfSubjects.get(name)));
        }
        Label bestSubject = labelSubjects.get(0);
        for (Label subject : labelSubjects) {
            if (subject.compareTo(bestSubject) > 0) {
                bestSubject = subject;
            }
        }
        return bestSubject;
    }
}