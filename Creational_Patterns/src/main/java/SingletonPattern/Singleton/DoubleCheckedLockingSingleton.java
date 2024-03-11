package SingletonPattern.Singleton;

public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton singleton;
    /**
     * volatile olma sebebi : threadler ana memory'den objeyi alır ve kendi localinde kullanır. Ana memory'de obje null'dır.
     * Thread objeyi örneğin birinci saniyede null durumdan çıkardı ve işi bitti. Bunu ana memory'ye geri göndermesi lazım.
     * Ana memory'deki obje hala null iken thread1'in işi bittiği için thread2 devreye girer. thread1 objeyi ana memory'ye henüz gönderemeden thread2 null objeyi yakalar.
     * Küçük bir ihtimal de olsa böyle bir durum yaşanması olasıdır.
     * Bunu engellemek için volatile kullanılır.
     * volatile, sychronized içinden thread çıkmadan objenin null olmadığını bildirmeye yarar. Henüz daha ana memory'ye göndermeden yani, bu obje null değil der.
     */

    private static int count = 0;
    private String name;

    private DoubleCheckedLockingSingleton () {
        count++;
        name = "Thread Safe Lazy Singleton" + count;
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        /**
         * Burada ilk olarak gelen threadlerde null değer olup olmadığı kontrol edilir.
         * Örneğin ilk 10 threadilk if'i atlayıp synchronized kısma girer.
         * Onlar böyle sırayla çalışırlar.
         * Ama mesela 11. thread geldiğinde zaten singleton null olmadığı için if'e girmez ve direkt return'e döner.
         * Bu da bize tüm thread'ler için beklemek yerine, sadece singleton'ı ilk başta null yakalayan thread'leri bekleriz.
         * Ve zamandan tasarruf etmiş oluruz.
         */
        if (singleton == null) {
            synchronized (ThreadSafeLazySingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return singleton;
    }

    public void printName () {
        System.out.println(name);
    }
}
