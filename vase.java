import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class vase
{
	public static BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
	public static AtomicInteger numEntered = new AtomicInteger();

	public static class myThread extends Thread
	{
		public int threadID;
		public boolean enteredBefore = false;

		public static Lock lock = new ReentrantLock();

		public myThread (int id)
		{
			this.threadID = id;
		}

		public void run()
		{
		while (2 == 2)
		{			
			try
			{
				if (this.threadID == 0)
					try{
						q.take();
					} catch (Exception e){

					}
					
				else
					q.add(this.threadID);
				


			} 
			finally
			{
				if (this.threadID != 0 && !enteredBefore)
				{
					numEntered.getAndIncrement();
					this.enteredBefore = true;
					System.out.println(this.threadID + " has seen the vase for the first time!");
				}

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

		int time = 0;

		while (flag == true)
		{
			System.out.print("Please input the amount of time the party will take (1 - 4) seconds: ");
			time = Integer.parseInt(in.next());
			if (time > 4 || time < 1)
				System.out.println("Minotaur is unhappy with your input");
			else
				flag = false;

			System.out.println();
		}

		myThread threads[] = new myThread[numGuests + 1];

		for (int i = 0; i <= numGuests; i++)
		{
			threads[i] = new myThread(i);
			threads[i].start();
		}

		long start = System.currentTimeMillis();
		long end = start + (time * 1000);

		while (System.currentTimeMillis() < end)
		{

		}

		for (myThread thread : threads)
		{
			thread.interrupt();
		}

		System.out.println(numEntered + " out of the " + numGuests + " guests have seen the vase by the end of the party!");
		System.exit(0);
		

	}
}