package stacksAndQueues;
// import java.util.*;

public class oopsIntroAndtheory {
    // class => where data members and functions are put together(encapsulated)
    public static class Person{
        int age;
        String name;

        void SaysHi(){
            System.out.println(name + "[" + age + "] " + "says Hi");
        }

        // if we forget to create a constructor, java provides a default contructor => without parameter
        // if we make a parametrised constructor, java removes its default constructor

        Person(){
            // this is a default contructor
            // this constructor doesn't have any parameter
            // if we remove this constructor, there would be errors from lines resembming Person p = new Person();
            // this is because there would be no default constructor resulting in the errors

        }
        Person(int age, String name){
            // this is a parameterised contructor
            this.age = age;
            this.name = name;
        }
    }

    // this doesn't swap the two references
    // the reason being that this function is erased from the memory after swapping is done within the allocated memory
    // so no changes are reflected in the main code
    public static void swap1(Person ps1, Person ps2){
        Person temp = ps1;
        ps1 = ps2;
        ps2 = temp;
        System.out.println("In the function swap1");
        ps1.SaysHi();
        ps2.SaysHi();
    }

    // this swaps the two references
    // the reason being that this function makes changes in the heap values of object(instance)
    // so changes are reflected in the main code
    public static void swap2(Person ps1, Person ps2){
        int age = ps1.age;
        ps1.age = ps2.age;
        ps2.age = age;

        String name = ps1.name;
        ps1.name = ps2.name;
        ps2.name = name;

        System.out.println("In the function swap2");
        ps1.SaysHi();
        ps2.SaysHi();
    }

    // this doesn't swap the two references properly
    // the reason being that this function makes 2 new references for ps1 and ps2 in stack and swap is done using those new values
    // so the desired results are not reflected in the main code even though some changes are made
    public static void swap3(Person ps1, Person ps2){
        ps1 = new Person();
        int age = ps1.age;
        ps1.age = ps2.age;
        ps2.age = age;

        ps2 = new Person();
        String name = ps1.name;
        ps1.name = ps2.name;
        ps2.name = name;

        System.out.println("In the function swap3");
        ps1.SaysHi();
        ps2.SaysHi();
    }

    public static void main(String[] args) {
        // in stack, a reference to the instance(object) is made => stores address
        // in heap, an instance is made which consists in this case age and name => this instance is called object
        // new allocates a new space

        Person p1 = new Person();    // this reference is made using default contrsuctor; this creates a reference to the object => let say 4k
        p1.age = 16;                 // made in heap
        p1.name = "Vishwa";          // made in heap
        // p1.SaysHi();              // function acts on p1

        Person pPar = new Person(25, "K");    // this reference is made using parametrised constructor
        pPar.SaysHi();

        Person p2 = new Person();    // let say 5k
        p2.age = 20;
        p2.name = "Vanshika";
        // p2.SaysHi();

        Person p3 = p1;             // a new reference is made which stores same address as p1 => 4k
        p3.age = 30;                // goes to 4k and changes the age from 16 to 30
        // p3.SaysHi();
        // p1.SaysHi();
        // thus in this example, we have three references(address/pointers) but only two instance(objects)

        // swap1() => doesn't swap
        // System.out.println("Before swap1");
        // p1.SaysHi();
        // p2.SaysHi();
        // swap1(p1,p2);
        // System.out.println("After swap1");
        // p1.SaysHi();
        // p2.SaysHi();

        // swap2() => swaps successfully
        // System.out.println("Before swap2");
        // p1.SaysHi();
        // p2.SaysHi();
        // swap2(p1,p2);
        // System.out.println("After swap2");
        // p1.SaysHi();
        // p2.SaysHi();

        // swap3() =>  doesn't swap
        // System.out.println("Before swap3");
        // p1.SaysHi();
        // p2.SaysHi();
        // swap3(p1,p2);
        // System.out.println("After swap3");
        // p1.SaysHi();
        // p2.SaysHi();


    }
    
}
