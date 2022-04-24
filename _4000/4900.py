import sys
input = sys.stdin.readline

# 0 -> 0111111 -> 063
# 1 -> 0001010 -> 010
# 2 -> 1011101 -> 093
# 3 -> 1001111 -> 079
# 4 -> 1101010 -> 106
# 5 -> 1100111 -> 103
# 6 -> 1110111 -> 119
# 7 -> 0001011 -> 011
# 8 -> 1111111 -> 127
# 9 -> 1101011 -> 107

trans = {
    '063':'0',
    '010':'1',
    '093':'2',
    '079':'3',
    '106':'4',
    '103':'5',
    '119':'6',
    '011':'7',
    '127':'8',
    '107':'9',
    '0':'063',
    '1':'010',
    '2':'093',
    '3':'079',
    '4':'106',
    '5':'103',
    '6':'119',
    '7':'011',
    '8':'127',
    '9':'107',
}

while True:
    S = input().rstrip()
    if S == 'BYE':
        break
    
    a, b = S.split('+')
    b = b[:-1]
    
    a_list = [a[i:i+3] for i in range(0, len(a), 3)]
    b_list = [b[i:i+3] for i in range(0, len(b), 3)]
    
    tmp_a = ''.join(map(lambda x:trans[x], a_list))
    tmp_b = ''.join(map(lambda x:trans[x], b_list))
    
    res = ''.join(map(lambda x:trans[x], f'{int(tmp_a) + int(tmp_b)}'))
    
    print(S + res)