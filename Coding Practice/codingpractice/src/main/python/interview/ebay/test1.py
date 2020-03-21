#Bitwise addition
import sys


def trim_element(input):
    input = input.lstrip('0')
    input = input.rstrip('\n')
    return input


def bitwise_addition(input1, input2):
    max_ele, min_ele = '', ''
    input1 = trim_element(input1)
    input2 = trim_element(input2)
    if len(input1) >= len(input2):
        max_ele = input1
        min_ele = input2
    else:
        max_ele = input2
        min_ele = input1

    carry = 0
    result = ''
    for i in range(len(min_ele)):
        if min_ele[i] == max_ele[i] and min_ele[i] == '0':
            if carry == 0:
                result = '0' + result
            else:
                result = '1' + result
                carry = 0
        else:
            if carry == 0:
                result = '1' + result
                carry = 0
            else:
                result = '0' + result
    return result


# for line in sys.stdin:
#     print(line, end="")
#     input = line.split(',')
result = bitwise_addition('100', '100')
print(result)