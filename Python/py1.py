import math
def prime(n):
    for i in range(2,int(math.sqrt(n))+1):
        if(n%i==0):
            return 0
    else:
        return 1
 
num=int(input('请输入一个三位数：'))
my_list=list(range(2,num))
for i in my_list:
    if(prime(i)==0):
        my_list[i-2]=-1
my_list=set(my_list)
my_list=list(my_list)
my_list.remove(-1)
print(sorted(my_list))
