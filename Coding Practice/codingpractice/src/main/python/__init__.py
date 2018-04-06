def main():
    print("Hello Sarath")

if __name__ == "__main__":
    main()

f = 3
print(f)

f = "abc"
print(f)

#print("This is a string " + 123)   variable should be of same type

print("This is a string "+ str(123))



# Global vs. local variables in functions

def someFn():
    global f
    f = "def"
    print(f)

someFn()
print(f)

del f
#print(f) - will throw error since its already deleted at using del