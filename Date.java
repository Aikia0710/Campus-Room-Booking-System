package Booking;

/**
 * Based on the date class, here three more methods have been added
 * in, the setter method for the booking table, it is used to create 
 * the column and the row of the table. 
 *   
 *   @version 2018-12-05
 *   @author Zibo Wang
 */
public class Date {

    /**
     * Three field variables for day, month, and year of types int,
     * String and int, respectively. Adding one more variable bookingtable
     * which is a two dimensions array used to create the booking table.
     */
    private int day;
    private String month;
    private int year;
    private String [][] bookingtable = new String [10][1];
    
    /**
     * 
     * @param rooms
     */
    public void setBookingtable(String [] rooms) {
    	this.bookingtable = new String [10][rooms.length + 1];
    	//create the room number row of the table 
    	for (int i = 1; i < bookingtable[0].length;i++) {
    		this.bookingtable[0][i]= rooms[i-1];
    	}
    	//create the booking time column of the table
    	bookingtable[0][0] = null;
    	bookingtable[1][0] = "9:00";
    	bookingtable[2][0] = "10:00";
    	bookingtable[3][0] = "11:00";
    	bookingtable[4][0] = "12:00";
    	bookingtable[5][0] = "13:00";
    	bookingtable[6][0] = "14:00";
    	bookingtable[7][0] = "15:00";
    	bookingtable[8][0] = "16:00";
    	bookingtable[9][0] = "17:00";
    }
    /**
     * the getter method for the booking table
     * @return updating the new value of the booking table
     */
    public String [][] getBookingtable(){
    	return this.bookingtable;
    }
    /**
     * using the method to check if the room at a specific time 
     * has been booked or not. If not, define it as null and input 
     * the String purpose variable
     * @param room
     * @param hour
     * @param purpose
     * @return
     */
    public boolean book(String room, int hour, String purpose) {
    	int i = 1;
    	int j = 1;
    	for (; i < bookingtable[0].length; i++){
    		if (room.equals(bookingtable[0][i])){
    			break;
    		}
    	}
    	for (; j < bookingtable.length; j++) {
    		if (bookingtable[j][0].contains(hour + "")) {
    			break;
    		}
    	}
    	if (bookingtable[j][i] == null) {
    		bookingtable[j][i] = purpose;
    		return true;
    	} else {
    		return false;
    	}
    }
    /**
     * Same as previous method, if one room at a specific time
     * has been booked by someone, which means it's not null there
     * will be some values in it, then change it as null, which means
     * the booking has been cancel, someone else can still put the booking.
     * @param room
     * @param hour
     */
    public void cancel(String room, int hour) {
    	int i = 1;
    	int j = 1;
    	for (;i < bookingtable[0].length;i++) {
    		if (room.equals(bookingtable[0][i])) {
    			break;
    		}
    	}
    	for (;j<bookingtable.length;j++) {
    		if (bookingtable[j][0].contains(hour + "")) {
    			break;
    		}
    	}

    	if (bookingtable[j][i] != null) {
    		bookingtable[j][i] = null; 
    	} else 
    		System.out.println("Booking information is empty");
    }
    
    
   
    public static final String[] MONTH = {
    	"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    public static final int[] MAX_DAY_IN_MONTHS = {
    	31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static boolean admissibleYear(int year) {
    	return year > 0;
    }

    public static boolean admissibleMonth(String month) {
    	for (int i = 0; i < 12; i++) {
    		if (month.equals(MONTH[i])) {
    			return true;
    		} 
    	}
    	return false;
    }

    public static boolean leapYear(int year) {
    	if (year % 400 == 0) {
    		return false;
    	} else if (year % 100 == 0) {
    		return false;
    	} else if (year % 4 == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static boolean admissibleDay(int day, String month, int year) {
    	for (int i = 0; i < 12; i++) {
    		if (month.equals(MONTH[i])) {
    			return 1 <= day && day <= MAX_DAY_IN_MONTHS[i];
    		}
    	}
    	if (leapYear(year) && month.equals(MONTH[1])) {
    		return 1 <= day && day <= 29;
    	}
    	return false;
    }
    /**
     *  @param day The input of a day such as 21 as an int.
     *  @param month The input of a month such as "October" as a String.
     *  @param year The input of a year such as 2016 as an int.
     *  @return true if the day, the month, and the year are all admissible
     *  THIS IS A METHOD STUB. THE METHOD NEEDS STILL TO BE WRITTEN!
     */
    public static boolean admissible(int day, String month, int year) {
        return admissibleYear(year) && 
        admissibleDay(day, month, year) && 
        admissibleMonth(month);
    }

    public int getDay() {
    	return day;
    } 

    public void setDay(int day) {
    	if(admissible(day, month, year)) {
    		this.day = day;
    	} else {
    		throw new IllegalArgumentException();
    	}
    }

    public String getMonth() {
    	return month;
    }

    public void setMonth(String month) {
    	if(admissible(day, month, year)) {
    		this.month = month;
    	} else {
    		throw new IllegalArgumentException();
    	}
    }

    public int getYear() {
    	return year;
    }

    public void setYear(int year) {
    	if(admissible(day, month, year)) {
    		this.year = year;
    	} else {
    		throw new IllegalArgumentException();
    	}
    }

    public String toString() {
        return this.day + " " + this.month + " " + this.year;
    }

    /**
     *  @param day The input of a day such as 21 as an int.
     *  @param month The input of a month such as "October" as a String.
     *  @param year The input of a year such as 2018 as an int.
     *  Note that the constructor throws an IllegalArgumentException if
     *  the date to be constructed would be not admissible.
     */
    public Date(int day, String month, int year) {
    	if(admissible(day, month, year)) {
    		this.day = day;
    		this.month = month;
    		this.year = year;
    	} else {
    		throw new IllegalArgumentException("Invalid data in class Date.");
    	}
    }
	
    public static void main(String[] args) {
        Date d1 = new Date(26, "October", 2018);
        System.out.println(d1);
        Date d2 = new Date(30, "October", 2018);
        System.out.println(d2);
        Date d3 = new Date(20, "January", 2018);
        System.out.println(d3);
    }
}
