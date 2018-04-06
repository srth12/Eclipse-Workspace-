#
# Example file for working with functions
#

# define a basic function
def func1():
    print("I am a function")

# function that takes arguments
def func2(arg1, arg2):
    print(arg1, " ", arg2)

# function that returns a value
def cube(x):
    return x*x*x

# function with default value for an argument

def power(num, x = 1):
    result = 1
    for i in range(x):
        result = result * num
    return result

#function with variable number of arguments

def multi_add(*args):   # only catch is variable args should be at the end
    result = 0
    for x in args:
        result += x
    return result


#################

func1()
print(func1())  # fn will print, and no return; hence the outer print will print 'None'
print(" next:")
print(func1)    #print the address of the function, since its an Object in python

func2(1,2)
print(cube(3))

print("Power example")
print(power(2))
print(power(2,3))
print(power(x = 3, num=2))  # python allows to interchange args by assigning variables when calling, so will work

z = multi_add(1,2,3,4,5)
print(z)