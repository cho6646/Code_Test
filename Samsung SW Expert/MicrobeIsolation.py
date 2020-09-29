from collections import defaultdict
import heapq

T = int(input())
dx = ["", 0, 0, -1, 1]
dy = ["", -1, 1, 0, 0]
rev = {1:2,2:1,3:4,4:3}
for test_case in range(1, T + 1):
    N, M, K = map(int, input().split())
    m = []
    for i in range(K):
        m.append(list(map(int,input().split())))
    while M > 0:
        for i in range(len(m)):
            a = m[i]
            ny = a[0]+dy[a[3]]
            nx = a[1]+dx[a[3]]
            if nx == 0 or nx == N-1 or ny == 0 or ny == N-1:
                m[i] = [ny, nx, a[2]//2, rev[a[3]]]
            else:
                m[i] = [ny, nx, a[2], a[3]]
        d = defaultdict(list)
        for ma in m:
            if ma[2] == 0:
                continue
            heapq.heappush(d[(ma[0],ma[1])], (-ma[2], ma[3]))
        m.clear()
        for k in d.keys():
            ls = d[k]
            s = sum([-a[0] for a in ls])
            m.append([k[0],k[1], s, ls[0][1]])
        M -= 1
    ans = 0
    if m:
        ans = sum([a[2] for a in m])
    print(f'#{test_case} {ans}')