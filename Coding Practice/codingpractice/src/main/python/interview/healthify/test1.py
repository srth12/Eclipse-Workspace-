
# from datetime import
from datetime import timedelta
def get_next_n_slots(week_config, current_time, n=10):
    next_n_slots = []
    nextNInput = 0
    format = "%Y-%m-%d %H:%M:%S"

    isFirstTime = True
    i = 0

    if (isTheWeekListEmpty(week_config)):
        return next_n_slots

    while nextNInput < 10:
        for days in week_config:
            if (nextNInput + i) >= 10:
                break;
            for slot in days:
                nextNInput += 1
                startArray = slot["start_time"].split(':')
                endArray = slot["end_time"].split(':')
                if isFirstTime:
                    if  current_time.hour >= int(startArray[0]) and current_time.minute >= int(startArray[1]):
                        current_time = current_time + timedelta(days=1)
                    current_time = current_time + timedelta(hours=(current_time.hour * -1) )
                    current_time = current_time + timedelta(minutes=(current_time.minute * -1))
                    isFirstTime = False

                result = {}
                start = current_time + timedelta(hours=int(startArray[0])) + timedelta(minutes=int(startArray[1]))
                end = current_time + timedelta(hours=int(endArray[0])) + timedelta(minutes=int(endArray[1]))
                if start > end:
                    end = end + timedelta(days=1)
                result["start_time"] = start.strftime(format)
                result["end_time"] = end.strftime(format)
                next_n_slots.append(result)
                print(result)
                if nextNInput >= 10:
                    break;

            current_time = current_time + timedelta(days=1)

    return next_n_slots

def isTheWeekListEmpty(week_config):
    count = 0
    for day in week_config:
        if (len(day) == 0):
            count += 1
        else: return False

    if count == 7:
        return True
    else: False;

INP_1 = [
    [  # Monday
        {"start_time": "06:00", "end_time": "06:30"},
        {"start_time": "06:30", "end_time": "07:00"},
        {"start_time": "07:00", "end_time": "07:30"},
        {"start_time": "07:30", "end_time": "08:00"}
    ], [  # Tuesday
    ], [  # Wednesday
        {"start_time": "06:00", "end_time": "06:30"},
        {"start_time": "06:30", "end_time": "07:00"},
        {"start_time": "07:00", "end_time": "07:30"},
        {"start_time": "07:30", "end_time": "08:00"}
    ], [  # Thursday
        {"start_time": "09:00", "end_time": "09:30"},
        {"start_time": "09:30", "end_time": "10:00"},
        {"start_time": "10:00", "end_time": "10:30"},
        {"start_time": "10:30", "end_time": "11:00"}
    ], [  # Friday
    ], [  # Saturday
    ], [  # Sunday
    ]
]

OUT_1 = [
    {"start_time": "2017-01-02 06:00:00", "end_time": "2017-01-02 06:30:00"},
    {"start_time": "2017-01-02 06:30:00", "end_time": "2017-01-02 07:00:00"},
    {"start_time": "2017-01-02 07:00:00", "end_time": "2017-01-02 07:30:00"},
    {"start_time": "2017-01-02 07:30:00", "end_time": "2017-01-02 08:00:00"},
    {"start_time": "2017-01-04 06:00:00", "end_time": "2017-01-04 06:30:00"},
    {"start_time": "2017-01-04 06:30:00", "end_time": "2017-01-04 07:00:00"},
    {"start_time": "2017-01-04 07:00:00", "end_time": "2017-01-04 07:30:00"},
    {"start_time": "2017-01-04 07:30:00", "end_time": "2017-01-04 08:00:00"},
    {"start_time": "2017-01-05 09:00:00", "end_time": "2017-01-05 09:30:00"},
    {"start_time": "2017-01-05 09:30:00", "end_time": "2017-01-05 10:00:00"}
]

INP_2 = [
    [],
    [],
    [],
    [],
    [],
    [],
    []
]

OUT_2 = []

INP_3 = [
    [  # Monday
        {"start_time": "06:00", "end_time": "06:30"},
        {"start_time": "06:30", "end_time": "07:00"},
    ], [  # Tuesday
        {"start_time": "06:00", "end_time": "06:30"},
        {"start_time": "07:00", "end_time": "07:30"},
        {"start_time": "07:30", "end_time": "07:45"}
    ], [  # Wednesday
    ], [  # Thursday
        {"start_time": "09:00", "end_time": "10:00"}
    ], [  # Friday
    ], [  # Saturday
    ], [  # Sunday
    ]
]

OUT_3 = [
    {"start_time": "2017-01-02 06:00:00", "end_time": "2017-01-02 06:30:00"},
    {"start_time": "2017-01-02 06:30:00", "end_time": "2017-01-02 07:00:00"},
    {"start_time": "2017-01-03 06:00:00", "end_time": "2017-01-03 06:30:00"},
    {"start_time": "2017-01-03 07:00:00", "end_time": "2017-01-03 07:30:00"},
    {"start_time": "2017-01-03 07:30:00", "end_time": "2017-01-03 07:45:00"},
    {"start_time": "2017-01-05 09:00:00", "end_time": "2017-01-05 10:00:00"},
    {"start_time": "2017-01-09 06:00:00", "end_time": "2017-01-09 06:30:00"},
    {"start_time": "2017-01-09 06:30:00", "end_time": "2017-01-09 07:00:00"},
    {"start_time": "2017-01-10 06:00:00", "end_time": "2017-01-10 06:30:00"},
    {"start_time": "2017-01-10 07:00:00", "end_time": "2017-01-10 07:30:00"}
]

INP_4 = [
    [# Monday
        {"start_time": "21:30", "end_time": "06:30"}],
    [# Tuesday
        {"start_time": "21:00", "end_time": "21:00"}]
]

OUT_4 = [{"start_time": "2017-01-01 21:30:00", "end_time": "2017-01-02 06:30:00"},
         {"start_time": "2017-01-02 21:00:00", "end_time": "2017-01-02 21:00:00"},
         {'start_time': '2017-01-03 21:30:00', 'end_time': '2017-01-04 06:30:00'},
         {'start_time': '2017-01-04 21:00:00', 'end_time': '2017-01-04 21:00:00'},
         {'start_time': '2017-01-05 21:30:00', 'end_time': '2017-01-06 06:30:00'},
         {'start_time': '2017-01-06 21:00:00', 'end_time': '2017-01-06 21:00:00'},
         {'start_time': '2017-01-07 21:30:00', 'end_time': '2017-01-08 06:30:00'},
         {'start_time': '2017-01-08 21:00:00', 'end_time': '2017-01-08 21:00:00'},
         {'start_time': '2017-01-09 21:30:00', 'end_time': '2017-01-10 06:30:00'},
         {'start_time': '2017-01-10 21:00:00', 'end_time': '2017-01-10 21:00:00'}
         ]

SAMPLE_INPUT_OUTPUTS = [
    (INP_1, OUT_1),
    (INP_2, OUT_2),
    (INP_3, OUT_3),
    (INP_4, OUT_4),
]



"""Test cases are designed to run at 8:30 PM.

3 test cases are provided. All cases are not covered. Make sure you handle the cases that are not covered in the list of test cases.
Expecting more test cases to be written.
"""
import datetime
time_of_run = datetime.datetime(2017, 1, 1, 20, 30)  # Sunday
for ip, expected_output in SAMPLE_INPUT_OUTPUTS:
    output = get_next_n_slots(ip, time_of_run)
    assert output == expected_output
    print("----------------")