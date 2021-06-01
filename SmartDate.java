public class SmartDate {
    private int day;
    private int month;
    private int year;

    public static void main(String[] args) {
        SmartDate x = new SmartDate(10, 2, 2021);
        StdOut.print(x.dayOfTheWeek());
    }

    public SmartDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new RuntimeException("Invalid Date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public SmartDate(String line) {
        String[] args = line.split("/");
        this.day = Integer.parseInt(args[0]);
        this.month = Integer.parseInt(args[1]);
        this.year = Integer.parseInt(args[2]);
        
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (day > 31 || day < 1) return false;
        if (month > 12 || month < 1) return false;
        if (day == 31) {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 12 || month == 8
                    || month == 10) {
            }
            else {
                return false;
            }
        }
        if (day > 29 && month == 2) return false;
        if (day == 29 && month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) return true;
            else return false;
        }
        return true;
    }

    public int day() {
        return this.day;
    }

    public int month() {
        return this.month;
    }

    public int year() {
        return this.year;
    }

    public String toString() {
        return day() + "/" + month() + "/" + year();
    }

    public String dayOfTheWeek() {
        String days[] = { "Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri" };
        int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int monthsLeap[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int diff = this.year - 2000;
        int daysCount = diff * 365;
        if (year % 4 == 0) {
            daysCount += (diff / 4) - 1;
            for (int i = 0; i < this.month - 1; i++) {
                daysCount += monthsLeap[i];
            }
        }
        else {
            daysCount += diff / 4;
            for (int i = 0; i < this.month - 1; i++) {
                daysCount += months[i];
            }
        }

        daysCount += this.day;

        return days[daysCount % 7];


    }
}
