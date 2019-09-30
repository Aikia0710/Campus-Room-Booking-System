package Booking;
/**
 * This RoomBooking class is under the booking package, it contains
 * two field variables, the int year and the the one dimension array 
 * rooms with the type of String[].
 * @version 2018-12-05
 * @author Zibo Wang
 *
 */
public class RoomBooking {
	private int year;
	private String [] rooms; //taken from a fixed number of rooms
	/**
	 * the standard format of the constructor
	 */
	public RoomBooking(int year, String [] rooms) {
		this.year = year;
		this.rooms = rooms;
	}
	/**
	 * recalling the methods in the Date class, to do the room booking
	 * @param room
	 * @param date
	 * @param hour
	 * @param purpose
	 * @return the true or false results of three if conditions
	 */
	public boolean book(String room, Date date, int hour, String purpose) {
    	if (this.year != date.getYear()) {
    		return false;
    	}
    	if (date.getBookingtable()[0].length == 1) {
    		date.setBookingtable(rooms);
    	}
		if (date.book(room, hour, purpose)) {
			return true;
		} else 
			return false;
    }
	/**
	 * using the if condition to judge if the year input will match with 
	 * the year in class date, if the result is true. It will be able to 
	 * delete a booking if it exists, so that the room is again available 
	 * for further bookings.
	 * @param room
	 * @param date
	 * @param hour
	 */
    public void cancel(String room, Date date, int hour) {
    	if (this.year == date.getYear()) {
    	date.cancel(room, hour);
    	}
    }
	/**
	 * setter method for the Rooms
	 * @param rooms updating the value of the variable
	 */
    public void setRooms(String [] rooms) {
		this.rooms = rooms;
	}
	/**
	 * getter method of the variable
	 * @return reading value of the variable
	 */
	public String[] getRooms() {
		return this.rooms;
	}
	/**
	 * setter method of the variable year
	 * @param year updating the value of the year variable
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * the method is used to display the date of the booking table
	 * and print out the whole booking table
	 * @param date
	 * @return
	 */
	public String displayDay(Date date) { 
		if (date.getBookingtable()[0].length == 1) {
    		date.setBookingtable(rooms);
    	}
		
		String table = " ";
		table = String.format("\t\t\t\t\t\t%2s %-8s %4s\n\n", date.getDay(), 
														date.getMonth(), 
														date.getYear());
		for (int i = 0; i<date.getBookingtable().length;i++) {
			for (int j = 0; j < date.getBookingtable()[i].length;j++) {
				if(date.getBookingtable()[i][j] == null) {
				   date.getBookingtable()[i][j] = " ";
				}
				//defining the length of the String
				while (date.getBookingtable()[i][j].length()<15) {
					date.getBookingtable()[i][j] += " ";
				}
				table += "      " + date.getBookingtable()[i][j] + "       |";
				}
		table += "\n";
		int count = 0;
		while (count<date.getBookingtable()[0].length) {
			table += "----------------------------+";
			count ++;
		}
		table += "\n";
		}
		return table;
	}
	
	public static void main (String args[]) {
		String[] rooms = {"R217","R222","R225","R245"};
		Date nov22 = new Date(05,"December",2018);
		RoomBooking bookings2018 = new RoomBooking(2018,rooms);
		System.out.println(bookings2018.book("R222", nov22, 12, "Tutor meeting"));
		System.out.println(bookings2018.book("R222", nov22, 12, "Java meeting"));
		System.out.println(bookings2018.book("R222", nov22, 13, "Interviews"));
		System.out.println(bookings2018.book("R245", nov22, 16, "Project meeting"));
		System.out.println(bookings2018.book("R225", nov22, 14, "Top-up tutorial"));
		bookings2018.cancel("R222", nov22, 12);
		System.out.println(bookings2018.book("R222", nov22, 12, "ML meeting"));
		System.out.println(nov22.getBookingtable()[2][4]);
		System.out.println(bookings2018.displayDay(nov22));
	}
}
