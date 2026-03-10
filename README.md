# Blind 75 — LeetCode Solutions

A personal repository of solutions to the **Blind 75** LeetCode problem set, written in **Java** and **Python**. This serves as a learning journal and a reference for others who want to study common algorithmic patterns through clean, well-explained code.

---

## About

The [Blind 75](https://leetcode.com/problem-list/oizxjoit/) is a curated list of 75 LeetCode problems that cover the most important data structures and algorithms frequently tested in technical interviews. Working through this list is one of the most efficient ways to build a strong foundation in algorithmic thinking.

This repository is:

- A **showcase of my own learning progress** through the list.
- A **reference** for others, with solutions that include inline explanations and time/space complexity analysis.

---

## Repository Structure

```
Leetcode/
├── JavaProblems/     # Solutions written in Java
└── PythonProblems/   # Solutions written in Python (coming soon)
```

Each file is self-contained and named after the problem it solves.

---

## Java Solutions

| Problem                                                                                                        | Topic               | Time Complexity |
| -------------------------------------------------------------------------------------------------------------- | ------------------- | --------------- |
| [Two Sum](JavaProblems/TwoSum.java)                                                                            | Arrays & Hashing    | O(n)            |
| [Longest Substring Without Repeating Characters](JavaProblems/LongestSubstringWithoutRepeatingCharacters.java) | Sliding Window      | O(n)            |
| [Container With Most Water](JavaProblems/ContainerWithMostWater.java)                                          | Two Pointers        | O(n)            |
| [Longest Palindromic Substring](JavaProblems/LongestPalindromicSubstring.java)                                 | Dynamic Programming | —               |
| [Palindromic Substrings](JavaProblems/PalindromicSubstrings.java)                                              | Dynamic Programming | —               |
| [Longest Consecutive Sequence](JavaProblems/LongestConsecutiveSequence.java)                                   | Arrays & Hashing    | O(n)            |
| [Missing Number](JavaProblems/MissingNumber.java)                                                              | Bit Manipulation    | —               |
| [Word Break](JavaProblems/WordBreak.java)                                                                      | Dynamic Programming | O(n·m·t)        |
| [Linked List Cycle](JavaProblems/LinkedListCycle.java)                                                         | Linked Lists        | —               |
| [Clone Graph](JavaProblems/CloneGraph.java)                                                                    | Graphs (DFS)        | O(n)            |
| [Graph Valid Tree](JavaProblems/GraphValidTree.java)                                                           | Graphs              | —               |

---

## Code Style

Each solution follows a consistent style:

- **Inline comments** explain the reasoning behind each step, not just what the code does.
- **Complexity notes** are included at the bottom of every solution.
- **`main()` test cases** demonstrate the solution on example inputs.

Example snippet from `LongestConsecutiveSequence.java`:

```java
// check if it's the start of a sequence by looking up for its supposedly previous number: O(1)
if (!numSet.contains(num - 1)) {
    int length = 0;
    while (numSet.contains(num + length)) {
        length++;
    }
    longest = Math.max(longest, length);
}

// Overall time complexity (as required): O(n)
```

---

## Topics Covered

- Arrays & Hashing
- Two Pointers
- Sliding Window
- Linked Lists
- Dynamic Programming
- Graphs (DFS / BFS)
- Bit Manipulation

More topics and problems are being added as progress continues.

---

## Languages

| Language | Status      |
| -------- | ----------- |
| Java     | In progress |
| Python   | Planned     |

---

## Credits & Inspiration

Solutions in this repository are inspired by and based on the **[NeetCode YouTube channel](https://www.youtube.com/@NeetCode)** — an excellent resource for learning algorithms and data structures with clear, structured explanations. Huge credit to NeetCode for making these concepts accessible.

---

## Disclaimer

All code in this repository is for personal study and educational sharing, with approaches inspired by NeetCode's teachings. Problem statements belong to LeetCode.
