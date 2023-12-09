
- initiated an instance for both ShapeAlbum, and snapshot class.
- added getters method to retrieve the instance.
- added a hashMap in ShapeAlbum and corresponding method to get the map


Below is the README file for hw8

This application is designed to manage a collection of shapes and take snapshots
of their states.

Components:

IShape Interface:
Defines the contract for shapes in the application.
Includes the resizing method

AbstractShape Class:
Provides common methods for shapes. Implements resize method from IShape
and declares abstract methods for specific shape behaviors.

Concrete Shape Classes (Rectangle, Oval, Triangle):
Implementations of different shapes. Extend AbstractShape and provide
specific behavior for each shape type. Each class overrides abstract methods
from AbstractShape and provides shape-specific logic.

ShapeAlbum Class:
Manages a collection of shapes and snapshots of their states. Has the ability
to add/remove shapes, take snapshots, retrieve snapshots, and list current shapes.

Snapshot Class:
Represents a snapshot of the shapes' state at a specific moment.
Stores a collection of shapes and a timestamp.
Provides methods to get snapshot details and a string representation.

RGBColor Class:
Represents colors in RGB format. Stores red, green, and blue components.
Provides methods to get/set color values.