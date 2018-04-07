#
# Example file for working with timedelta objects
#

from datetime import date
from datetime import time
from datetime import datetime
from datetime import timedelta

# construct a basic timedelta and print it
print(timedelta(days=365, hours=5, minutes=1))

# print today's date
now = datetime.now()
print("today is: ", now)

# print today's date one year from now

print("date one year from now is ", now + timedelta(days=365))
# create a timedelta that uses more than one argument

print("in 2 days and 3 weeks, it will be " +
      str( now + timedelta(days=2, weeks=3)))

# calculate the date 1 week ago, formatted as a string
t = now - timedelta(weeks=1)
s = t.strftime("the day one week ago is %A %B %d %Y")
print(s)

### How many days until April Fools' Day?
afd = date(now.year, 4, 1)
today = date.today()
# use date comparison to see if April Fool's has already gone for this year
# if it has, use the replace() function to get the date for next year
if afd < today:
    print("April fool's day already went by %d days ago" % ((today - afd).days))
    afd = afd.replace(year= today.year + 1)

# Now calculate the amount of time until April Fool's Day  
time_to_afd = afd - today
print("It's just ", time_to_afd.days, " days until next april fools")

