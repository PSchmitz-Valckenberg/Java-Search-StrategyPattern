# Java – Search Strategy Pattern

This project implements the **Strategy Pattern** to dynamically switch between different chapter search algorithms (linear and binary) at runtime.

The system is structured using clean object-oriented principles and demonstrates runtime configurability of algorithm behavior.

## 📌 Use Case

An e-book system stores a list of chapters and uses either **Linear Search** or **Binary Search** to find a chapter’s page number based on whether the list is sorted.

- If sorted → use Binary Search
- If not → use Linear Search

## 🧠 Concepts Used
- Strategy Pattern
- Context & Policy abstraction
- Interface-based polymorphism
- Runtime algorithm selection

## 🗂️ Project Structure
- `SearchStrategy` — interface defining `performSearch()`
- `LinearSearch`, `BinarySearch` — strategy implementations
- `Context` — holds the search logic and delegates to strategy
- `Policy` — configures which strategy to use
- `Client` — uses the context to trigger the search



