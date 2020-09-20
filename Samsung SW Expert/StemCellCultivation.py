# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''
from collections import defaultdict
di = [1,-1,0,0]
dj = [0,0,1,-1]
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N,M,K = map(int,input().split())
    plate = [[0]*(M+2*K) for _ in range(N+2*K)]
    active = defaultdict(list)
    for i in range(N):
        a = list(map(int,input().split()))
        for j in range(M):
            if a[j] > 0:
                plate[K+i][K+j] = a[j]
                active[a[j]].append([K+i,K+j,a[j]])
    minP = min(active.keys())
    maxP = max(active.keys())
    for _ in range(K):
        for power in range(maxP,minP-1,-1):
            cells = active[power]
            if not cells:
                continue
            new,old = [],[]
            for idx in range(len(cells)-1,-1,-1):
                cells[idx][2]-=1
                i,j,p = cells[idx]
                if p == -1:
                    for k in range(4):
                        ni,nj = i+di[k],j+dj[k]
                        if not plate[ni][nj]:
                            plate[ni][nj] = power
                            new.append([ni,nj,power])
                if p == -power:
                    old.append(idx)
            for idx in old:
                active[power].pop(idx)
            active[power] += new

    result = 0
    for i in range(minP, maxP+1):
        result+=len(active[i])
    print(f"#{test_case} {result}")
