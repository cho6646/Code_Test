from itertools import combinations


def solution():
    N = int(input())
    S = []
    for i in range(N):
        S.append(list(map(int, input().split())))
    s = set(range(N))
    mn = 9999999999
    for c in combinations(range(N), N//2):
        s1 = set(c)
        s2 = s - set(c)
        s1v, s2v = 0, 0
        for i, j in combinations(s1, 2):
            s1v += S[i][j]
            s1v += S[j][i]
        for i, j in combinations(s2, 2):
            s2v += S[i][j]
            s2v += S[j][i]
        mn = min(mn, abs(s1v - s2v))
    print(mn)


if __name__ == '__main__':
    solution()