package com.week1;

public class EmpSimulation2 {
	//main메소드에서 인스턴스화한 Emp의 주소번지(지역변수)를 setEmp 즉, 다른 메소드에서 사용하려면
	//메소드의 파라미터 자리를 이용하세요.
	//만일 이해됐다면 after에서는 0, null, null이 출력되도록 코드를 변경해 보시오.
	void setEmp(Emp emp) {//Emp emp = null; 상태에서 es2.setEmp(emp); 호출되면 -> emp = new Emp(); 가 되어 밑에 emp가 그대로 가져와짐
		//insert here
		emp = new Emp(); //얘가 없으면 before, after 같은 값 출력. 있으면 새로운 객체 생성됐으니 이 메소드 안에서만 아랫값이 유지(지역변수). 따라서after가 0, null, null 값으로 출력.
		emp.empno = 7566; // 0 -> 7566
		emp.ename = "Smith"; // null -> Smith
		emp.job = "영업"; // null -> 영업
		System.out.println("====================[[before]]======================");
		System.out.println(emp.empno + "," + emp.ename + "," + emp.job); // 7566, Smith, 영업 출력됨
	} //end of setEmp
	public static void main(String[] args) {
		EmpSimulation2 es2 = new EmpSimulation2(); // setEmp 메소드를 호출하기 위해서 인스턴스화 함
		Emp emp = new Emp(); // 사원집합을 관리하는 클래스를 인스턴스화 함
		es2.setEmp(emp); // 메소드 호출할 때 파라미터로 위에 선언한 인스턴스변수를 넘겨줌(emp는 0, null, null 값)
		System.out.println("====================[[after]]=======================");
		System.out.println(emp.empno + ", " + emp.ename + ", "+ emp.job); // 여기서는 어떤 값 출력?
	}

}
// main메소드에서 생성한 객체를 다른 메소드에서 사용하고 싶다면 어떡하지?








