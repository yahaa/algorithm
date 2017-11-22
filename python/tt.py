# encoding=utf-8


def solve():
    n=int(raw_input())
    a=map(int,raw_input().split())
    cur,res=1,1
    for i in range(1,n):
        if a[i]>=a[i-1]:
            cur+=1
        else:
            cur=1
        res=max(res,cur)
    print res

if __name__=='__main__':
    solve()
        
    