from collections import Counter

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    m = []
    numOfHouses = 0
    houses = []
    for i in range(N):
        a = list(map(int, input().split()))
        m.append(a)
        for j in range(N):
            if a[j] == 1:
                numOfHouses += 1
                houses.append((i, j))
    result = 0
    for i in range(N):
        if result == numOfHouses:
            break
        for j in range(N):
            if result == numOfHouses:
                break
            c = Counter()
            for hi, hj in houses:
                c[abs(hi - i) + abs(hj - j)] += 1
            a = sorted(map(list, c.items()), key=lambda x: x[0])
            for k in range(1, len(a)):
                a[k][1] += a[k-1][1]
            for size, num in a:
                if num > result and num * M - (size + 1) ** 2 - size ** 2 >= 0:
                    result = num
    print(f'#{test_case} {result}')