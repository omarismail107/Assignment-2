# Assignment-2

Part 1:
Summary/Proof:
maze.java implements the solution discussed in class to the prisoner problem and the solution discussed in the following video: https://www.youtube.com/watch?v=ZmaeljnPOu4&ab_channel=TED-Ed . The solution is to have one thread as the main thread who will ultimately decide when the rest of the threads have gone through the maze. The thread accomplishes this task by checking whether the cupcake has been taken when they enter the maze. If the cupcake is taken, then that means that one of the other guests that has never been in the maze before has taken the cupcake. If the cupcake is not taken however, no guest that hasn't previously been in the maze has taken the cupcake. One constraint that allows this to work is that the guests going into the maze should only take the cupcake if they haven't previously been in the maze before. When the main thread keeping track of how many cupcakes were taken counts the number of cupcakes eaten equal to the total number of guests, they tell the minotaur that everyone has entered the maze.

Experimental Evaluation:
I tested the program on various inputs ranging from 1 guest to 300 guests and allowed for the user to run the program using this range of numbers.

How to compile:
First command: javac maze.java
Second command: java maze

![image](https://user-images.githubusercontent.com/75344828/156865644-61ace078-358a-491b-9841-841b0835bcd4.png)

