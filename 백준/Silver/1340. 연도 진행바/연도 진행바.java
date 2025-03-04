import java.io.*;

public class Main {
    static String[] inputs;
    static long totalDay = 0;
    static boolean leapYear = false;
    static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().split(" ");

        int year = Integer.parseInt(inputs[2]);
        checkYear(year);
        checkDays(inputs[0], Integer.parseInt(inputs[1].split(",")[0]));
        totalDay = totalDay * 24 * 60;
        String[] time = inputs[3].split(":");
        checkTime(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
        if (leapYear) {
            System.out.println(totalDay * 10.0 / (366 * 24 * 6));
        } else {
            System.out.println(totalDay * 10.0 / (365 * 24 * 6) );
        }
    }

    private static void checkTime(int hour, int minutes) {
        totalDay += 60 * hour;
        totalDay += minutes;
    }

    private static void checkYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            leapYear = true;
        }
    }

    private static void checkDays(String month, int day) {
        int mon = 0;
        switch (month) {
            case "January":
                mon = 1;
                break;
            case "February":
                mon = 2;
                break;
            case "March":
                mon = 3;
                break;
            case "April":
                mon = 4;
                break;
            case "May":
                mon = 5;
                break;
            case "June":
                mon = 6;
                break;
            case "July":
                mon = 7;
                break;
            case "August":
                mon = 8;
                break;
            case "September":
                mon = 9;
                break;
            case "October":
                mon = 10;
                break;
            case "November":
                mon = 11;
                break;
            case "December":
                mon = 12;
                break;
        }
        for (int i = 1; i < mon; i++) {
            // 3-1. 윤달이라면?
            if (leapYear && i == 2) {
                totalDay += 29;
                continue;
            }
            totalDay += days[i];

        }
        totalDay += day - 1;
    }
}