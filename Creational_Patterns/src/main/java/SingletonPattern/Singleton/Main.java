package SingletonPattern.Singleton;
// Thread'i extend etmesi Lazy Singleton örneği için.
public class Main extends Thread{
    public static void main(String[] args) {

        /**
         * Singleton Class Örneği
         */
        Singleton singleton = Singleton.getInstance();
        singleton.printName();

        for (int i = 0; i < 10; i++) {
            Singleton.getInstance().printName();
        }
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if (s1 == s2) {
            System.out.println("The Same Instance");
        }

        System.out.println("***********************************************");

        /**
         * Threaded Lazy Singleton Class Örneği
         * Singleton Class'ta bir instance oluşturduk ve bunu döndük.
         * Bu instance static olduğu için class oluşurken o da oluşuyor. Bu da pahalı bir durum aslında.
         * Olması gereken instance çağırıldığında bunu oluşturmaktır.
         * Bu sebeple ThreadedLazySingleton class'ı gibi bir yapıda oluştururuz.
         * run methodu içinde ThreadedLazySingleton ile çağırılmıştır.
         */

        for (int k = 0; k < 10; k++) {
            new Main().start();
        }
        System.out.println("***********************************************");


        /**
         * Thread Lazy Singleton örneğinde instance'tan farklı thread'lerde çağırıldığı için birdn fazla oluştu.
         * Bu olmaması gereken bir durum.
         * Bunu engellemek için de ThreadSafeLazyLoading class'ında olduğu gibi synchronized anahtar kelimesi kullanılır.
         * Bu şunu sağlar: Bir thread instance'ı çağırdı kullandı. O kullanımını bitirmeden başka bir thread gelip onu alamaz.
         * Thread işini bitirir, sıradaki thread alır ve kullanır.
         * run methodu içinde ThreadSafeLazySingleton ile çağırılmıştır.
         */

        System.out.println("***********************************************");


        /**
         * synchronized performans problemi yaratır. Aslında problem ilk giren bir kaç thread'dir.
         * Bu performans problemini engellemek için double null check kontrolü yapılabilir.
         * DoubleCheckedLockingSingleton class'ında kod üzerinde anlatım bulunmaktadır.
         */
    }
    public void run() {
        /*
        ThreadedLazySingleton threadedLazySingleton = ThreadedLazySingleton.getInstance();
        threadedLazySingleton.printName();
        */
        ThreadSafeLazySingleton threadSafeLazySingleton = ThreadSafeLazySingleton.getInstance();
        threadSafeLazySingleton.printName();

    }
}
