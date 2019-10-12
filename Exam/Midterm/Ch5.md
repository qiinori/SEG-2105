# Chap5 MODELING WITH CLASSES 
key:  
attributes, associations, code-generation, system model vs domain model, 
reflexive associations, association classes, composition, multiplicity, operation, directionality.
## [Slides](#slides)
## [Textbook](#text)

### Slides
**The Unified Modeling Language**
a standard visual modeling language intended to be used for 
modeling business and similar processes,analysis, design, and implementation of software-based systems  
can be applied to diverse application domains (e.g., banking, finance, internet, aerospace, healthcare, etc.) 
It can be used with all major object and component software development methods and for various implementation platforms (e.g., J2EE, .NET). 
UML is a standard modeling language, not a software development process  
UML is intentionally process independent and could be applied in the context of different processes. Still, it is most suitable for use case driven, iterative and incremental development processes. An example of such process is Rational Unified Process (RUP).

**CLASS DIAGRAMS  
SEQUENCE DIAGRAMS (INTERACTIONS  
COMMUNICATION DIAGRAMS (INTERACTIONS)  
STATE DIAGRAMS  
ACTIVITY DIAGRAM  
COMPONENT DIAGRAMS  
DEPLOYMENT DIAGRAM**

CLASS DIAGRAMS:
Associations
Attributes
Classes Operations
Generalizations


**ASSOCIATIONS VERSUS GENERALIZATIONS IN OBJECT DIAGRAMS**
▸ Associations describe the relationships that will exist between instances at run time.  ▸ When you show an instance diagram generated from a class diagram, there will be an instance of both classes joined by an association 
▸ Generalizations describe relationships between classes in class diagrams.  ▸ They do not appear in instance diagrams at all.  ▸ An instance of any class should also be considered to be an instance of each of that class’s superclasses  

WHEN TO USE AN AGGREGATION ▸ You can state that ▸ the parts ‘are part of’ the aggregate ▸ or the aggregate ‘is composed of’ the parts  ▸ When something owns or controls the aggregate, then they also own or control the parts 

PROPAGATION IS TO AGGREGATION … ▸ as inheritance is to generalization ▸ The major difference is: ▸ inheritance is an implicit mechanism ▸ propagation has to be programmed when required 

**OCL OBJECT CONTRAINT LANGUAGE**
An assertion is a predicate (a Booleanvalued function) connected to a point in the program, that always should evaluate to true at that point in code execution.
A constraint is a restriction on one or more values of (part of) an object-oriented model or system
OCL EXPRESSION  
Logical fact (constraint) about the system Invariant must always remain true, always.
OCL CAN SPECIFY VALUES OF ATTRIBUTES AND ASSOCIATIONS
OCL STATEMENTS CAN BE BUILT FROM 
▸ References names ▸ Roles, ▸ Associations,  ▸ Attributes ▸ Operation Results ▸ The logical values  ▸ true and  ▸ false 
▸ Logical operators ▸ and / or ▸ = / <> (not equals) ▸ > / >= / < / <= ▸ Strings like “O’Doyle Rules” ▸ Integers and real numbers ▸ Arithmetic operations *, /, +, - 
WHERE TO USE OCL IN UML
Invariants for stereotypes
Pre/Post conditions
Invariants on classes and types Guards Navigation   Language Constraints on Operations

REUSE SHOULD ALWAYS BE A CONCERN ▸ Frameworks ▸ System extensions ▸ Similar systems

DISCOVERING DOMAIN CLASSES ▸ Source material like description of requirements ▸ Extract nouns ▸ Eliminate nouns that: ▸ Redundant ▸ Too speciﬁc (represent instances) ▸ Too vague (or highly general) ▸ Outside application scope ▸ Pay attention to classes that represent types of actors

IDENTIFYING ASSOCIATIONS AND ATTRIBUTES ▸ Start in the middle (most central classes) ▸ Decide on obvious  ▸ data those classes must contain ▸ Relationships to other classes ▸ Work outwards ▸ Avoid over-doing it

AN ASSOCIATION SHOULD EXIST IF A CLASS … SOME OTHER CLASS ▸ possesses ▸ controls ▸ is connected to ▸ is related to ▸ is a part of ▸ has as parts ▸ is a member of, or ▸ has as members
145
▸ Specify the multiplicity at both ends ▸ Label it clearly

**IDENTIFYING ATTRIBUTES** ▸ Information that must be maintained about each class ▸ Nouns rejected as classes ▸ Generally contain simple values, or a set of simple values ▸ String, Number, Boolean ▸ Address (several strings)

IDENTIFYING GENERALIZATIONS Bottom-up ▸ Group together similar classes creating a new superclass  Top-down ▸ Look for more general classes ﬁrst, specialize them if needed

ALLOCATING RESPONSIBILITIES TO CLASSES A responsibility is something that the system is required to do. 

**CATEGORIES OF RESPONSIBILITIES**
Initializing  Objects
CRUD
Setter / Getter Managing Associations
Data Transformation
Navigation and Searching

**RESOLUTION** ▸ Adequate training  ▸ Experienced modeler as team member ▸ Review all models thoroughly 

### text






