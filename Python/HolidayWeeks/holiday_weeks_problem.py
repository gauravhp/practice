from calendar import monthrange
import datetime


def solution(Y, A, B, W):
    first_monday_of_A=first_weekday(datetime.date(Y,monthToNum(A),1),0)
    last_sunday_of_B=last_weekday(datetime.date(Y,monthToNum(B),monthrange(Y,monthToNum(B))[1]),6)
    delta = last_sunday_of_B - first_monday_of_A
    return int((delta.days+1)/7)


## MONDAY = 0 , TUESDAY = 1 ... etc
def first_weekday(d, weekday):
    days_ahead = weekday - d.weekday()
    if days_ahead <= 0:  # Target day already happened this week
        days_ahead += 7
    return d + datetime.timedelta(days_ahead)

## MONDAY = 0 , TUESDAY = 1 ... etc
def last_weekday(d, weekday):
    days_behind = weekday - d.weekday()
    if days_behind >= 0:  # Target day already happened this week
        days_behind -= 7
    return d + datetime.timedelta(days_behind)


def monthToNum(shortMonth):
    return {
        'January': 1,
        'February': 2,
        'March': 3,
        'April': 4,
        'May': 5,
        'June': 6,
        'July': 7,
        'August': 8,
        'September': 9,
        'October': 10,
        'November': 11,
        'December': 12
    }[shortMonth]


def weekToNum(shortWeek):
    return {
        'Monday': 0,
        'Tuesday': 1,
        'Wednesday': 2,
        'Thursday': 3,
        'Friday': 4,
        'Saturday': 5,
        'Sunday': 6
    }[shortWeek]


def main():
    Y = 2014
    A = "April"
    B = "May"
    W = "Wednessday"
    print(solution(Y, A, B, W))


if __name__ == "__main__":
    main()
