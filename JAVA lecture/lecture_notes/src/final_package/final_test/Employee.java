package final_package.final_test;

public class Employee {
    //不能总忘private
    private String name;
    private int ID;
    private String position;
    private double wage;

    public Employee(String name, int ID, String position, double wage) {

        this.name = name;
        this.ID = ID;
        this.position = position;
        this.wage = wage;
    }

    public double salary(double hours) {
        if (hours <= 40) {
            return 40 * wage;
        } else {
            return 40 * wage + (hours - 40) * wage * 1.5;
        }
    }

    public void raise(double r) throws Exception {

        if (r <= wage) {
            wage = wage + r;
        } else {
            throw new Exception();
        }
    }
    public static void main(String[] args) throws Exception {
        //如果调用的函数有可能会扔出exception 的时候，你也需要在当前函数增加exception

        Employee e = new Employee("allen",45345,"adfa",89);
        e.raise(7);
    }


}

