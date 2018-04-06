#
# Example file for working with conditional statements
#

def main():
  x, y = 10, 100
  
  # conditional flow uses if, elif, else
  # it doesn't have switch statement
  if x < y:
    s = " x is less than y"
  elif x == y:
    s =" x is equal to y"
  else:
    s = " x is greter than y"
  print(s)

  # conditional statements let you use "a if C else b"
  s = "x is less than y*" if ( x < y)  else " x is greater than or equal to y"
  print(s)

if __name__ == "__main__":
  main()
