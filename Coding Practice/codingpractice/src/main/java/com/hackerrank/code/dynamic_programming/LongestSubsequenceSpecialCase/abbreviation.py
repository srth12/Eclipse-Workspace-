# You can perform the following operations on the string, :
#
# Capitalize zero or more of 's lowercase letters.
# Delete all of the remaining lowercase letters in .
# Given two strings,  and , determine if it's possible to make  equal to  as described. If so, print YES on a new line. Otherwise, print NO.
#NB: can optimise as it takes O(2^n) on worst case

def abbreviation(a, b):
    len_a = len(a)
    len_b = len(b)
    if len_a < len_b:
        return "NO"
    current_idx = len_b - 1

    if util(a, b):
        return "YES"
    return "NO"

def util(a, b):
    if(len(a) == 0):
        if len(b) > 0:
            return False
        else:
            return True

    if(len(b) == 0):
        return a.islower()

    if (a[-1].upper() == b[-1]):
        if a[-1].isupper():
            return util(a[:-1], b[:-1])

        case_include = util(a[:-1], b[:-1])
        case_exclude = util(a[:-1], b)
        return case_exclude or case_include

    else:
        if(a[-1].isupper()):
            return False
        return util(a[:-1], b)

if __name__ == "__main__":
    k = abbreviation('beFgh', 'EFG')
    # k = abbreviation('bbBbbbbbrbBbbBbbbbbbbbbrbbbbbBbbbbbbbbbbbbbbobbbbbbbsbbbbbtbBbsbbtbbbbbbbobbbbbbbbbbsbbbbbbbbbbbbbbsbbbbbbbbbbrbrbbBbbbbbbTBbbbbbbbbbbbtbbbbbbbbbbbbbbbbBbbbobbbbbbbbbbbbbtbbbbbbbBbbbbbbbbbBbbsbbbbbbbbobbbbbbbsbbbbbbbbbbbbbbbbbbbbbbtbbbbbbbbrbbbbBbbbbbbbbsbbbbbbobBborbbbbbbbbbbrbbbbbbbbbbbbbbbbbbbbbbbbbtbbbbtbbbbbbbbtbbbbbbbbbbbbbbbbbbbbbbbBbobbbbbBbbbbbbbbbbbbbbbBobbbbbbbbbBbbbrbbbbbbbbbbtbboBbbbbbbbbbbbbSbbbtbbbbbbbbbbbbbbbbbbbbbbtbbbrbbbbbBbbbbbbbbbobbbbbbbbbbbbbbsbbbbbbtbrbbrbbbbbbobbbbbbbbbbbbbbbbbbbbbbbbbbrbbbbbbbbbbbbBbbbbbBbbbbbbbbbbBbbbbbbbbbbbObbtrbsbbbbbbbbbbbbbbbbbbbbrbbbbbbbobbbbbbbbbbbbbbbbbBbbbbbbbbbbbbbbbbbbbbbbrbbbbbbbbbbbbbbbBbbBbbbbbrbbbbbbbbbbbbbbbbbbbbrbbbsbbbbbrbbbbbbbbbbbrobbbbsbbbbbsbbbBbbbbbbbbbbtTbbbbbbbbbbbbtbbtrbobbbbbbbbbbbbbBbbbbbbsbbbbbbbbbbbbbbbbbbBbbbbbbbbbbobbbbbbbbbbbbbbbbbbbbobbbTbsBbbbbbbbbbbbbsbbbbbssbbbbbbbbbSbbbbbbbbbbbbbbsbbbbbbbbbbbbbBbbbbbbbbbbbbbsbbbbBbbtbbSbbbbbbbbbbbbbsbobbbBbbbrbBbbbbbbbbbbbBbbobbbbbbbbbbbbbbbbbbbbtbosbbbbbbbbtbbbbbbbbbbrbb',
    #                  'BBBBBBBBBBBBBBBBBBBBBRBBBBBBBBBBBBOBBBBBSBBBBTBBBSBBTBBBBBBBBBBBBBSBBBBBBBBBBBBBSBBBBBBBRBBBBBBBBBTBBBBBBBBBTBBBBBBBBBBBBBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBSBBBBBBOBBBBSBBBBBBBBBBBBBBBBBBBBBBBBBBBRBBBBBBBBBBBBBBOBBBORBBBBBBBBBRBBBBBBBBBBBBBBBBBBBBBTBBBBBBBBTBBBBBBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBTBOBBBBBBBBBBSBBTBBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBSBBBBTBBBRBBBBBOBBBBBBBBBBBBBBBBBBBBBBBRBBBBBBBBBBBBBBBBBBBBBBBBBBBBOBTRBSBBBBBBBBBBBBBBBRBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBRBBBBBBBBBBBBBBBBBBRBBBBBBRBBBBBBBBBBROBBBBBBBBSBBBBBBBBBBBBBTTBBBBBBBBBBBTBBTROBBBBBBBBBBBBBSBBBBBBBBBBBBBBBBBBBBBBBOBBBBBBBBBBBBOBBBTBSBBBBBBBBBBSBBBSBBBBBBSBBBBBBBBBBBSBBBBBBBBBBBBBBBBBBBBBBBBSBBBBBBTBBSBBBBBBBBBBSBOBBBBBBRBBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBTBSBBBBBBTBBBBBBBBRB')
    print(k)
