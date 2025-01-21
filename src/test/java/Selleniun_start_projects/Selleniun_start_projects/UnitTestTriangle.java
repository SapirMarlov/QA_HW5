package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.mockito.Mockito;

public class UnitTestTriangle {
	

	isEquilateral IsEquilateral= Mockito.mock(isEquilateral.class);;
	isIsosceles IsIsosceles= Mockito.mock(isIsosceles.class);;
	isTriangle IsTriangle= Mockito.mock(isTriangle .class);;
	TriangleClassifier triTriangleClassifier= new TriangleClassifier(IsIsosceles,IsTriangle,IsEquilateral);
	@Test
	public void unitest_multiplier_1() {

	Mockito.when(IsIsosceles.test(2, 2,1)).thenReturn(true);
	int a=2,b=2,c=2;
	String expected_result=Triangle_Types.Isoscele.toString();
	String actual_result  =  triTriangleClassifier.classifyTriangle(a, b,c);
	assertEquals(expected_result,actual_result,0);
	}
}

