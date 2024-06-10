package de.tum.in.ase.eist;

import java.util.List;

public class BinarySearch implements SearchStrategy {

    @Override
    public int performSearch(List<Chapter> chapters, String chapterName) {
        return binarySearch(chapters, chapterName);
    }

    private int binarySearch(List<Chapter> chapters, String chapterName) {
        int left = 0;
        int right = chapters.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Chapter midChapter = chapters.get(mid);

            int comparison = midChapter.getName().compareTo(chapterName);
            if (comparison == 0) {
                return midChapter.getPageNumber();
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
