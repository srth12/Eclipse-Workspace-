

def reverse_string(input_str):
    len_str = len(input_str)
    is_even = len_str % 2 == 0
    result = ""
    if not is_even:
        result = input_str[len_str//2]
        j = len_str//2 + 1
    else:
        j = len_str//2

    for idx in range(len_str//2 - 1, -1, -1):
        result = input_str[j] + result + input_str[idx]
        j += 1

    return result



if __name__ =="__main__":
    k = reverse_string("the cloud")
    print(k)