Binary Search

1. Problem
   The task is to find a target number in a sorted array of integers. If the target exists, the function should return its index. If it does not exist, the function should return `-1`.

2. First Approach

My first solution used a simple linear search. Because it was first that came to mind and also at first I didn't notice that array is sorted. I checked the elements of the array one by one from the beginning until I found the target.
This solution was working, but it did not use the fact that the array is sorted.

Time Complexity
O(n)
In the worst case, the target can be at the last position or may not exist in whole array at all. In this situation, the algorithm checks every element in the array. If there are `n` elements, there can be up to `n` checks.
so that why it is O(n)

Space Complexity
O(1)
The algorithm uses only a small number of variables. The amount of additional memory did not increase when the array becomes larger.

3. Improved Approach

After analyzing my first solution, I noticed that the array is sorted in ascending order. Because of this, I can use the middle element to reduce the search area.

I use three variables:

* `left` — the beginning of the current search area
* `right` — the end of the current search area
* `mid` — the middle position

I compare `nums[mid]` with the target.

* If `nums[mid] == target`, I found the target and return its index.
* If `nums[mid] < target`, the target must be on the right, so I move `left` to `mid + 1`.
* If `nums[mid] > target`, the target must be on the left, so I move `right` to `mid - 1`.

This process repeats while `left <= right`.

If `left` becomes greater than `right`, there are no elements left to check, so the function returns `-1`.

Time Complexity
O(log n)
At every iteration, approximately half of the remaining elements are removed from the search area.

Space Complexity
O(1)
The algorithm uses only the variables `left`, `right`, and `mid`. It does not create another array or other data structure, so the additional memory stays constant.

4. Reflection / Improvement

My first solution was O(n) because it checked the elements one by one. After analyzing the problem, I realized that the sorted order of the array can be used to make the search more efficient.
The improved solution uses binary search and reduces the search area by about half after each comparison. This changes the time complexity from O(n) to O(log n), while the space complexity remains O(1).
The main improvement was not adding more code, but using the information given in the problem: the array is already sorted.