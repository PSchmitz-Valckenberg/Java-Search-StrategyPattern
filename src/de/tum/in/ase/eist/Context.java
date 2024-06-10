package de.tum.in.ase.eist;

import java.util.List;

public class Context {
    private SearchStrategy searchAlgorithm;

    private List<Chapter> book;

    public Context(SearchStrategy searchAlgorithm, List<Chapter> book) {
        this.searchAlgorithm = searchAlgorithm;
        this.book = book;
    }

    public SearchStrategy getSearchAlgorithm() {
        return searchAlgorithm;
    }

    public void setSearchAlgorithm(SearchStrategy searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public List<Chapter> getBook() {
        return book;
    }

    public void setBook(List<Chapter> chapters) {
        this.book = chapters;
    }

    public boolean isChaptersSortedByName() {
        for (int i = 1; i < book.size(); i++) {
            if (book.get(i - 1).getName().compareTo(book.get(i).getName()) > 0) {
                return false;
            }
        }
        return true;
    }

    public int search(String chapterName) {
        return searchAlgorithm.performSearch(book, chapterName);
    }
}
