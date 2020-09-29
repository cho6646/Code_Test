from collections import deque

dj = [0, 0, -1, 1]
di = [-1, 1, 0, 0]


def solution():
    N, M = map(int, input().split())
    m = []
    for i in range(N):
        s = list(input())
        for j in range(M):
            if s[j] == 'B':
                b = (i,j)
                s[j] = '.'
            elif s[j] == 'R':
                r = (i,j)
                s[j] = '.'
        m.append(s)
    q = deque()
    q.append((b[0], b[1], r[0], r[1], 0, -1))
    visited = set()
    visited.add((b[0],b[1],r[0],r[1]))
    while q:
        bi, bj, ri, rj, num, dir = q.popleft()
        if num >= 10:
            return -1
        for k in range(4): # up, down, left, right
            nbi, nbj, nri, nrj = bi, bj, ri, rj
            while m[nbi+di[k]][nbj+dj[k]] != '#':
                nbi += di[k]
                nbj += dj[k]
                if m[nbi][nbj] == 'O':
                    break
            while m[nri+di[k]][nrj+dj[k]] != '#':
                nri += di[k]
                nrj += dj[k]
                if m[nri][nrj] == 'O':
                    break
            if m[nri][nrj] == 'O':
                if m[nbi][nbj] == 'O':
                    continue
                return num + 1
            if m[nbi][nbj] == 'O':
                continue
            if (nri, nrj) == (nbi, nbj):
                if k == 0:
                    if bi < ri:
                        nri += 1
                    else:
                        nbi += 1
                elif k == 1:
                    if bi < ri:
                        nbi -= 1
                    else:
                        nri -= 1
                elif k == 2:
                    if bj < rj:
                        nrj += 1
                    else:
                        nbj += 1
                else:
                    if bj < rj:
                        nbj -= 1
                    else:
                        nrj -= 1

            if (nbi, nbj, nri, nrj) not in visited:
                if dir != k:
                    q.append((nbi, nbj, nri, nrj, num+1, k))
                else:
                    q.append((nbi, nbj, nri, nrj, num, k))
                visited.add((nbi, nbj, nri, nrj))
    return -1


if __name__ == '__main__':
    print(solution())
