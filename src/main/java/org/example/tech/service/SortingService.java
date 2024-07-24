package org.example.tech.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortingService<T> {

    public List<T> sortByName(List<T> list, boolean ascending) {
        Comparator<T> comparator = Comparator.comparing(T::toString);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        return list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<T> sortByCreated(List<T> list, boolean ascending) {
        Comparator<T> comparator = Comparator.comparing(T::toString);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        return list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
