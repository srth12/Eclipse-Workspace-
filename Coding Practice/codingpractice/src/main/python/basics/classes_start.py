#
# Example file for working with classes
#

class MyClass:
  def method1(self):
      print("This is method 1")

  def method2(self, arg):
      print("This is method 2 " + arg)


class AnotherClass(MyClass):
    def method1(self):
        MyClass.method1(self)
        print("This is Another class method 1")

    def method2(self, arg):
        print("This is another class method 2 " + arg)
def main():
    #c = MyClass()
    #c.method1();
    #c.method2(" and argument is me")
    d = AnotherClass()
    d.method1()
    d.method2(" and arg me")

  
if __name__ == "__main__":
  main()
