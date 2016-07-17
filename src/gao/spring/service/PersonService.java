package gao.spring.service;

import java.util.List;

import gao.spring.po.Person;

public interface PersonService {
	
	public void save(Person person) throws Exception;
	
	public void update(Person person) throws Exception;
	
	public Person getPerson(Integer id) throws Exception;
	
	public void delete(Integer id) throws Exception;
	
	public List<Person> getPersons() throws Exception;
}
