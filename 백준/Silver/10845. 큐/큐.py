from collections import deque

queue = deque()

import sys
T = int(sys.stdin.readline())

for _ in range(T):
    data = sys.stdin.readline().split()
    #입력어가 push일 경우
    if data[0] == 'push' :
        queue.append(data[1])
       # print(stack)
    #입력어가 pop일 경우    
    elif data[0] == 'pop':
        #print(stack)
        if len(queue) == 0:
            print(-1)
        else:
            print(queue.popleft())
    #입력어가 size일 경우
    elif data[0] == 'size':
        print(len(queue))
    #입력어가 empty일 경우
    elif data[0] == 'empty':
        if len(queue) == 0:
            print(1)
        else:
            print(0)
    #입력어가 front일 경우
    elif data[0] == 'front':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
    #입력어가 back일 경우
    elif data[0] == 'back':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[-1])
