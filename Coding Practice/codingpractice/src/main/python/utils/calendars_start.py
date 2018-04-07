#
# Example file for working with Calendars
#

# import the calendar module
import calendar  # all the calander classes

# create a plain text calendar

c= calendar.TextCalendar(calendar.MONDAY)
st = c.formatmonth(2018, 1, 0 , 0)
print(st)
# create an HTML formatted calendar
hc = calendar.HTMLCalendar(calendar.SUNDAY)
st = hc.formatmonth(2018,1)
print(st)

# loop over the days of a month
# zeroes mean that the day of the week is in an overlapping month
for i in c.itermonthdays(2018, 8):
    print(i)
  
# The Calendar module provides useful utilities for the given locale,
# such as the names of days and months in both full and abbreviated forms
for name in calendar.month_name:
    print(name)

# Calculate days based on a rule: For example, consider
# a team meeting on the first Friday of every month.
# To figure out what days that would be for each month,
# we can use this script:

print("Teem meeting will be on: ")
for m in range(1,13):
    cal = calendar.monthcalendar(2018, m)
    weekone = cal[0]
    weektwo = cal[1]
    if weekone[calendar.FRIDAY ] != 0:
        meetDay = weekone[calendar.FRIDAY]
    else: meetDay = weektwo[calendar.FRIDAY]

    print("%10s %2d" % (calendar.month_name[m], meetDay))