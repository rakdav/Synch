public class Store
{
    private int product=0;
    public  synchronized void get()
    {
        while (product<1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            product--;
            System.out.println("покупатель купил 1 товар");
            System.out.println("Количество товаров на складе "+product);
            notify();
    }
    public  synchronized void put()
    {
        while (product>=3)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Количество товаров на складе "+product);
        notify();
    }

}
