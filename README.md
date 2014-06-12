Conways-Game-of-Life
====================

Simple game of life written in Java

**Window class contains the main() function**

Classes and relevent fucntions:

1. Window: JFrame with (double) buffered rendering

2. RenderManger: Runnable threaded class, offers graphics object for other classes to draw to. 
Run() draws the graphics object to an image to another graphics object (for the window).

3. Game: Contains the board, and relevent functions to modify
Life() runs the next generation code for the board using CGOL rules
Initialize() for the game can either create already known patterns, or a randomized board

4. GameLoop - Runnable threaded class, runs along side RenderManger, each in its own thread
Limits gameloop speed to the FPS variable

5. Keyboard and Mouse - adapters added to the window to handle keyboard and mouse input
