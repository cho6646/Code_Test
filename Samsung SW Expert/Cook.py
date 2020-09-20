from itertools import combinations
import math

def addAll(s):
    result = 0
    for i in s:
        for j in s:
            if i == j:
                continue
            result += synergy[i][j]
    return result


T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    synergy = []
    sAll = 0
    for i in range(N):
        a = list(map(int, input().split()))
        synergy.append(a)
        sAll += sum(a)
    mn = math.inf
    foods = set([x for x in range(N)])
    for f in combinations(foods, N//2):
        set1 = set(f)
        set2 = foods - set1
        mn = min(mn, abs(addAll(set1) - addAll(set2)))
        if mn == 0:
            break
    print(f'#{test_case} {mn}')