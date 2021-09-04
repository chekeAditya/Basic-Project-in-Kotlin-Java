package Kotlin_From_Basic_To_Advanced.OOPS

fun main() {
    /**
     * OOPS :- Object Oriented Programming System
     * A programming paradigm that uses the concept of classes and objects.
     * IN OOPS we had class & Objects
     * Properties and functions
     *
     * Classes are the blueprint of the objects. WHere we put both variable and function
     *
     * Four Main Principles of OOP
     * Encapsulation :-  it is encapsulating data and function together
     * Inheritance :- it means we can use the property and function of one class to another class
     * Abstraction :- It means hiding ( when we design a system we had to hide something and visible whenever it's necessary)
     * Polymorphism :- We will design a classes in a way that we can reuse the same function to achieve different behaviour's and different classes
     */

    /**
     * Classes and objects present in Box B_ClassesAndObject package
     * Kotlin Getters and Setters present in Box B_ClassesAndObject package
     */


    /**
     * Visibility Modifiers
     * InKotlin we had 4 types of Visibility Modifiers
     * public : Default, can be accessed everywhere
     * internal : Available everywhere in the same module
     * private : Available only inside the containing file or class
     * protected : Same as private but available inside subclasses or child classes
     */

    /**
     * Kotlin Constructor-Primary,Secondary Constructor
     * If we haven't created any constructor then at that time we are using default constructor
     */

    /**
     * Kotlin Inheritance :- deriving or creating another class using existence class
     * Now this derived class inherit the properties of the parent class. that will allow us to use the existing implementation of the parent class
     * Inheritance helps us in code reusable.
     *
     * All the classes in kotlin are final by default so if you want to integrate a class you need to inherit the class you
    had to tell them we had to inherit this class
     * open is used to make the class inheritable, now you can inherit this class in the another class
     *
     *  all the classes in kotlin are final by default so if you want to integrate a class you need to inherit the class you
    had to tell them we had to inherit this class for that make the class as open
     *  If some properties are private then you cannot access them in the child classes
     */

    /**
     * Kotlin Abstract class
     * Abstract in kotlin:- it's a keyword, and it means just defining the members or the functions of a class without the actual implementation
     * When to use this : Whenever you need to define a common set of rules for multiple classes you can make a common parent multiple class, and you can derive the child classes using the base class
     */

    /**
     * Interface :-Interface is same as abstract class, and it can contain abstract function and abstract members, and it can also contain function with implementation
     *
     * What's the use of interface if it already seems like abstract class?
     * In an interface you can't have init block or constructor.but for an abstract block you can have primary constructor as well as secondary constructor and you can have init blocks
     */
}