# Assignment-2

Part 1:
Summary/Proof:
maze.java implements the solution discussed in class to the prisoner problem and the solution discussed in the following video: https://www.youtube.com/watch?v=ZmaeljnPOu4&ab_channel=TED-Ed . The solution is to have one thread as the main thread (this thread is thread 2 in output) who will ultimately decide when the rest of the threads have gone through the maze. The thread accomplishes this task by checking whether the cupcake has been taken when they enter the maze. If the cupcake is taken, then that means that one of the other guests that has never been in the maze before has taken the cupcake. If the cupcake is not taken however, no guest that hasn't previously been in the maze has taken the cupcake. One constraint that allows this to work is that the guests going into the maze should only take the cupcake if they haven't previously been in the maze before. When the main thread keeping track of how many cupcakes were taken counts the number of cupcakes eaten equal to the total number of guests, they tell the minotaur that everyone has entered the maze.

Experimental Evaluation:
I tested the program on various inputs ranging from 1 guest to 300 guests and allowed for the user to run the program using this range of numbers.

How to compile:
First command: javac maze.java
Second command: java maze

Output:
![image](https://user-images.githubusercontent.com/75344828/156865644-61ace078-358a-491b-9841-841b0835bcd4.png)

Part 2:

Advantages/Disadvantages:


Solution 1:
Advantages:
Guest can potentially complete other tasks while waiting to enter the showroom.


Disadvantages: 
A guest that wants to see the vase would have no guarantee of entering the showroom.
A guest can potentially be waiting for long periods of time in order to enter the showroom.

Solution 2:
Advantages: 
Needs less space than other solutions


Disadvantages:
Guest would constantly have to look at a sign in order to see whether showroom is available or busy. 
Takes more time than solution 3

Solution 3:
Advantages:
Faster than all other solutions.
No potential for deadlocking.
Small size for space


Disadvantages:
The queue to enter the showroom may be particularly long in some cases.
Some queue algorithms don't work well with NUMA architectures.

Summary/Proof:
In vase.java, I ultimately decided to use a queue over the other strategies. I implemented this queue by allowing any thread that wanted to enter the queue to enter. I had one designated thread dequeueing the items from the blocking queue and displaying that they had left the showroom. This made the solution possible of only having one thread/guest inside the showroom looking at the vase at all times.

Output:
![image](https://user-images.githubusercontent.com/75344828/156865755-a701b547-71cd-43bd-8ad7-f501eff9b5e8.png)

