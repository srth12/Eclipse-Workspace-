class Employee:
    def __init__(self, emp_id, emp_name="sarath"):
        self._emp_id = emp_id
        self._emp_name = emp_name


def solution(a):
    emp_list = [Employee(emp_id) for emp_id in a]
    final = sorted(emp_list, key=lambda emp: emp._emp_id)
    return final

def sort_fn(emp):
    return ( -1 * emp._emp_id)

def solution2(a):
    emp_list = [Employee(emp_id) for emp_id in a]
    final = sorted(emp_list, key=sort_fn)
    return final

def sort_fn3(emp):
    # To reverse sort the string ord is required, else just pass string
    return (  emp._emp_id, tuple(-ord(c) for c in emp._emp_name))

def solution3(a):
    e = Employee(1, "sar")
    b = Employee(1, "dri")
    emp_list = [b, e]
    final = sorted(emp_list, key=sort_fn3)
    return final



def solution4(a):
    e = Employee(1, "sar")
    b = Employee(1, "dri")
    emp_list = [b, e]


if __name__ == "__main__":
    # k = solution([3,2,1,-1])
    # k = solution2([3,2,1,-1])
    k = solution3([3,2,1,-1])
    [print(emp._emp_id, emp._emp_name) for emp in k]
    print(-1 * "hello")