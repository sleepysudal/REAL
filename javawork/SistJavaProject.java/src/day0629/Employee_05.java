package day0629;

public class Employee_05 {
	
	String sawonName;
	int salary;
	
	public Employee_05(String name, int salary) {
		
		this.sawonName=name;
		this.salary=salary;
		
	}
	//리턴해주는 메서드
	public String getEmp() {
		return sawonName+","+salary;
	}
}

// public String getEmp() 이렇게만 끝나면 추상메서드