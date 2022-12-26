
This project is about implementing the Observer design pattern in JAVA on the
UndoableStringBuilder class we created.

![Logo](https://miro.medium.com/max/1200/1*9gplKuyPPPUe8jWjoHrBDg.webp)


## Included Files
* Sender.class - Interface that represents the sender (subject object).
* Member.class - Interface that represents the member (observer object).
* GroupAdmin.class - A class that implements Sender.
* ConcreteMember.calss - A class that implements Member.
* UndoableStringBuilder.class - A class that represents an UndoanleStringBuilder object (Exercise 0).
* GroupAdminTest - Tests for the GroupAdmin' methods.
* ConcreteMemberTest - Tests for the ConcreteMember' methods.
## About Observer
Observer Pattern is one of the behavioral design pattern.

Observer design pattern is useful when you are interested in the state of an object and want to get notified whenever there is any change.

In observer pattern, the object that watch on the state of another object are called Observer and the object that is being watched is called Subject.
## Authors

- [@ShalevBenDavid](https://github.com/ShalevBenDavid)

- [@TairMaz](https://github.com/TairMaz)

## ConcreteMember.class
This class is representing the observer in this design pattern.

Every ConcreteMember has 2 private variables: 
* myStr - UbdoableStringBuilder Object.
* name - String Object.

#### `Constructor`:
Assigns name and creates the UbdoableStringBuilder "myStr".
#### `update()`:
Method that recieves the change (UbdoableStringBuilder object) and shallow-copy it
to "myStr". It also prints that "name" got the update!
#### `getMyStr()`:
Since MyStr is private, we created a getter method.
#### `toString()`:
Returns name.

## GroupAdmin.class
This class is representing the subject in this design pattern.

GroupAdmin has 2 private variables: 
* statesCollection - UbdoableStringBuilder Object.
* members - ArrayList of Members type.

#### `Constructor`:
Assigns statesCollection and creates the ArrayList "members".
#### `notifyObservers()`:
Method that notify each observer in "members" of the change in
"statesCollection" by using the update() method.
#### `getStatesCollection()`:
Since statesCollection is private, we created a getter method.
#### `register(Member obj)`:
Methods to register observers (add them to "members").
if "obj" is already subscribed, we won't add him.
#### `unregister(Member obj)`:
Methods to unregister observers (remove them from "members").
If "obj" is not subscribed, we won't remove him.
#### `insert(int offset, String obj)`:
Method that inserts "obj" string into "statesCollection"
starting from "offset". In case of exception, no changes are made
and so we don't call notifyObservers().
#### `append(String obj)`:
Methods that appends "obj" string to "statesCollection".
#### `delete(int start, int end)`:
Methods to delete from "statesCollection" the substring 
starting at "start" and ending at "end" (not included).
#### `undo()`:
Method to erases the last change done to "statesCollection" and reverts it
to the previous state it was at.
#### `toString()`:
Returns the current "statesCollection" string and "members" list. 
## Tests
![App Screenshot](https://i.ibb.co/LxbtyJB/Screenshot-2022-12-17-at-11-28-54.png)

![App Screenshot](https://i.ibb.co/2Yyws1c/Screenshot-2022-12-22-at-14-02-21.png)
## Tracking resources allocated
In this part, we used the JVMUtilities methods to test and
check the sizes of the objects "observable" of type GroupAdmin,
and "observer1" and "observer2" of type ConcreteMember.

This is an estimate to the efficiancy of the program.

The test file is called "TestResources".
Here are the result we got for our test:
![App Screenshot](https://i.ibb.co/jvGkv86/Screenshot-2022-12-26-at-15-47-19.png)
In the first part (before appending), we see the total size of
"observable" is 752 and of both "observer1" and "observer2"
is 240.

Howerver, in the second part (after appending), we see the total
size of "observable" decreases to 504, and the total size
of both "observer1" and "observer2" increases to 328.

The reason for the decrease is that now each ConcreteMember's
UndoableStringBuilder points to the same location (shallow-copy)
and so the garbage collector cleans their previous UndoableStringBuilder
objects and thus making the ArrayList "members" smaller. Also, a reason for this decrease may be an optimiaztion.

The reason for the increase is that now each ConcreteMember's
UndoableStringBuilder points to a new location of UndoableStringBuilder
object which is larger (since it is appended and has the previous
state).
## Acknowledgements\Bibliography

 - [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)
- [Observer Design Pattern in Java](https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java)
## Feedback

If you have any feedback, please reach out at sliv22000@gmail.com


## 🔗 Links

[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/sliv22000)

[![github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ShalevBenDavid)

[![github](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)]()