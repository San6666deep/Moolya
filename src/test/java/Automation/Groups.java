package Automation;

import org.testng.annotations.Test;

public class Groups {
	
@Test (groups = "smoke" ,priority = 0)
public void test1() {
	System.out.println("This is my first smoke test");
}

@Test (groups = "regression" ,priority = 1)
public void test2() {
	System.out.println("This is my first regression test");
}

@Test (groups = "smoke" ,priority = 2)
public void test3() {
	System.out.println("This is my second smoke test");
}

@Test (groups = "regression" ,priority = 3)
public void test4() {
	System.out.println("This is my second regression test");
}



}
