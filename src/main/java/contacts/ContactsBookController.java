package contacts;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContactsBookController{

	private final AtomicLong counter = new AtomicLong();
	//Key: FirstName.LastName, Value: Contact Object
	private final HashMap<String, Contact> contactMap = new HashMap<String, Contact>();


	//Searches through our HashMap for the user, returns error if user does not exist
	@RequestMapping(value ="/contacts/{name}", method = RequestMethod.GET )
	public String getContact(@PathVariable final String name){
		try {
			String value = contactMap.get(name).toString();
		}
		catch(NullPointerException e){
			return "That user does not exist";
		}

		return contactMap.get(name).toString();
	} 


	//Creates contact based on GET request, creates a Contact Object and populates based on the fields provided
	@RequestMapping(value="/contacts/create/{firstName}/{lastName}/{phoneNum}/{cellNum}/{address}", method = RequestMethod.GET)
	public String createUser(@PathVariable String firstName,@PathVariable String lastName,@PathVariable String phoneNum,@PathVariable String cellNum,@PathVariable String address){
		
		String fullName = firstName + "." + lastName;


		//Verifies first and last name are not empty
		if( (firstName.isEmpty()) || (lastName.isEmpty()) ){
			return "First and/or Last name cannot be empty!";
		}



		
		Contact user1 = new Contact(counter.incrementAndGet(), firstName, lastName, fullName, phoneNum, cellNum, address);
		System.out.println(user1.toString());
		contactMap.put(fullName, user1);


		return user1.toString();
	}

	//removes contact based on name provided
	@RequestMapping(value ="/contacts/delete/{name}", method = RequestMethod.GET )
	public String deleteContact(@PathVariable final String name){
		if(!name.contains("."))
			return "Please seperate first and last name with a period. Example:   Firstname.Lastname   ";
		contactMap.remove(name);
		return "Have removed contact " + name;
	}

	@RequestMapping(value ="/contacts/all", method = RequestMethod.GET )
	public String allContact(){
		String all = " ";
		for (String key : contactMap.keySet()){
			all= all + "[ \n" + contactMap.get(key).toString() + "]		";

		}
		return all;
	}

	@RequestMapping(value ="/contacts/update/{firstName}/{lastName}/{phoneNum}/{cellNum}/{address}", method = RequestMethod.GET )
	public String updateContact(@PathVariable String firstName,@PathVariable String lastName,@PathVariable String phoneNum,@PathVariable String cellNum,@PathVariable String address) {
		String fullName = firstName + "." + lastName;

		//Verifies first and last name are not empty
		if( (firstName.isEmpty() ) || (lastName.isEmpty() ) ){
			return "First and/or Last name cannot be empty!";
		}

		
		Contact user1 = new Contact(counter.incrementAndGet(), firstName, lastName, fullName, phoneNum, cellNum, address);
		contactMap.put(fullName, user1);
		return user1.toString();
	}

}