package crazyJavaAccount;

/**
 * Created by G on 2016/5/24.
 */
public class AccountWaitNotify {

    private String accountNo;
    private double balance;
    private boolean flag = false;

    public AccountWaitNotify() {
    }

    public AccountWaitNotify(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void draw(double drawAmount){
        try{
            if (!flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() +"取钱："+drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为：" + balance);
                flag = false;
                notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try{
            if (flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() +"存钱："+ depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为"+balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountWaitNotify that = (AccountWaitNotify) o;

        return accountNo != null ? accountNo.equals(that.accountNo) : that.accountNo == null;

    }

    @Override
    public int hashCode() {
        return accountNo != null ? accountNo.hashCode() : 0;
    }
}
