package tuan4;

public class Main {
	public static void main(String[] args) {
        Person person=new Person("Thai Thai","Ben Tre");
        Person person1=new Student("Thai Thai","Ben Tre","Dai hoc",3,31313.0);
        Person person2=new Staff("Thai Thai","Ben Tre","Sai Gon",1313.0);
        System.out.println(person);
        System.out.println(person1);
        System.out.println(person2);
	}
}
