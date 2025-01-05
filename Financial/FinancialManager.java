package Financial;

import java.util.ArrayList;
import java.time.LocalDate;
public class FinancialManager {
    public double totalMoney;
    double totalMonthlyMoney;
    double totalDailyMoney;
    public ArrayList<Store> transactions;
    public void addTransaction(Store store) {
        transactions.add(store);
    }
    public FinancialManager(double initalMoney){
        this.totalMoney = initalMoney;
        this.transactions = new ArrayList<>();
    }
    public void addMoney(double m, String note) {
        this.totalMoney = this.totalMoney + m;
        this.transactions.add(new Store(m, "收入", note, "这次收入", LocalDate.now()));
    }
    public void reduceMoney(double m, String note, String category){
        if(category.equalsIgnoreCase("娱乐")){
             new FunAmount().addFunAmount(m, note);
             this.totalMoney = this.totalMoney - m;
        }
        this.totalMoney = this.totalMoney - m;
        this.transactions.add(new Store(-m, "支出", note, category, LocalDate.now()));
    }
    public double getTotalDailyMoney(){
        LocalDate today = LocalDate.now();
        for (Store trans : this.transactions){
            if(trans.getDate().equals(today.toString())){
                totalDailyMoney += trans.storeAmount;
            }
        }
        return totalDailyMoney;
    }
    public double getTotalMonthlyMoney(){
        // get lastmonth's money
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfLastMonth = today.minusMonths(1).withDayOfMonth(1); // 上个月的第一天
        LocalDate lastDayOfLastMonth = today.minusMonths(1).withDayOfMonth(today.minusMonths(1).lengthOfMonth()); // 上个月的最后一天

        for (Store trans : transactions) {
            LocalDate transDate = trans.getDate();
            if (!transDate.isBefore(firstDayOfLastMonth) && !transDate.isAfter(lastDayOfLastMonth)) {
                totalMonthlyMoney += trans.storeAmount;
            }
        }
        return totalMonthlyMoney;
    }
    public class FunAmount{
        double totalFunAmount;
        double monthlyFunAmount;
        public void addFunAmount(double m, String note){
            this.totalFunAmount = this.totalFunAmount + m;
            FinancialManager.this.transactions.add(new Store(m, "支出", note, "娱乐", LocalDate.now()));
            //内部类不可以直接访问外部类的非静态属性
        }
    }
}
