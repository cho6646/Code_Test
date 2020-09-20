import heapq
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
d={'0':0,'1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9,'A':10,'B':11,'C':12,'D':13,'E':14,'F':15}
for test_case in range(1, T + 1):
    N,K = map(int, input().split())
    s = input()
    num = N//4
    ls = []
    for i in range(N):
        a=0
        for j in range(num):
            a*=16
            a+=d[s[(i+j)%N]]
        if a in ls:
            continue
        if len(ls)>=K:
            if a>ls[0]:
                heapq.heappop(ls)
                heapq.heappush(ls,a)
        else:
            heapq.heappush(ls,a)
    print(f"#{test_case} {ls[0]}")

