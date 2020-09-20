T = int(input())


def dfs(numOfCpu, lenOfLines, cpus):
    global maxCpu
    global result
    if numOfCpu + len(cpus) < maxCpu:
        return
    if len(cpus) == 0:
        if maxCpu <= numOfCpu:
            if maxCpu < numOfCpu:
                maxCpu = numOfCpu
                result = lenOfLines
            else:
                result = min(result, lenOfLines)
        return
    i, j = cpus[0]
    for _ in range(5):
        if _ == 0:
            if any(m[i][k] != '0' for k in range(j - 1, -1, -1)):
                continue
            for k in range(j):
                m[i][k] = '1'
            dfs(numOfCpu+1, lenOfLines+j, cpus[1:])
            for k in range(j):
                m[i][k] = '0'
        elif _ == 1:
            if any(m[i][k] != '0' for k in range(j + 1, N)):
                continue
            for k in range(j + 1, N):
                m[i][k] = '1'
            dfs(numOfCpu+1, lenOfLines+N - 1 - j, cpus[1:])
            for k in range(j + 1, N):
                m[i][k] = '0'
        elif _ == 2:
            if any(m[k][j] != '0' for k in range(i - 1, -1, -1)):
                continue
            for k in range(i):
                m[k][j] = '1'
            dfs(numOfCpu+1, lenOfLines+i, cpus[1:])
            for k in range(i):
                m[k][j] = '0'
        elif _ == 3:
            if any(m[k][j] != '0' for k in range(i + 1, N)):
                continue
            for k in range(i + 1, N):
                m[k][j] = '1'
            dfs(numOfCpu+1, lenOfLines+N - 1 - i, cpus[1:])
            for k in range(i + 1, N):
                m[k][j] = '0'
        else:
            dfs(numOfCpu, lenOfLines, cpus[1:])


for test_case in range(1, T + 1):
    N = int(input())
    m = []
    c = []
    for i in range(N):
        a = input().split()
        m.append(a)

    for i in range(N):
        for j in range(N):
            if m[i][j] == '1' and i != 0 and i != N - 1 and j != 0 and j != N - 1:
                c.append((i, j))
    lenC = len(c)
    maxCpu = 0
    result = 9999999999
    dfs(0,0,c)
    print(f'#{test_case} {result}')