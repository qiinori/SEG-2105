# Chapter 2 OBJECT ORIENTATION 
Key:  
inheritance, abstraction, modularity, encapsulation, contract, interface,   
exception, polymorphism, dynamic binding, instance vs abstract class, casting, exceptions.  

## textbook P27 notes  
## Notes from slides

**NAMING CLASSES** 
▸ Use capital letters
▸ Use singular nouns
▸ Use the right level of generality
▸ Make sure the name has only one meaning 

INSTANCE VARIABLES：VARIABLES FIELDS MEMBERS ATTRIBUTES
VARIABLES != OBJECTS

**CLASS VARIABLES**
1.Static variables 
2.Shared by all instances
3.Global(good for constants)
4.Global(bad otherwise)

OPERATION ▸ A higher-level procedural abstraction that speciﬁes a type of behaviour ▸ Independent of any code which implements that behaviour
METHOD ▸ A procedural abstraction used to implement the behaviour of a class  

**POLYMORPHISM**
▸ Several different classes can have methods with the same name
▸ They implement the same abstract operation in ways suitable to each class 
▸ A property of object oriented software by which an abstract operation may be performed in different ways in different classes.
▸ Requires that there be multiple methods of the same name
▸ The choice of which one to execute depends on the object that is in a variable
▸ Reduces if-else or switch statements

**INHERITANCE**  
▸ The implicit possession by all subclasses of features deﬁned in its superclasses

THE ISA RULE  
Always check generalizations to ensure they obey the isa rule 

**ABSTRACT CLASSES AND METHODS**  
▸ No instances can be created ▸ The opposite of an abstract class is a concrete class
If we have an abstract operation, then _one_ of the subclasses must have a concrete method
Leaf classes must have or inherit concrete methods for all operations | Leaf class must be concrete

**OVERRIDING** 
▸ A method would be inherited, but a subclass contains a new version instead ▸ AVOID!!! ▸ But if asked on an exam, some reasons would be ▸ For extension (SavingsAccount charges a fee for a debit) ▸ For optimization (getPerimeterLength for Circle simpler than Ellipse) ▸ For restriction (method might not make sense in subclass)

METHOD PRECEDENCE (WHICH ONE TO RUN)
1. If there is a concrete method for the operation in the current class, run that method.
2. Otherwise, check in the immediate superclass to see if there is a method there; if so, run it. 
3. Repeat step 2, looking in successively higher superclasses until a concrete method is found and run.
4. If no method is found, then there is an error ‣ Java / C++ won’t compile (compilation error) ‣ Ruby / PHP throw a runtime error

**DYNAMIC BINDING**
▸ Occurs when decision about which method to run can only be made at run time

**ABSTRACTION**
▸ Object -> something in the world ▸ Class -> objects ▸ Superclass -> subclasses ▸ Operation -> methods ▸ Attributes and associations -> instance variables

**MODULARITY**
▸ Code is divided into classes, and classes into methods

**ENCAPSULATION**
▸ Details can be hidden in classes ▸ This gives rise to information hiding:  ▸ Programmers do not need to know all the details of a class 















