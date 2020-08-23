public class TestSeven extends Thread
{
    private static int x;
    public synchronized void doThings()
    {   
        int curr = x;
        curr++;
        x = curr;
    }

    public void run()
    {
        doThings();
            }


}