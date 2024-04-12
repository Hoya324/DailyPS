def solve(K):
    replace_format ='č/c=,ć/c-,dž/dz=,đ/d-,lj/lj,nj/nj,š/s=,ž/z='
    replace_table= list(map(lambda s:s.split('/'), replace_format.split(',')))
    after = []
    before = []
    for t in replace_table:
        after.append(t[0])
        before.append(t[1])
    for i in before:
        K = K.replace(i, '*')
    return len(K)

K = input()
print(solve(K))