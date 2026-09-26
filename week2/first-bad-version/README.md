First Bad Version

Problem
Given `n` versions `[1, 2, ..., n]`, some versions are bad.
Once a version is bad, all versions after it are also bad.
The task is to find the <first bad version> while minimizing the number of calls to the `isBadVersion(version)` API.

 My First Solution

In my first solution, I tried to find the first bad version by checking both the current middle version and the previous version.
The main idea was:
If <mid> is bad and <mid-1> is good, then <mid> is the first bad version.
If <mid> is bad, continue searching on the left. 
If <mid> is good, continue searching on the right.

Problems with my first approach
After analyzing my solution, I found several problems:
1. `isBadVersion(mid)` was called multiple times during one iteration.
2. The solution also checked `mid - 1`, which is unnecessary.
3. When `mid = 1`, checking `mid - 1` would mean checking version `0`, which does not exist.
4. My conditions could be simplified because the API already gives enough information to decide which half of the search space to keep.


Analysis and Optimization

The important property of the problem is that versions always have this order:
Good → Good → Good → Bad → Bad → Bad
Because the versions are ordered in this way, Binary Search can be used.

For each `mid`:
If `isBadVersion(mid)` is `true`, `mid` can be the first bad version, so I keep `mid` as a possible answer and move the right boundary to `mid - 1`.
If `isBadVersion(mid)` is `false`, `mid` cannot be the first bad version, so I search on the right by moving `left` to `mid + 1`.
When the loop finishes, `left` points to the first bad version.


Optimized Solution

The optimized solution calls `isBadVersion(mid)` only once per iteration:

Complexity

First Solution

The first solution still uses Binary Search, but it makes unnecessary API calls and checks mid - 1.
Its main issue is not the search idea itself, but the unnecessary number of calls to `isBadVersion()`.

Optimized Solution

Time Complexity: `O(log n)`
Each iteration removes approximately half of the remaining versions from consideration.

Space Complexity: `O(1)`
Only left, right, and mid variables are used.


---What I Learned---

This problem helped me understand that Binary Search can be used not only to find a specific value, but also to find a boundary between two groups.
I also learned that reducing unnecessary API calls is important when the problem specifically asks to minimize them.
Also that I should always try to kind of upgrade my code and think in creative way not in traditional way.
