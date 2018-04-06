#
# Example file for working with loops
#

def main():
  x = 0

  # define a while loop
  while ( x < 5):
    print(x)
    x+=1

  # define a for loop
  for x in range(5, 10):
    print(x)

  # use a for loop over a collection
  x = ["Mon","Wed","Fri"]
  for i in x:
      print(i)


 
  # use the break and continue statements
  for i in range(10, 15):
    if i < 12:
      continue
    elif i > 13: break
    else: print(i)

  #using the enumerate() function to get index
  x = ["Mon","Wed","Fri"]
  for j,i in  enumerate(x):
    print(j, i)

if __name__ == "__main__":
  main()
