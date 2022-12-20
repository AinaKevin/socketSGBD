import java.io.File;
import java.io.IOException;
import java.util.Scanner; 
public class Main
{
  //Select *from test 
    public static void main(String[] args) throws Exception {
      int[] tab = {2,0,1};
        // Scanner scan =  new Scanner(System.in);
        // String z=scan.nextLine();
        // String [] resultat = z.split(" ");
        // try {
        //   if( resultat[0].equals("Select") && resultat[2].equals("from"))
        //   {Sjbd.select(z);}
        //   if (resultat[0].equals("insert")){
        //     {Sjbd.insert(z);}
        //   }
        // } catch (Exception e) {
        // }
        // Sjbd.reconnaissance("test","crying");
        // Sjbd.projectionpartable("test",tab);
        // Sjbd.union("test","jean");
        Sjbd.difference("donne1","donne2");
    }  
}