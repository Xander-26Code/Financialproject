package Financial;

import java.time.LocalDate;

public class Store {
    String type;
    String note;
    double storeAmount;
    String category;
    LocalDate date;
    public Store(double storeAmount, String type, String note, String category, LocalDate date){
        this.storeAmount = storeAmount;
        this.date = date;
        this.type = type;
        this.category = category;
        this.note = note;
    }
    public LocalDate getDate(){
        return date;
    }
    @Override
    public String toString() {
        return "类型: " + type + ", 金额: " + storeAmount + ", 分类: " + category + ", 日期: " + date + ", 备注: " + note;
    }
    //重写toString()方法，让输出的时候可以令人们读懂，而不是输出是类似 Transaction@1a2b3c 的内存地址
}
