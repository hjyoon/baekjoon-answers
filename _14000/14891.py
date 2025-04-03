import sys


def solve():
    input = sys.stdin.readline
    gear_states = [list(input().rstrip()) for _ in range(4)]

    def rotate_gear(idx, direction, visited):
        if visited[idx] == 1:
            return
        else:
            visited[idx] = 1

        if idx == 0:
            if gear_states[idx][2] != gear_states[idx + 1][6]:
                rotate_gear(idx + 1, -direction, visited)
        elif idx == 3:
            if gear_states[idx][6] != gear_states[idx - 1][2]:
                rotate_gear(idx - 1, -direction, visited)
        else:
            if gear_states[idx][2] != gear_states[idx + 1][6]:
                rotate_gear(idx + 1, -direction, visited)
            if gear_states[idx][6] != gear_states[idx - 1][2]:
                rotate_gear(idx - 1, -direction, visited)

        if direction == -1:
            tmp = gear_states[idx][0]
            gear_states[idx][0] = gear_states[idx][1]
            gear_states[idx][1] = gear_states[idx][2]
            gear_states[idx][2] = gear_states[idx][3]
            gear_states[idx][3] = gear_states[idx][4]
            gear_states[idx][4] = gear_states[idx][5]
            gear_states[idx][5] = gear_states[idx][6]
            gear_states[idx][6] = gear_states[idx][7]
            gear_states[idx][7] = tmp
        else:
            tmp = gear_states[idx][0]
            gear_states[idx][0] = gear_states[idx][7]
            gear_states[idx][7] = gear_states[idx][6]
            gear_states[idx][6] = gear_states[idx][5]
            gear_states[idx][5] = gear_states[idx][4]
            gear_states[idx][4] = gear_states[idx][3]
            gear_states[idx][3] = gear_states[idx][2]
            gear_states[idx][2] = gear_states[idx][1]
            gear_states[idx][1] = tmp

    K = int(input())
    for _ in range(K):
        visited = [0] * 4
        gear_idx, gear_direction = map(int, input().rstrip().split())
        rotate_gear(gear_idx - 1, gear_direction, visited)

    w = [1, 2, 4, 8]

    ans = 0
    for i in range(4):
        ans += (1 if gear_states[i][0] == "1" else 0) * w[i]

    print(ans)


solve()
