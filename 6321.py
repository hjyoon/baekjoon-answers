import sys
sys.stdin = open("input.txt", 'r')

N, *S = map(lambda x:x.rstrip(), sys.stdin)

m = {'A':'B', 'B':'C', 'C':'D', 'D':'E', 'E':'F', 'F':'G', 'G':'H', 'H':'I', 'I':'J', 'J':'K', 'K':'L', 'L':'M', 'M':'N', 'N':'O', 'O':'P', 'P':'Q', 'Q':'R', 'R':'S', 'S':'T', 'T':'U', 'U':'V', 'V':'W', 'W':'X', 'X':'Y', 'Y':'Z', 'Z':'A',}

for i in range(int(N)):
    t = map(lambda x:m[x], S[i])
    print(f'String #{i+1}')
    print(''.join(t))
    print()