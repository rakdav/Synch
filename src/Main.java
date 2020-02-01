public class Main
{
    public static void main(String[] args) {
        CommonResourse commonResourse=new CommonResourse();
        for(int i=1;i<6;i++)
        {
            Thread t=new Thread(new CountThread(commonResourse));
            t.setName("Thread "+i);
            t.start();
        }
    }
}
class CommonResourse{
    int x=0;
}
class CountThread implements Runnable
{
    CommonResourse res;

    public CountThread(CommonResourse res) {
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res) {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d\n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
