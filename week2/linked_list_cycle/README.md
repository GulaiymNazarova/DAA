Linked List Cycle
Problem
We need to check if a linked list has a cycle. A cycle means some node points back to a node that we already visited. If there is no cycle, then at the end we will get null.

Approach
I use a HashSet. I start from head and go through the list. For every node I check if it is already in the set. If it is, then we saw this node before, so there is a cycle and I return true. If it is not in the set, I add it and move to the next node. If current becomes null, then there is no cycle and I return false.
At the start I check if head is null, then I just return false. I also have a variable called answer which is false at the beginning, and I change it to true if I find a cycle.

Example with cycle:

3 -> 2-> 0 ->-4
and -4 points back to 2.

Start with empty set.

current = 3, not in set, add 3
current = 2, not in set, add 2
current = 0, not in set, add 0
current = -4, not in set, add -4
current = 2 again

2 is already in set, so return true.

Example without cycle:

1 ->2 -> null

current = 1, add 1
current = 2, add 2
current = null

Return false.

Time Complexity: O(n)

Why: In the worst case I visit every node one time. Checking and adding in a HashSet is O(1) on average.

Space Complexity: O(n)

Why: The HashSet can store all nodes if there is no cycle, or many nodes before the cycle starts.

Reflection / Improvement
Yes, there is a better way. It is called Floyd's cycle detection or tortoise and hare. We use two pointers. Slow moves one step, fast moves two steps. If there is a cycle, they will meet. If fast reaches null, then there is no cycle. This gives O(n) time and O(1) space. I did not use it because the HashSet solution is simpler for me.


