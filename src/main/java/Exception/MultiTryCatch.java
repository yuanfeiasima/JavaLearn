package Exception;

/**
 * Created by G on 2016/12/3.
 */
public class MultiTryCatch {

    public static void main(String[] args) throws Exception{
        try{
            try{
                throw new Sneeze();
            }catch(Annoyance annoyance){
                System.out.println("caught Annoyance");
                throw annoyance;
            }
        }catch(Sneeze s){
            System.out.println("caught sneeze");
            return;
        }finally {
            System.out.println("Hello World");

        }

    }
}
