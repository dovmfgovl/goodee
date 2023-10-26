package com.step5;

import java.util.ArrayList;

public class EmpManager {
	ArrayList<EmpDTO> empList = new ArrayList<>();// 뒤엔 제네릭 타입 생략 가능해서 <>만 //아무것도 없다 size() = 0
	void getEmpList() {
		System.out.println(empList.size()); //0
		EmpDTO emp = new EmpDTO(7566, "나신입", "영업", 7500, "2000-10-20", 3000, 500, 10); //00000nullnullnull
		empList.add(0, emp); //명시 하자면 0번째에 들어가는 거.. 굳이 안적어도 되긴 함 
		//System.out.println(empList.size()); //1 출력. 위에서 add 했으니까.
		emp = new EmpDTO();
		empList.add(1, emp); 
		System.out.println(empList.size()); //2
		for(int i=0; i<empList.size(); i++) {
			EmpDTO remp = empList.get(i);
			System.out.println(remp.getEmpno() +", "+ remp.getEmpno() +","+ remp.getHiredate());
		}
	}
 	public static void main(String[] args) {
 		//자기자신을 인스턴스화 해야만 전역변수가 인식됨
		EmpManager em = new EmpManager();
		em.getEmpList();
	}

}
