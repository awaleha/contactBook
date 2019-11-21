package contacts; 

public class Contact{
	private final long id;
	private final String firstName;
	private final String lastName;
	private final String fullName;
	private final String phoneNum;
	private final String cellNum;
	private final String address;

	public Contact(long id, String firstName, String lastName, String fullName, String phoneNum, String cellNum, String address){
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.fullName=fullName;
		this.phoneNum=phoneNum;
		this.cellNum=cellNum;
		this.address=address;

	}

	public long getId(){
		return id;
	}

	public String getFullName(){
		return fullName;
	}

	@Override
	public String toString(){
		return String.format(fullName  + " " + phoneNum + " " + cellNum + " " + address);
	}

}