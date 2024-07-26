package org.example.tech.sorting.util;

import java.util.List;

public interface SortSpecification<T> {
    List<T> sort(List<T> list, boolean ascending);
}
