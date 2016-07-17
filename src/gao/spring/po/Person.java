package gao.spring.po;

public class Person {
	private Integer id;
	private String name;
	
	public Person(){}
	
	public Person(String name){
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id="+id+", name="+name;
	}
}
