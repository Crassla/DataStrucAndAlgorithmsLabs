/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercise3_3;

/**
 *
 * @author alex
 */
public class JosephusQueue
{

    protected int remNum;
    protected ArrayQueue<Integer> josephusQueue;

    public JosephusQueue(int soldiers, int remNum)
    {
        this.josephusQueue = new ArrayQueue<>();
        this.remNum = remNum;

        System.out.println("ADDING THESE SOLDIERS");
        for (int i = 1; i <= soldiers; i++)
        {
            josephusQueue.enqueue(i);
            System.out.print(i + ((i == soldiers) ? "\n" : ", "));
        }
    }

    public void josephusProblem()
    {
        int i = 1;

        while (josephusQueue.isEmpty() == false)
        {
            if (i % remNum == 0)
            {
                if (josephusQueue.size() == 1)
                {
                    System.out.println("THE LAST SOLDIER STANDING IS >>: " + josephusQueue.first());
                }
                else
                {
                    System.out.println("REMOVING SOLDIER >>: " + josephusQueue.first());
                }
                josephusQueue.dequeue();
            }
            else
            {
                int temp = josephusQueue.dequeue();
                josephusQueue.enqueue(temp);
            }

            i++;
        }
    }
}
