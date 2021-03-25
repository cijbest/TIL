import sys
input = sys.stdin.readline

def solve(n):
    p = [0] * 100
    p[0] = p[1] = p[2] = 1
    p[3] = p[4] = 2
    for i in range(5, n):
        p[i] = p[i-1] + p[i-5]
    return p[n-1]


testcase = int(input())

for _ in range(testcase):
    n = int(input())
    print(solve(n))
