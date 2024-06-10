package de.tum.in.ase.eist;

import java.util.List;

public class Context {
    private SearchStrategy searchAlgorithm;
    private List<Chapter> chapters;

    public Context(SearchStrategy searchAlgorithm, List<Chapter> chapters) {
        this.searchAlgorithm = searchAlgorithm;
        this.chapters = chapters;
    }

    public SearchStrategy getSearchAlgorithm() {
        return searchAlgorithm;
    }

    public void setSearchAlgorithm(SearchStrategy searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public boolean isChaptersSortedByName() {
        for (int i = 1; i < chapters.size(); i++) {
            if (chapters.get(i - 1).getName().compareTo(chapters.get(i).getName()) > 0) {
                return false;
            }
        }
        return true;
    }

    public int search(String chapterName) {
        return searchAlgorithm.performSearch(chapters, chapterName);
    }
}
