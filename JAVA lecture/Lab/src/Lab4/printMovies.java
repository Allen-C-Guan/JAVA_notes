package Lab4;

public class printMovies {


    //------------------ instance variable --------
    private String [] movlist = {"0","0","0","0","0"};
    private int index = 0;


    public void  inputMovies(String movie){
        movlist[index] = movie;
        index++;
    }

    public void printList(){
        for(int i=0; i< movlist.length; i++){
            System.out.println((i+1)+". "+movlist[i]);
        }
    }
}
