# Assignment3 by Hao Tran and Daniel Tellez

**Purpose:**  <br>
  In this assignment, you will design and build a program that stores an arbitrary
  sequence of commands that manipulates and uses a drawing list. A drawing list is used
  to produce a graphical scene, e.g., [create a red rectangle, move it to coordinates (5,5),
  create a blue triangle, move it to coordinates (10,2), draw the red rectangle, draw the
  blue triangle]. While it would be fun to actually draw the shapes that we will store and
  manipulate in our list, we shall instead focus only on the creation and maintenance of
  the drawing list. NOTE: actually implementing drawing via JavaFX is worth 10 bonus
  pts.
  
  
## Design Patterns Used:
* Command Pattern - Our Command Pattern implementation included the following classes:<br>
  * ProcessFile.java - The Client class that will responsible for creating the Invoker and creating the new commands.
  * ShapeInvoker.java - The Invoker class that is responsible for storing and executing the commands for the shapes.
  * Shape.java - The receiver class that defines the methods/commands used by a shape.
  * Command.java - The abstract Command class that defines the default method, execute(), used by all subcommands. Commands include:
    * ColorCommand.java - Command that changes the shapes color.
    * CreateCommand.java - Command that is responsible for creating a new Shape subclass.
    * DeleteCommand.java - Command that "deletes" a shape from the drawinglist.
    * DrawCommand.java - Command that prints/draws the contents of a shape.
    * DrawSceneCommand.java - Command that draws all shapes from the drawinglist.
    * MoveCommand.java - Command that changes the coordinates of a given shape.
    * SelectCommand.java - Command that selects and sets the current shape being used.
    
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
* Memento Pattern -  Our Menemto Pattern implementation included the following classes:
  * Memento.java -  gets a snapshot of originator state (shapeType, color, xCord, yCord, isAlive, isSelected).
  * Originator.java - Keeps shapes internal state that we want to save to return to later.
  * Caretaker.java - keeps track of multiple memento(saved states), so that whenever a shape needs to go back to a previous state it has the infomation to do so.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

* Strategy Pattern - Our Strategy Pattern implementation included the following classes:
  * Shapes.java - This class contains instance variables and methods(commands) that every shape should have. Groups and encapsulates behavior that the subclasses have.
  * Rectangle.java - The Rectangle class inherits every method from the Shapes.java class but has its own stategy(behavoir) to draw the shape since a rectange contains a width       and height while some others do not. 
  * Circle.java - The Circle class inherits every method from the Shapes.java class but has its own stategy(behavior) to draw the shape since a Circle contains a radius while     some others do not. 
 
    
  
       
