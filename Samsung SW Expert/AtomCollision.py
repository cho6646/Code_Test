from collections import defaultdict

dx = [0.0, 0.0, -0.5, 0.5]
dy = [0.5, -0.5, 0.0, 0.0]
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    atoms = []
    answer = 0
    for i in range(N):
        x, y, d, p = map(int,input().split())
        atoms.append([float(x), float(y), d, p])
    for _ in range(4001):
        if not atoms:
            break
        coord = defaultdict(list)
        collided = []
        for i, atom in enumerate(atoms):
            atom[0] += dx[atom[2]]
            atom[1] += dy[atom[2]]
            coord[(atom[0],atom[1])].append((i, atom[3]))
        for v in coord.values():
            if len(v) >= 2:
                collided += v
        collided.sort(key=lambda x : -x[0])
        for c in collided:
            atoms.pop(c[0])
            answer += c[1]
    print(f'#{test_case} {answer}')