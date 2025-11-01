package EXP7_1.java;
import java.util.Scanner;
class student{
	String name ;
	float mark1;
	float mark2;
	float mark3;
	student(String a,float b,float c,float d){
		name=a;
		mark1=b;
		mark2=c;
		mark3=d;
	}
}
class LengthException extends Exception {
	LengthException(String name) {
	super(name);
	}
	}
class FailedException extends Exception {
	FailedException(String name) {
	super(name);
	}
	}
class NotFirstClassException extends Exception {
	NotFirstClassException(String name) {
	super(name);
	}
	}
public class EXP7_1 {
	static void task() throws LengthException {
		LengthException me=new LengthException("Name has Exceeded Length !");
		throw me;
		}
	static void task1() throws FailedException {
		FailedException me1=new FailedException("Student has Failed !!");
		throw me1;
		}
	static void task2() throws NotFirstClassException {
		NotFirstClassException h=new NotFirstClassException("Not first Class");
		throw h ;
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the Name");
		String n = sc.next();
		System.out.println("Enter the marks of 3 Subjects");
	    float m1 = sc.nextFloat();
	    float m2 = sc.nextFloat();
	    float m3 = sc.nextFloat();
	    float avg = (m1+m2+m3)/3;
	    System.out.println("Average Marks: " + avg);
		try {
			if(n.length()>7)
				{task();}
			} catch (LengthException e) {
			System.out.println(e.getMessage());
			}
		try {
			if(avg<50)
				{task1();}
			} catch (FailedException e) {
			System.out.println(e.getMessage());
			}
		try {
			if(avg<75 && avg>=50)
				{task2();}
			} catch (NotFirstClassException e) {
			System.out.println(e.getMessage());
			}

	}

}

