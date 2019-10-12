# Chapter 1
**KEYWORDS  
Chapter 1: Software life cycle, quality, waterfall, types of projects**

## textbook P27 notes  
Software is largely intangible.  
## Notes from slides
SOFTWARE TAXONOMY FOR ESTIMATING PROJECT SIZE  
scope class type  

The process of solving customers’ problems by the systematic development and evolution of large, high-quality software systems within cost, time and other constraints   

An engineering process involves applying well understood techniques in a organized and disciplined way  

Software Objectives:  
It considers the primary goal of the game—delivering working software—and the secondary goal—or residue of the game— setting up for the next game. The next game is altering or replacing the system, or creating a neighboring syste

SOFTWARE CRISIS  
Software crisis is a term used in the early days of computing science (ﬁrst NATO Software Engineering Conference in 1968) for the difﬁculty of writing useful and efﬁcient computer programs in the required time. 
The software crisis was due to the rapid increases in computer power and the complexity of the problems that could not be tackled. With the increase in the complexity of the software, many software problems arose because existing methods were insufﬁcient.

The major cause of the software crisis is that the machines have become several orders of magnitude more powerful! To put it quite bluntly: as long as there were no machines, programming was no problem at all; when we had a few weak computers, programming became a mild problem, and now we have gigantic computers, programming has become an equally gigantic problem. 

THE TERM SOFTWARE ENGINEERING WAS COINED IN 1968   
▸ People began to realize that the principles of engineering should be applied to software development
▸ Engineering is a licensed profession   
▸ In order to protect the public   
▸ Engineers design artifacts following well accepted practices which involve the application of science, mathematics and economics
▸ Ethical practice is also a key tenet of the profession  
▸ In many countries, much software engineering does not require an engineering license, but is still engineering

SOFTWARE ENGINEERING CODE OF ETHICS, WE SHALL…  
▸ Act consistently with public interest   
▸ Act in the best interests of their clients   
▸ Develop and maintain with the highest standards possible  
▸ Maintain integrity and independence  
▸ Promote an ethical approach in management  
▸ Advance the integrity and reputation of the profession  
▸ Be fair and supportive to colleagues  
▸ Participate in lifelong learning  

**SOFTWARE QUALITY**  
USABILITY (USER EXPERIENCE OR UX) SIMPLICITY FAMILIARITY AFFORDANCE FLEXIBILITY  RECOGNITION SAFETY  
RELIABILITY It does what it requires to do without failing  
EFFICIENCY  Reduces waste and maximized things like CPU, I/O, Memory and Throughput  
MAINTAINABILITY  When faced with multiple options, choose the path that makes future change easier  
REUSABILITY   
PRODUCTIVITY   
REPLACEABILITY  
COMPLEXITY  

SOFTWARE QUALITY:
CUSTOMER Solves the problem,  acceptable costs (both $$ and resources)  
USER Easy to learn,  efﬁcient to use,  helps get work done  
MANAGEMENT Sells more,  pleases customers,  costs less to develop and maintain  
DEVELOPER Easy to design,  easy to maintain,  easy to re-use  
COMPLEXITY   REPLACEABILITY  

THE DIFFERENT QUALITIES CAN CONFLICT  
▸ Increasing efﬁciency can reduce maintainability or reusability   
▸ Increasing usability can reduce efﬁciency  
  Setting objectives for quality is a key engineering activity  
 ▸ Design to meet the objectives   
 ▸ Avoids ‘over-engineering’ which wastes money  
 
 SOFTWARE ENGINEERING PROJECTS  
"Legacy code" often differs from its suggested alternative by actually working and scaling.   

MOSTLY EVOLUTIONARY OR MAINTENANCE PROJECTS  
CORRECTIVE  ADAPTIVE  REENGINEERING   ENHANCEMENT    
ENHANCEMENT PROJECTS  
CORRECTIVE PROJECTS
▸ Fixing defects  
▸ No active work  
▸ “Maintenance mode”  
▸ Eventually Adaptive work required  

CASE STUDY SITEVALET.COM 
▸ Hotel CRM (Customer Relationship Manager)
▸ Active Development from 2006 - 2008
▸ Maintenance Mode afterwards
▸ Ruby on Rails 2.3,
▸ Ubuntu 8.04,
▸ Ruby 1.8.6

SITEVALET “MAINTENANCE”
▸ Manually clean logs every 3 months
▸ Manually reboot when image server got stuck
▸ 2 hours of maintenance PER YEAR
▸ Lasted 8 years, until it was ﬁnally decommissions

ADAPTIVE PROJECTS  
▸ Changing the system in response to changes in  
▸ Operating system ▸ Database  
▸ Rules and regulations  
▸ Examples, adapting your project for ▸ TLS 1.2 support ▸ PHP 7 support ▸ Ubuntu 18.04 support ▸ Stripe V3 support  

REENGINEERING OR  PERFECTIVE PROJECTS  
▸ Changing the system internally so it is more maintainable  
▸ Examples, ▸ Moving from AWS to Azure  
▸ Moving from Monolith to Microservices   
▸ Moving from Micro services back to Monolith 57  

‘GREEN FIELD’ PROJECTS
NEW NEW and RARE and MINORITY and BECOMES MAINTENANCE   

Projects ACTIVITIES 
REQUIREMENTS   
▸ Domain analysis   
▸ Deﬁning the problem  
▸ Requirements gathering  
▸ Obtaining input from as many sources as possible  
▸ Requirements analysis  
▸ Organizing the information  
▸ Requirements speciﬁcation  
▸ Writing detailed instructions about how the software should behave  

REQUIREMENTS AS A SALES PITCH

DESIGN
▸ Deciding how the requirements should be implemented, using the available technology  
▸ Includes:    
▸ Systems engineering: Deciding what should be in hardware and what in software   
▸ Software architecture: Dividing the system into subsystems and deciding how the subsystems will interact   
▸ Detailed design of the internals of a subsystem    
▸ User interface design   
▸ Design of databases   

MODELING 
▸ Creating representations of the domain or the software  
▸ Use case modeling  
▸ Structural modeling   
▸ Dynamic and behavioural modeling  

PROGRAMMING
▸ Test Driven Development ▸ Test Last ▸ Test Never ▸ Refactoring ▸ Integration   
▸ Paired Programming ▸ Mob Programming ▸ Code Review ▸ Pull Requests ▸ Trunk Base versus Feature Based Dev  

MANAGING THE PROCESS ▸ Project Management ▸ Product Management ▸ Operations (“DevOps”)  

Requirements->1Design->Implementation->IntegrationTesting->2Installation,Oeration->3Phase-out  
1.If"bugs"found,go back correct artefacts 2.includes maintenance 3.All software is eventually  decommissioned.    

ROYCE’S FIVE STEPS  
1. Program Design Comes First  
2. Document the Design  
3. Do it Twice  
4. Plan, Control and Monitor Testing  
5. Involve the Customer  
Avoids ivory tower architectures and analysis that simply cannot be efﬁciently implemented  
Before code there is still design, and important things are written down  
“Plan to throw ﬁrst version away” (Brook’s Mythical man month)  
Early and incremental testing.  Software is ultimately about automation, so we should dog food that with testing.  
Something lacking in typical Waterfall  

ITERATIVE AND INCREMENTAL   
IMPLEMENT / TEST 1-> (2)IMPLEMENT / INTEGRATE / TEST ->3 OPERATIONS  
1.First Release 2.Subsequent Releases 3.Production Release  
Maintenance / Testing(3rd to 2nd)  
Design broken down into standalone “builds”(2nd)  
First release should be “no-op” to get build pipeline setup(1st)  
A build “tagged” for release, otherwise identical to any other build(3rd)   

TIMELINES  
Inception(1)Elaboration(2,3)Construction(4,5,6)Transition(7,8)   
1.Internal (1)2.release Minor milestones(2) 3. First “external”release (beta)6) 4.Final release(8)   



