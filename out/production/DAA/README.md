# Convert Sorted Array to Binary Search Tree

## 1. Problem

I get an array of numbers sorted in ascending order. I need to build a height-balanced BST from it. Balanced means that for every node the heights of the left and right subtrees are almost the same (the difference is not more than 1).

## 2. Approach

To make the tree balanced, the root must be in the middle of the array, so about half of the numbers go to the left and half to the right. Because the array is sorted, everything on the left of the middle is smaller and everything on the right is bigger, so the BST rule works by itself.

I use a helper method `build(nums, left, right)`:

1. If `left > right`, there are no numbers, return `null`.
2. Find `mid = (left + right) / 2`.
3. Create a node with `nums[mid]`.
4. The left child is `build(nums, left, mid - 1)`.
5. The right child is `build(nums, mid + 1, right)`.
6. Return the node.

**Tracing.** `nums = [-10, -3, 0, 5, 9]`

1. `build(0, 4)`: mid = 2, the node is **0**.
   - left: `build(0, 1)`: mid = 0, the node is **-10**.
     - left: `build(0, -1)` returns null.
     - right: `build(1, 1)`: mid = 1, the node is **-3**, both children are null.
   - right: `build(3, 4)`: mid = 3, the node is **5**.
     - left: `build(3, 2)` returns null.
     - right: `build(4, 4)`: mid = 4, the node is **9**.

The tree:

```
        0
       / \
    -10   5
      \    \
      -3    9
```

The preorder output of my program is `0 -10 -3 5 9`.

**Challenges.** My first idea was to take the first element as the root and then insert the next elements one by one like in a normal BST insert. It does not work well: because the array is sorted, each next number is bigger than the previous one and goes to the right, so I get a tree that looks like a linked list with height `n`. It is a valid BST, but it is not balanced. Also the insert for every element takes O(h), so it is slow. After that I understood that I need to choose the middle element as the root every time, and then it became a simple recursion. Another small problem was the case of even number of elements: there are two middle elements. I checked that taking any of them is fine, and the tree is still balanced. I take the left one because of integer division.

## 3. Time Complexity

**Time Complexity: O(n)**

Every element of the array becomes exactly one node, and every call of `build` creates one node (or returns null for an empty part). So the number of calls is about `2n`, and each call does only O(1) work. Because of that the total time is O(n).

**Space Complexity: O(n)** for the new tree, because we create `n` nodes. If we do not count the tree itself, the extra space is O(log n) for the recursion stack, because we split the array in half every time and the depth of the recursion is about `log n`.

## 4. Reflection / Improvement

I think this solution is already optimal in time, because we must create `n` nodes, so we cannot do better than O(n). The only small improvement is to write `mid = left + (right - left) / 2` instead of `(left + right) / 2`, which protects from integer overflow when the array is very big. The complexity stays O(n).
