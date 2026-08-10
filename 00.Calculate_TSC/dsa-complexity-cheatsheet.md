# Time & Space Complexity Cheatsheet

## The 4-step method (for any function)

1. **Identify n** — what's the input size? (array length, string length, node count...)
2. **Walk the code** — assign a cost to every line/block (table below)
3. **Combine** — add costs of sequential blocks, multiply for nested loops
4. **Simplify** — drop constants and lower-order terms, keep the dominant term
   `O(2n + 5)` → `O(n)` &nbsp;&nbsp; `O(n² + n)` → `O(n²)`

---

## Time complexity — cost of common constructs

| Construct                                  | Cost       | Notes                     |
| ------------------------------------------ | ---------- | ------------------------- |
| Assignment, arithmetic, comparison, print  | O(1)       | constant, regardless of n |
| `if / else` (no loop inside)             | O(1)       | just a branch check       |
| Single loop, runs n times                  | O(n)       |                           |
| Nested loop, both size n                   | O(n²)     | loop inside a loop        |
| Nested loop, 3 levels deep                 | O(n³)     | rare, watch for this      |
| Loop that halves range each time           | O(log n)   | binary search pattern     |
| Loop + inner binary search                 | O(n log n) |                           |
| Recursion, 1 call, shrinks by 1            | O(n)       | e.g. factorial            |
| Recursion, 2 calls, shrinks by half        | O(n log n) | e.g. merge sort           |
| Recursion, 2 calls, shrinks by 1 (no memo) | O(2ⁿ)     | e.g. naive fibonacci      |

## Data structure operations

| Operation       | Array | ArrayList (end)      | ArrayList (mid/start) | LinkedList (w/ ref) | LinkedList (search) | HashMap  |
| --------------- | ----- | -------------------- | --------------------- | ------------------- | ------------------- | -------- |
| Access by index | O(1)  | O(1)                 | O(1)                  | O(n)                | O(n)                | —       |
| Search by value | O(n)  | O(n)                 | O(n)                  | O(n)                | O(n)                | O(1) avg |
| Insert          | O(n)* | O(1) amortized       | O(n) — shifts needed | O(1)                | O(n)                | O(1) avg |
| Delete          | O(n)* | O(1) amortized (end) | O(n) — shifts needed | O(1)                | O(n)                | O(1) avg |

*fixed-size arrays can't grow — "insert" usually means a new array

---

## Big-O growth, smallest to largest

```
O(1)  <  O(log n)  <  O(n)  <  O(n log n)  <  O(n²)  <  O(n³)  <  O(2ⁿ)  <  O(n!)
```

| Big-O      | Name                     | Simple Meaning                                         |
|------------|--------------------------|--------------------------------------------------------|
| **O(1)**   | Constant                 | Doesn't depend on `n`                                  |
| **O(log n)** | Logarithmic            | Problem gets divided repeatedly                        |
| **O(n)**   | Linear                   | Goes through `n` elements                              |
| **O(n log n)** | Linearithmic / Log-linear | `n` work × `log n` levels                         |
| **O(n²)**   | Quadratic                | `n × n`                                                |
| **O(n³)**   | Cubic                    | `n × n × n`                                            |
| **O(2ⁿ)**   | Exponential              | Work roughly doubles with each additional input        |
| **O(n!)**   | Factorial                | Work grows according to all possible permutations      |

| Class      | Feel                    | Typical example                           |
| ---------- | ----------------------- | ----------------------------------------- |
| O(1)       | instant, ignores n      | array index access                        |
| O(log n)   | halves each step        | binary search                             |
| O(n)       | one pass                | single loop, linear search                |
| O(n log n) | one pass + a log factor | efficient sorting (merge/quick/heap sort) |
| O(n²)     | double nested loop      | bubble sort, comparing all pairs          |
| O(n³)     | triple nested loop      | naive matrix multiplication               |
| O(2ⁿ)     | doubles per input bit   | naive recursive fibonacci                 |
| O(n!)      | all orderings           | brute-force permutations                  |

---

## Space complexity checklist

Ask: **what extra memory does the algorithm use, beyond the input itself?**

| Thing to check                                   | Adds                        |
| ------------------------------------------------ | --------------------------- |
| A fixed number of variables (int, boolean, etc.) | O(1)                        |
| A new array/list sized on n                      | O(n)                        |
| A new 2D array/matrix sized on n                 | O(n²)                      |
| Recursion — each call = 1 stack frame           | O(depth)                    |
| Recursion that also builds a new array per call  | O(depth) + O(n) as relevant |

---

## Quick checklist to run on any method

- [ ] What is n?
- [ ] Any loops? How many, nested or sequential, run n times or fewer?
- [ ] Any recursion? What's the depth, how many calls does each invocation spawn?
- [ ] Any data structure ops (insert/delete/search/access)? Look up cost above.
- [ ] Any new data structures created that scale with n? → space cost.
- [ ] Combine costs, drop constants, keep the dominant term.

---

## Worked examples (from your code)

```java
printSumBasic(a, b)   →  O(1) time, O(1) space   // no loop, fixed work
printSum(int... arr)  →  O(n) time, O(1) space   // one loop over n, no extra structures
```
