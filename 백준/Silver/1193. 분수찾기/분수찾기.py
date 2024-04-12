def fraction(X):
    line = 1
    while X > line:
        X -= line
        line += 1
    if line % 2 == 0:
        a = X
        b = line - X +1
    if line % 2 != 0:
        a = line - X +1
        b = X
    return '{0}/{1}'.format(a,b)
        
        
        
        
X = int(input())
print(fraction(X))