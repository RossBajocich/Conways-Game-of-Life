Conways-Game-of-Life
====================

Simple game of life written in Java

**Window class contains the main() function**

Classes:

Window: JFrame with (double) buffered rendering
RenderManger: Runnable threaded class, offers graphics object for other classes to draw to. 
  - Run() draws the graphics object to an image to another graphics object (for the window).
Game: Contains
  - Life() runs the next generation code for the board using CGOL rules
  - Initialize() for the game can either create already known patterns, or a randomized board
GameLoop - Runnable threaded class, runs along side RenderManger, each in its own thread
  - Limits gameloop speed to the FPS variable
Keyboard and Mouse - adapters added to the window to handle keyboard and mouse input
