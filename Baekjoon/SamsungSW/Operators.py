import math

def dfs(idx, num):
    global mx, mn
    if idx == len(A):
        mx = max(mx, num)
        mn = min(mn, num)
        return
    for i in range(4):
        if ops[i] > 0:
            ops[i] -= 1
            if i == 0:
                dfs(idx + 1, num + A[idx])
            elif i == 1:
                dfs(idx + 1, num - A[idx])
            elif i == 2:
                dfs(idx + 1, num * A[idx])
            else:
                dfs(idx + 1, int(num / A[idx]))
            ops[i] += 1


if __name__ == '__main__':
    N = int(input())
    A = list(map(int, input().split()))
    ops = list(map(int, input().split()))
    mx, mn = -math.inf, math.inf
    dfs(1, A[0])
    print(mx)
    print(mn)