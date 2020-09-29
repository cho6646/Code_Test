def dfs(num):
    global ans
    if num == len(p):
        stair1, stair2 = [], []
        for i in range(len(p)):
            if check[i]:
                stair1.append(p[i][0])
            else:
                stair2.append(p[i][1])
        count = max(cal(sorted(stair1), s[0]), cal(sorted(stair2), s[1]))
        if count < ans:
            ans = count
        return
    check[num] = False
    dfs(num+1)
    check[num] = True
    dfs(num+1)

def cal(stairList, stair):
    time, cnt = 0, 0
    q = []
    while stairList or q or cnt:
        while cnt:
            if len(q) == 3:
                break
            q.append(stair[2])
            cnt -= 1
        for i in range(len(q)-1, -1, -1):
            q[i] -= 1
            if q[i] <= 0:
                q.pop(i)

        for i in range(len(stairList)-1, -1, -1):
            stairList[i] -= 1
            if stairList[i] <= 0:
                stairList.pop(i)
                cnt += 1
        time += 1
    return time+1

T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    p, s = [], []
    ans = 999999999999
    for i in range(N):
        a = list(map(int, input().split()))
        for j in range(N):
            if a[j] == 1:
                p.append([i,j])
            elif a[j] > 1:
                s.append((i,j,a[j]))
    for i in range(len(p)):
        dist1 = abs(p[i][0]-s[0][0]) + abs(p[i][1]-s[0][1])
        dist2 = abs(p[i][0]-s[1][0]) + abs(p[i][1]-s[1][1])
        p[i][0] = dist1
        p[i][1] = dist2
    check = [False] * len(p)
    dfs(0)
    print(f'#{test_case} {ans}')
