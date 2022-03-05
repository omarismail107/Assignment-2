import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class maze
{
	public static AtomicBoolean cupcake = new AtomicBoolean(false);
	public static int numEntered = 0;
	public static Lock lock = new ReentrantLock();
	public static int total;

	public static class myThread extends Thread
	{
		public static boolean finished = false;
		public int threadID;
		public boolean takenCupcake = false;
		public boolean started = false;

		public myThread (int id)
		{
			this.threadID = id;
		}

		public void run()
		{
			while (!finished)
			{
				lock.lock();

				try
				{
					if (total == 1)
						finished = true;
					

					if (threadID == 1 && !cupcake.get())
					{
						cupcake.set(true);
						numEntered++;

						if (numEntered == total)
						{
							finished = true;
						}
					}

					else if (!this.takenCupcake && cupcake.get())
					{
						this.takenCupcake = true;
						cupcake.set(false);
						System.out.println((this.threadID + 1) + " has entered the maze for the first time!");
						System.out.println();
					}
				} finally
				{
					lock.unlock();
				}
			}
		}
	}

	public static void main (String [] args)
	{
		Scanner in = new Scanner(System.in);
		int numGuests = 1;
		boolean flag = false;

		while (flag == false)
		{
			System.out.print("Please input the number of guests (1 - 300): ");
			numGuests = Integer.parseInt(in.next());
			if (numGuests < 1 || numGuests > 300)
				System.out.println("Minotaur is unhappy with your input");
			else
				flag = true;
			System.out.println();
		}

		total = numGuests;

		myThread threads[] = new myThread[numGuests];

		for (int i = 0; i < numGuests; i++)
		{
			threads[i] = new myThread(i);
			threads[i].start();
		}
		
		for (myThread thread : threads)
		{
			try
			{
				thread.join();
			}
			catch(Exception e)
			{

			}

		}

		System.out.println("All " + numGuests + " Guests Have Entered The Maze!");

	}
}