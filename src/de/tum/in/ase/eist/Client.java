package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class Client {
	private static final int BOOK_MIN_SIZE = 5;
	private static final int BOOK_MAX_SIZE = 15;
	private static final int NUMBER_OF_SIMULATIONS = 10;
	private static final int PAGE_NUMBER_START_VALUE = 5;

	private Client() {
	}

	public static void main(String[] args) {
		for (int i = 0; i < NUMBER_OF_SIMULATIONS; i++) {
			List<Chapter> book = createRandomBook();
			Context context = new Context(new LinearSearch(), book);
			Policy policy = new Policy(context);
			policy.configure();

			String chapterToSearch = createChapters(1).get(0);
			int pageNumber = context.search(chapterToSearch);
			System.out.println("Corresponding page for " + chapterToSearch + ": " + pageNumber);
		}
	}

	private static List<Chapter> createRandomBook() {
		int listLength = randomIntegerWithin(BOOK_MIN_SIZE, BOOK_MAX_SIZE);

		List<Chapter> book = createChapters(listLength).stream()
				.map(chapter -> new Chapter(chapter, createRandomPageNumber())).collect(Collectors.toList());

		boolean sorted = randomIntegerWithin(0, 1) == 0;
		if (sorted) {
			book.sort(Comparator.comparing(Chapter::getName));
		}
		return book;
	}

	private static int randomIntegerWithin(int low, int high) {
		return ThreadLocalRandom.current().nextInt(low, high + 1);
	}

	private static int createRandomPageNumber() {
		return ThreadLocalRandom.current().nextInt(PAGE_NUMBER_START_VALUE, Integer.MAX_VALUE);
	}

	private static List<String> createChapters(int numberOfChapters) {
		List<String> entryChapters = new ArrayList<>();
		List<String> chapters = new ArrayList<>(List.of("Modelling with UML", "System Design: Decomposing the system",
				"Object Design: Reusing Pattern Solutions", "Introduction to Software Engineering",
				"Project Organization and Communication", "Requirements Elicitation", "Analysis",
				"System Design: Addressing Design Goals", "Object Design: Specifying Interfaces",
				"Mapping Models to Code", "Testing", "Rationale Management", "Configuration Management",
				"How to pass an EIST exam", "Introduction to High Performance Computing"));

		for (int i = 0; i < numberOfChapters; i++) {
			entryChapters.add(chapters.remove(randomIntegerWithin(0, chapters.size() - 1)));
		}
		return entryChapters;
	}
}

