/**
 * 
 */
package com.diwakar.springexample.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diwakar.springexample.model.Person;
import com.diwakar.springexample.service.PersonService;

/**
 *  @author Diwakar
 *
 * Date:  Aug 6, 2015 2015
 * File: PersonRestController.java
 */
@RestController
public class PersonRestController {
	
	private PersonService personService;

	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	
	@RequestMapping(value="/restapi/json/getallpersons", method=RequestMethod.GET)
	@ResponseBody
	public List<Person> getListOfPersons()
	{
		List<Person> listOfPersons = personService.listPersons();
		
		System.out.println("Size of personlist = "+ listOfPersons.size());
		return listOfPersons;
		
	}
	
	
	@RequestMapping(value="/restapi/string/getallpersons", method=RequestMethod.GET)
	@ResponseBody
	public String getListOfPersonsAsString()
	{
		List<Person> listOfPersons = personService.listPersons();
		
		System.out.println("Size of personlist = "+ listOfPersons.size());
		return listOfPersons.toString();
		
	}
	
	@RequestMapping(value="/restapi/string/getPersonbyID/{personId}", method=RequestMethod.GET)
	public String getPersonByIDString(@PathVariable("personId") int personId)
	{
		Person p = personService.getPersonById(personId);
		return p.toString();
		
	}
	
	@RequestMapping(value="/restapi/json/getPersonbyID/{personId}", method=RequestMethod.GET)
	@ResponseBody
	public Person getPersonByIDJSON(@PathVariable("personId") int personId)
	{
		Person p = personService.getPersonById(personId);
		return p;
		
	}
	
	@RequestMapping(value="/restapi/addperson",method=RequestMethod.POST)
	@ResponseBody
	public String addNewPerson(@RequestBody Person p)
	{
		
		System.out.println("adding person  "+ p.toString());
		personService.addPerson(p);
		System.out.println("added successfully!");
		return "Added successfully!!";
		
		
	}
	
	@RequestMapping(value="/restapi/editperson",method=RequestMethod.POST)
	@ResponseBody
	public String editperson(@RequestBody Person p)
	{
		System.out.println("editing person  "+ p.toString());
		personService.updatePerson(p);
		System.out.println("updated successfully!");
		return "Updated successfully!!";
		
		
	}
	
	

}
