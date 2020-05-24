import  re
import  sys
import datetime
def test():
    print(type(datetime.date(2012,2,1) - datetime.date(2012,2,1)))
    print(sys.path)
    m = re.search(r'(ab[cd]?)', """acdeabdabcde""")
    return m.group()
if __name__ == "__main__":
    print(test())
    print(type(test))