package Lab5;

public class Movie {

    /*
    这个地方，如果immutable 必须要让所有的东西都是imutable，其中var能是final就是final，method能private就private的，能是private就是private！！
     */
    private final String title;
    private final int rank;
    private final int run_time;

    public Movie(String title, int rank, int run_time){
        this.title = title;
        this.rank = rank;
        this.run_time = run_time;
    }



    @Override
    public String toString(){
        return this.rank + this.title;
    }

    public boolean equals (String title, int rank, int run_time){
        return title==this.title&&this.rank ==rank && this.run_time == run_time;
    }





    /**
     * accessor
     */

    public String getTitle(){
        return this.title;
    }

    public int getRank(){
        return this.rank;
    }

    public int getRun_time(){
        return this.run_time;
    }
}
