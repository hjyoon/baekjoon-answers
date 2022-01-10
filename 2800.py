import sys
input = sys.stdin.readline

S = input().rstrip()

st = []
pair = []
for i in range(len(S)):
    if S[i] == '(':
        st.append(i)
    elif S[i] == ')':
        pair.append((st.pop(), i))
    else:
        ...
        
ans = set()
def make_ans(S, case):
    tmp = list(S)
    for start, end in case:
        tmp[start] = ''
        tmp[end] = ''
    return ''.join(tmp)
        
for i in range(1, 2**len(pair)):
    case = []
    for j in range(len(pair)):
        tmp = 1
        if i & (tmp << j):
            case.append(pair[j])
    ans.add(make_ans(S, case))

print(*sorted(ans), sep='\n')