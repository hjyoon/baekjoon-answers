import sys
import re
import collections
import itertools
import math
DEBUG = 1

TC = [
    {'data': [1, [[6, 4, 'ATGGAT', 'AGGT']]], 'AC': '3'},
    {'data': [1, [[6, 4, 'ATGGAT', 'AGCT']]], 'AC': '0'},
    {'data': [2, [[6, 4, 'ATGGAT', 'AGCT'], [8, 2, 'GTACCTAC', 'CT']]], 'AC': '0\n1'},
    {'data': [2, [[8, 2, 'GTACCTAC', 'CT'], [6, 4, 'ATGGAT', 'AGCT']]], 'AC': '1\n0'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    #N, S = map(lambda x:x.rstrip(), in_f)
    T = int(input().rstrip())
    C = []
    for _ in range(T):
        N, M = map(int, input().rstrip().split())
        S = input().rstrip()
        P = input().rstrip()
        C.append([N, M, S, P])

    data = [T, C]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

class Node(dict):
        def __init__(self):
            super().__init__()
            self.final = False;
            self.out = set();
            self.fail = None;
            
        def addout(self,out):
            if type(out) is set:
                #self.out = self.out.union(out)
                pass
            else :
                self.out.add(out)
        
        def addchild(self,alphabet,node = None):
            self[alphabet] = Node() if node is None else node

class Aho_Corasick():
    def __init__(self,patterns):
        self.patterns = patterns
        self.head = Node()
        self.maketrie()
        self.constructfail()
        
    def search(self,sentence):
        crr = self.head
        ret = []
        for c in sentence :
            while crr is not self.head and c not in crr:
                crr = crr.fail
            if c in crr:
                crr = crr[c]
            
            if crr.final:
                ret.extend(list(crr.out))
        return ret
    
    def maketrie(self):
        for pattern in self.patterns:
            crr = self.head
            for c in pattern :
                if c not in crr:
                    crr.addchild(c)
                crr = crr[c]
            crr.final = True
            crr.addout(pattern)
            
    def constructfail(self):
        queue = collections.deque()
        self.head.fail = self.head
        queue.append(self.head)
        while queue:
            crr = queue.popleft()
            for nextc in crr:
                child = crr[nextc]
                if crr is self.head:
                    child.fail = self.head
                else :
                    f = crr.fail
                    while f is not self.head and nextc not in f:
                        f = f.fail
                    if nextc in f:
                        f = f[nextc]
                    child.fail = f

                child.addout(child.fail.out)
                child.final |= child.fail.final
                queue.append(child)

def solution(T, V):
    ans = []
    
    for N, M, S, P in V:
        S = 'YMFYESRYEQ' * 100000
        #P = 'ABCDEFGHIJKLMNOPQRSTUVWXY' * 4
        #P = 'AAAAAAAAAAAAAAAAAAAAAAAAA' * 4
        P = 'XCPHUBSDJSLGTUQXDPHISNTHCJQMATQOEILQYRWDAFWBZTDRMCOZLEHYSPFJVWBJZSKVNRAAQYCBDRDLOHJRKFGGOLBZUTDFZAQZ'

        p = set()
        p.add(P)
        for i in range(0, len(P)-1):
            for j in range(i+1, len(P)):
                p.add(P[:i] + P[i:j+1][::-1] + P[j+1:])

        ac = Aho_Corasick(p)
        ans.append(len(ac.search(S)))

    return ans_to_str(ans)


def ans_to_str(ans):
    if type(ans) == list:
        return '\n'.join(map(str, ans))
    elif type(ans) != str:
        return str(ans)
    else:
        return ans

def main():
    if DEBUG:
        #print_data()
        #print(TC)
        pass
    else:
        TC.clear()
        read_data(TC, sys.stdin)
        #read_data(TC, open('input.txt', 'r'))

    for i, v in enumerate(TC, 1):
        res = solution(*v['data'])
        if DEBUG:
            if res == v['AC']:
                print(f'case #{i}: OK')
            else:
                print(f'case #{i}: ERR')
                print('accepted:')
                print(v['AC'])
                print('wrong answer:')
                print(res)
        else:
            print(res)

def print_data():
    with open("input.txt", 'r') as in_f, open("output.txt", 'r') as out_f:
        tmp = []
        read_data(tmp, in_f, out_f)
        print(tmp)

if __name__ == "__main__":
    main()