package Lab6;

public class Movie2 {


    private String title;
    private int rank;
    private int run_time;

    public Movie2(String title, int rank, int run_time){
        this.title = title;
        this.rank = rank;
        this.run_time = run_time;
    }

    public Movie2(Movie2 m){
        this.title = m.title;
        this.rank = m.rank;
        this.run_time = m.getRun_time();
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
