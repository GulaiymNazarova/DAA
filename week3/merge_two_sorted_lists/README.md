Merge Two Sorted Lists
Problem
We have two linked lists and both are already sorted. We need to merge them into one sorted linked list. The result should also be sorted from small to big.

Approach
I did not use the two pointers method. I just took all numbers from the first list and put them into an ArrayList. Then I did the same with the second list. After that I sorted the ArrayList using Collections.sort. Then I created a new linked list from the sorted numbers.

Example:

list1 = 1 -> 2 -> 4
list2 = 1 -> 3 -> 4

First I get values from list1: [1, 2, 4]

Then I get values from list2: [1, 3, 4]

Then I combine them: [1, 2, 4, 1, 3, 4]

Then I sort them: [1, 1, 2, 3, 4, 4]

Then I make a new linked list:

1 -> 1 -> 2 -> 3 -> 4 -> 4

So the returned list is the head of this new list.

This is not the most efficient way, but it is easy to understand and it works.

Time Complexity
Time Complexity: O((n + m) log(n + m))

n is size of list1, m is size of list2.

Why: I visit all nodes of list1 and list2 once, so that is O(n + m). Then I sort n + m values. Java sort is O((n + m) log(n + m)). Then I build a new list with n + m nodes, so that is O(n + m). The biggest part is the sort, so total is O((n + m) log(n + m)).

Space Complexity: O(n + m)

Why: I store all values in ArrayList and also create a new linked list with n + m nodes.

Reflection / Improvement
Yes, there is a better solution. Since both lists are already sorted, I can use two pointers. I compare the first node of list1 and list2, take the smaller one, and move that pointer forward. This is like merge step in merge sort. That solution would be O(n + m) time and O(1) extra space if I reuse the nodes. I did not use it because my version was easier for me to write.