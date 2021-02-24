#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'getTheGroups' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. STRING_ARRAY queryType
#  3. INTEGER_ARRAY students1
#  4. INTEGER_ARRAY students2
#
#NOT WORKING; WRONG CODE
from collections import defaultdict

student_friends_map = defaultdict(set)
def getTheGroups(n, queryType, students1, students2):
    # Write your code here
    result = []
    for i in range(len(queryType)):
        if queryType[i] == 'Total':
            stud1_len = len(student_friends_map[students1[i]])
            stud2_len = len(student_friends_map[students2[i]])
            result.append(stud1_len + stud2_len + 1)
        else:
            stud1 = students1[i]
            stud2 = students2[i]
            stud1_frds = student_friends_map[stud1]
            stud1_frds.add(stud1)
            stud1_frds.add(stud2)

            stud2_frds = student_friends_map[stud2]
            stud2_frds.add(stud1)
            stud2_frds.add(stud2)

            for friend in stud1_frds:
                stud2_frds.add(friend)
            for friend in stud2_frds:
                stud1_frds.add(friend)

    return result
