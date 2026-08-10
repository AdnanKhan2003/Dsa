``

# Java Collections — Operations & Algorithms Complexity Cheatsheet

Every table shows **time complexity** per operation per implementation. Space is called out separately below each table (most collections are O(n) space for the structure itself; call-outs are for anything unusual).

---

## List operations

| Operation                        | ArrayList                 | LinkedList                    | Vector         |
| -------------------------------- | ------------------------- | ----------------------------- | -------------- |
| `get(i)` — access by index    | O(1)                      | O(n)                          | O(1)           |
| `add(e)` — insert at end      | O(1) amortized            | O(1)                          | O(1) amortized |
| `add(i, e)` — insert at index | O(n) — shifts needed     | O(n) to find + O(1) to link   | O(n)           |
| `addFirst(e)`                  | O(n) — shifts everything | O(1)                          | O(n)           |
| `remove(i)`                    | O(n) — shifts needed     | O(n) to find + O(1) to unlink | O(n)           |
| `removeFirst()`                | O(n) — shifts everything | O(1)                          | O(n)           |
| `contains(e)` / `indexOf(e)` | O(n)                      | O(n)                          | O(n)           |
| `set(i, e)` — update          | O(1)                      | O(n) to find, O(1) to set     | O(1)           |
| `size()`                       | O(1)                      | O(1)                          | O(1)           |

**Space:** O(n) for all three. `ArrayList`/`Vector` may over-allocate capacity (unused slots); `LinkedList` uses extra O(n) for prev/next pointers per node (higher constant factor).

---

## Set operations

| Operation                | HashSet                                | LinkedHashSet    | TreeSet            |
| ------------------------ | -------------------------------------- | ---------------- | ------------------ |
| `add(e)`               | O(1) avg, O(n) worst (hash collisions) | O(1) avg         | O(log n)           |
| `contains(e)`          | O(1) avg                               | O(1) avg         | O(log n)           |
| `remove(e)`            | O(1) avg                               | O(1) avg         | O(log n)           |
| `first()` / `last()` | — not supported                       | — not supported | O(log n)           |
| `iteration order`      | undefined                              | insertion order  | sorted (ascending) |
| Iterate all n elements   | O(n)                                   | O(n)             | O(n)               |

**Space:** O(n) for all. `LinkedHashSet` adds O(n) extra for the ordering linked list. `TreeSet` adds O(n) extra for tree node pointers (left/right/parent).

---

## Queue / Deque operations

| Operation                           | ArrayDeque     | LinkedList (as Deque) | PriorityQueue               |
| ----------------------------------- | -------------- | --------------------- | --------------------------- |
| `offer(e)` / `add(e)` (enqueue) | O(1) amortized | O(1)                  | O(log n)                    |
| `poll()` / `remove()` (dequeue) | O(1)           | O(1)                  | O(log n)                    |
| `peek()`                          | O(1)           | O(1)                  | O(1)                        |
| `addFirst(e)` / `addLast(e)`    | O(1) amortized | O(1)                  | — not applicable (no ends) |
| `contains(e)`                     | O(n)           | O(n)                  | O(n)                        |
| `size()`                          | O(1)           | O(1)                  | O(1)                        |

**Space:** O(n) for all. `PriorityQueue` is backed by a resizable array (binary heap) — same over-allocation behavior as `ArrayList`.

---

## Map operations

| Operation                      | HashMap              | LinkedHashMap    | TreeMap       | Hashtable               |
| ------------------------------ | -------------------- | ---------------- | ------------- | ----------------------- |
| `put(k, v)`                  | O(1) avg, O(n) worst | O(1) avg         | O(log n)      | O(1) avg (synchronized) |
| `get(k)`                     | O(1) avg, O(n) worst | O(1) avg         | O(log n)      | O(1) avg                |
| `remove(k)`                  | O(1) avg             | O(1) avg         | O(log n)      | O(1) avg                |
| `containsKey(k)`             | O(1) avg             | O(1) avg         | O(log n)      | O(1) avg                |
| `firstKey()` / `lastKey()` | — not supported     | — not supported | O(log n)      | — not supported        |
| iteration order                | undefined            | insertion order  | sorted by key | undefined               |
| Iterate all n entries          | O(n)                 | O(n)             | O(n)          | O(n)                    |

**Space:** O(n) for all. `LinkedHashMap` adds O(n) for the ordering linked list. `TreeMap` adds O(n) for Red-Black tree node pointers. Worst-case O(n) time on `HashMap`/`Hashtable` happens only under heavy hash collisions (rare with a good `hashCode()`).

---

## Collections utility algorithms

| Algorithm / method                          | Time           | Space    | Notes                                           |
| ------------------------------------------- | -------------- | -------- | ----------------------------------------------- |
| `Collections.sort(list)`                  | O(n log n)     | O(n)     | uses TimSort (a merge sort variant) for objects |
| `Collections.reverse(list)`               | O(n)           | O(1)     | in-place swap from both ends                    |
| `Collections.shuffle(list)`               | O(n)           | O(1)     | Fisher–Yates shuffle                           |
| `Collections.max(list)` / `min(list)`   | O(n)           | O(1)     | single linear scan                              |
| `Collections.binarySearch(list, key)`     | O(log n)       | O(1)     | **list must already be sorted**           |
| `Collections.frequency(list, o)`          | O(n)           | O(1)     | counts occurrences via linear scan              |
| `Collections.unmodifiableList/Set/Map(c)` | O(1)           | O(1)     | wraps, doesn't copy                             |
| `Arrays.sort(array)` — primitives        | O(n log n) avg | O(log n) | dual-pivot Quicksort, in-place                  |
| `Arrays.sort(array)` — objects           | O(n log n)     | O(n)     | TimSort, needs merge buffer                     |
| `Arrays.binarySearch(array, key)`         | O(log n)       | O(1)     | array must already be sorted                    |
| `Arrays.asList(array)`                    | O(1)           | O(1)     | fixed-size view, backed by the array            |

---

## Choosing the right structure — quick reference

| You need...                           | Reach for                                         |
| ------------------------------------- | ------------------------------------------------- |
| Fast index access, order matters      | `ArrayList`                                     |
| Frequent insert/delete at both ends   | `ArrayDeque` or `LinkedList`                  |
| Frequent insert/delete in the middle  | `LinkedList` (if you already have the node ref) |
| No duplicates, don't care about order | `HashSet`                                       |
| No duplicates, need insertion order   | `LinkedHashSet`                                 |
| No duplicates, need sorted order      | `TreeSet`                                       |
| Fast key → value lookup              | `HashMap`                                       |
| Key → value lookup + insertion order | `LinkedHashMap`                                 |
| Key → value lookup + sorted keys     | `TreeMap`                                       |
| Process by priority, not FIFO         | `PriorityQueue`                                 |
| Thread-safe map                       | `ConcurrentHashMap`                             |
| Thread-safe, read-heavy list          | `CopyOnWriteArrayList`                          |

---

## Rules of thumb

- **Hash-based (`HashMap`, `HashSet`)** → O(1) average for add/remove/lookup, because they jump straight to a bucket. Worst case degrades to O(n) only with many hash collisions.
- **Tree-based (`TreeMap`, `TreeSet`)** → always O(log n), because every operation walks a balanced tree — no average/worst-case split, it's consistent.
- **Array-based (`ArrayList`, `ArrayDeque`, `PriorityQueue`)** → O(1) at the end, O(n) in the middle/start, because shifting elements costs a full pass.
- **Linked-based (`LinkedList`)** → O(1) once you're *at* the node, O(n) to *get to* the node — that's why `get(i)` is slow but `addFirst`/`addLast` are fast.
