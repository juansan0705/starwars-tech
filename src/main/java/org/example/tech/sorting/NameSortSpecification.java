package org.example.tech.sorting;

import org.example.tech.model.People;
import org.example.tech.model.Starship;
import org.example.tech.sorting.util.SortSpecification;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NameSortSpecification<T> implements SortSpecification<T> {
    @Override
    public List<T> sort(List<T> items, boolean ascending) {
        Comparator<T> comparator = Comparator.comparing(item -> {
            if (item instanceof People) {
                return ((People) item).getName();
            } else if (item instanceof Starship) {
                return ((Starship) item).getName();
            }
            return "";
        });
        if (!ascending) {
            comparator = comparator.reversed();
        }
        return items.stream().sorted(comparator).collect(Collectors.toList());
    }
}