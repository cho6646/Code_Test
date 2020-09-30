def solution():
    def threeByTwo(i, j):
        return min([m[i][j] + m[i + 1][j],
            m[i][j + 1] + m[i + 1][j + 1],
            m[i + 1][j] + m[i + 2][j],
            m[i + 1][j + 1] + m[i + 2][j + 1],
            m[i][j + 1] + m[i][j],
            m[i + 2][j] + m[i + 2][j + 1],
            m[i][j] + m[i + 2][j],
            m[i][j + 1] + m[i + 2][j + 1],
            m[i][j] + m[i+2][j+1],
            m[i][j+1] + m[i+2][j]])

    def twoByThree(i, j):
        return min([m[i][j] + m[i + 1][j],
            m[i][j + 2] + m[i + 1][j + 2],
            m[i][j] + m[i][j + 1],
            m[i][j + 1] + m[i][j + 2],
            m[i + 1][j] + m[i + 1][j + 1],
            m[i + 1][j + 1] + m[i + 1][j + 2],
            m[i][j] + m[i][j + 2],
            m[i + 1][j] + m[i + 1][j + 2],
            m[i][j] + m[i+1][j+2],
            m[i+1][j] + m[i][j+2]])

    N, M = map(int, input().split())
    m = []
    for i in range(N):
        m.append(list(map(int, input().split())))
    mx = 0
    for i in range(N-2):
        for j in range(M-1):
            mx = max(mx, sum([m[i+i1][j+j1] for i1 in range(3) for j1 in range(2)])-threeByTwo(i, j))
    for i in range(N-1):
        for j in range(M-2):
            mx = max(mx, sum([m[i+i1][j+j1] for i1 in range(2) for j1 in range(3)])-twoByThree(i, j))
    for i in range(N):
        for j in range(M-3):
            mx = max(mx, sum([m[i][j+j1] for j1 in range(4)]))
    for i in range(N-3):
        for j in range(M):
            mx = max(mx, sum([m[i+i1][j] for i1 in range(4)]))
    print(mx)


if __name__ == '__main__':
    solution()