#
# Example file for working with date information
#

from datetime import date  # from the datetime module, import date class
from datetime import time
from datetime import datetime

def main():
  ## DATE OBJECTS
  # Get today's date from the simple today() method from the date class
  today = date.today()
  print(today)

  # print out the date's individual components
  print("Day, Month and Year are :", today.day,", ", today.month," and ", today.year)
  
  # retrieve today's weekday (0=Monday, 6=Sunday)
  print("Today's weekday is ", today.weekday())
  day = ["mon", "tue", "wed", "thu","fri","sat", "sun"]
  print(day[today.weekday()])


  ## DATETIME OBJECTS
  # Get today's date from the datetime class
  today = datetime.now()
  print("current date and time is ", today)

  # Get the current time

  print("Current tiem is ", today.time())
  
if __name__ == "__main__":
  main();
  