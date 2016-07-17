package gao.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gao.spring.po.Person;
import gao.spring.service.PersonService;
@Transactional
public class PersonServiceImpl implements PersonService {
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Person person) throws Exception {
		sessionFactory.getCurrentSession().persist(person);
	}

	@Override
	public void update(Person person) throws Exception {
		sessionFactory.getCurrentSession().merge(person);
	}

	@Override @Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public Person getPerson(Integer id) throws Exception {
		return (Person) sessionFactory.getCurrentSession().get(Person.class, id);
	}

	@Override
	public void delete(Integer id) throws Exception {
		Person person = (Person) sessionFactory.getCurrentSession().load(Person.class, id); // load的性能比get好
		sessionFactory.getCurrentSession().delete(person);
	}

	@Override @Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<Person> getPersons() throws Exception {
		// 采用hql语言进行查询
		@SuppressWarnings("unchecked")
		List<Person> persons = sessionFactory.getCurrentSession().createQuery("from Person").list();
		return persons;
	}

}
