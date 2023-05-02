package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 2", 100),
                new Attachment("image 1", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparatorBySize = (o1, o2) -> Integer.compare(o1.getSize(), o2.getSize());
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(left.length(), right.length());
        System.out.println(attachments);
    }
}
