from itertools import combinations

def score(n):
    return n**2

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M, C = map(int, input().split())
    m = []
    for _ in range(N):
        m.append(list(map(int, input().split())))
    best = [[0]*(N - M + 1) for _ in range(N)]
    for i in range(N):
        for j in range(N - M + 1):
            a = m[i][j:j+M]
            for l in range(1, M+1):
                for s in combinations(a, l):
                    if sum(s) <= C:
                        best[i][j] = max(best[i][j], sum(map(score, s)))

    bests = [max(best[i]) for i in range(N)]
    result = sum(sorted(bests, reverse=True)[:2])
    if N >= 2 * M:
        for i in range(N):
            if 2*bests[i] <= result:
                continue
            for j in range(N - 2 * M + 1):
                k = 0
                while j + k + M < N - M + 1:
                    result = max(result, best[i][j] + best[i][j+k+M])
                    k += 1
    print(f'#{test_case} {result}')