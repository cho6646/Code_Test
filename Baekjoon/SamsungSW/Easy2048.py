def dfs(num, m):
    global highest
    if num == 5:
        mx = max([max(m[i]) for i in range(len(m))])
        if mx > highest:
            highest = mx
        return
    for k in range(4):
        nm = []
        if k <= 1:
            for i in range(N):
                a = [m[i][j] for j in range(N) if m[i][j] != 0]
                if k == 0:
                    if a:
                        j, b = 0, []
                        while j < len(a):
                            if j < len(a)-1 and a[j] == a[j + 1]:
                                b.append(2 * a[j])
                                j += 2
                            else:
                                b.append(a[j])
                                j += 1
                        a = b
                    nm.append(a+[0]*(N-len(a)))
                else:
                    if a:
                        j, b = len(a)-1, []
                        while j >= 0:
                            if j > 0 and a[j] == a[j - 1]:
                                b = [2 * a[j]] + b
                                j -= 2
                            else:
                                b = [a[j]] + b
                                j -= 1
                        a = b
                    nm.append([0]*(N-len(a))+a)
        else:
            for i in range(N):
                a = [m[j][N-1-i] for j in range(N) if m[j][N-1-i] != 0]
                if k == 2:
                    if a:
                        j, b = 0, []
                        while j < len(a):
                            if j < len(a)-1 and a[j] == a[j + 1]:
                                b.append(2 * a[j])
                                j += 2
                            else:
                                b.append(a[j])
                                j += 1
                        a = b
                    nm.append(a + [0] * (N - len(a)))
                else:
                    if a:
                        j, b = len(a)-1, []
                        while j >= 0:
                            if j > 0 and a[j] == a[j - 1]:
                                b = [2 * a[j]] + b
                                j -= 2
                            else:
                                b = [a[j]] + b
                                j -= 1
                        a = b
                    nm.append([0]*(N-len(a))+a)
        dfs(num + 1, nm)


if __name__ == '__main__':
    N = int(input())
    m = []
    for i in range(N):
        m.append(list(map(int, input().split())))
    highest = 0
    dfs(0, m)
    print(highest)
