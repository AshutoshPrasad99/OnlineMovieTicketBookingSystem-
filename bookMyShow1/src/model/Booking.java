package model;

public class Booking
{
	private int bookingID;
	private int userId;
	private String custName;
	private int custAge;
	private int showID;
	private String seat;
	
	public int getBookingID()
	{
		return bookingID;
	}
	public void setBookingID(int bookingID)
	{
		this.bookingID = bookingID;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getCustName()
	{
		return custName;
	}
	public void setCustName(String custName)
	{
		this.custName = custName;
	}
	public int getCustAge()
	{
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public int getShowID()
	{
		return showID;
	}
	public void setShowID(int showID)
	{
		this.showID = showID;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
}
