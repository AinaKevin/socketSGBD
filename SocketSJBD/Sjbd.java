import java.io.*;
import java.util.*;

public class Sjbd {
    public void createtable(String variable) throws IOException // creationbdbd
    {
       File file = new File(variable+".txt");
       BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
       System.out.println(variable);
   }
   public static Vector gettableexistant() throws Exception
   {
    Vector<String> v =new Vector<>();
    Scanner scanner = new Scanner(new File("Tableexistant.txt"));
    while (scanner.hasNextLine()) {
        v.add(scanner.nextLine());
    }
    return v;
   }
   public static void getexisttable(String nomdetable) throws Exception
   {
        Vector<String> vect = gettableexistant();
        for (int i = 0; i < vect.size(); i++) {
            if (vect.get(i).equals(nomdetable)) {
                System.out.println("mande");
            }
        }
   }
    public static Vector insert (String requete) throws Exception{
        Vector<String> rep = new Vector<>();
        String filename = Sjbd.gettable(requete);
        File f = new File(filename+".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(f,true));
        String tableau = Sjbd.gettable(requete);
       String [] tab =Sjbd.getinsert(requete);
       int taille =Sjbd.verifiertailleinsert(tableau);
       if (tab.length==taille) {
            for (int i = 0; i < tab.length; i++) {
                writer.write(tab[i]+" ");
        }
        writer.write(".");
            writer.write("\r\n");
            writer.close();
            rep.add("Une ligne inserer dans la table+");
            System.out.println("Une ligne inserer dans la table+" );
       }
       else{rep.add("erreur lors du sauvegarde : difference de taille d attribut");
        System.out.println("erreur lors du sauvegarde : difference de taille d attribut");}
      return rep;  
    }
    public static String[] getinsert(String requete) throws IOException 
    {
        String [] table = requete.split(" ");
        String [] tbr = table[5].split(",");
        return tbr;
    }
    public static int verifiertailleinsert(String filename) throws Exception
    {
        Scanner scanner = new Scanner(new File(filename+".txt"));  
        String[] tab=scanner.nextLine().split(" ");
        System.out.println(tab.length);
        return tab.length;
    }
    public static String gettable(String requete)
    {
        String [] table = requete.split(" ");
        return table[2];
    }
    public static String getselect(String requete) throws Exception
    {
        String [] tab = requete.split(" ");
        // for (int i = 0; i < tab.length; i++) {
        //     System.out.println(tab[i]);
        // }
        return tab[3];
    }
    public static Vector select (String requete) throws Exception
    {
        String table = getselect(requete);
        String [] resultat =requete.split(" ");
        Scanner scanner = new Scanner(new File(table+".txt"));
        int taille = 0;
        Vector<String> rep = new Vector<>();
        if(resultat[1].equals("*"))
        {
            while(scanner.hasNextLine())
            {
                String p = scanner.nextLine();
                rep.add(p+"\r\n");
                System.out.println(p+"\r\n");
            }
            System.out.println(rep.size());
        }
         else
         {
             String [] tata = resultat[1].split(",");
             int [] indice = new int[tata.length];
             for (int i = 0; i < indice.length; i++) {
               indice[i]=Sjbd.reconnaissance("test",tata[i]);
             } 
             Sjbd.projectionpartable(resultat[3],indice);
         }
        scanner.close();
        return rep;
    }
    public static int getvalueof(Vector<String> vec,String colonne)
    {
        int rep=0;
        for (int i = 0; i < vec.size(); i++) {
            if(vec.get(i)==colonne)
            rep = i;
            break;   
        }
        return rep;
    } 
    public static void getcasename(String filename) throws Exception
    {
        Scanner scanner = new Scanner(new File(filename+".txt"));
        if(scanner.hasNextLine())
           {
                String string = scanner.nextLine();
                System.out.println(string+"\r\n");
                String[] tab = string.split(" ");
                for (int i = 0; i < tab.length; i++) {
                    // System.out.println(tab[i]+"\r\n");
                }
           }
    }
    public static void projection(String filename,String variable)throws Exception
    {
    int a=reconnaissance(filename, variable);
    
        Scanner scanner = new Scanner(new File(filename+".txt"));
        Vector<String> vect= new Vector<>();
        while (scanner.hasNextLine()) {
           String [] tab=scanner.nextLine().split(" "); 
           System.out.println(tab[a]);
        }
    } 
    public static void fonction(String filename,String variable) throws Exception
    {
        Scanner scanner = new Scanner(new File(filename+".txt"));
        String[] tab = scanner.nextLine().split(" ");
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].equals(variable)) {
                System.out.println(i);
            }
        }
    }
    public static int gettailletab(String filename) throws Exception
    {
        Scanner scanner = new Scanner(new File(filename+".txt"));
        String [] taille = scanner.nextLine().split(" ");
        return taille.length;
    }
    public static int reconnaissance(String filename,String variable) throws Exception
    {
        int a=45789;
        Scanner scanner = new Scanner(new File(filename+".txt"));
        String[] tab = scanner.nextLine().split(" ");
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].equals(variable)) {
                a= i;
                break;
            }
        }
        // System.out.println(a);
        return a;
    }
    public static void projectionpartable(String filename,int[]table) throws Exception
    {
        Scanner scanner = new Scanner(new File(filename+".txt"));
        String [] tab=new String[table.length];
        while (scanner.hasNextLine()) {
            tab=scanner.nextLine().split(" ");
            // for (int i = 0; i < table.length; i++) {
            //     System.out.println(tab[table[i]]);
            // }
            System.out.println(tab[2]+" "+tab[1]);
        }
    }
    public static void intersection(String filename,String mot) throws Exception 
    {
        Scanner scanner = new Scanner(new File(filename+".txt"));  
        while (scanner.hasNextLine()) {
            String[]  tab= scanner.nextLine().split(" ");
            for (int i = 0; i < tab.length; i++) {
                if(tab[i].equals(mot))
                {
                    System.out.print("1"+" ");
                    // System.out.println(tab[i]);
                    for (int j = 0; j < tab.length; j++) {
                        System.out.print(tab[j]+" ");
                    }
                   // break;
                }   
            }
        } 
    }
    public static int[] gettailletable(String filename,String filename2) throws Exception
    {
        Scanner scanner = new Scanner(new File(filename+".txt"));  
        Scanner scan= new Scanner(new File(filename2+".txt")); 
        String[] tab=scanner.nextLine().split(" ");
        String[] table=scan.nextLine().split(" ");
        int [] tabl =new int[2];
        tabl[0]=tab.length;
        tabl[1]=table.length;
        return tabl;
    }
    public static void union(String filename,String filename2) throws Exception
    {
        int []tab=gettailletable(filename,filename2);
        Vector<String> vect=new Vector<>();
        Scanner scanner = new Scanner(new File(filename+".txt"));  
        Scanner scan = new Scanner(new File(filename2+".txt"));  
        if(tab[0]==tab[1])
        {
            while (scanner.hasNextLine()) {
                vect.add(scanner.nextLine());
            }
            while (scan.hasNextLine()) {
                vect.add(scan.nextLine());
            }
            for (int i = 0; i <vect.size(); i++) {
                    System.out.println(vect.get(i));
            }
        }
        else{
            System.out.println(" taille differents par rapport au attribut ");
        }
    }
    public static void difference(String filename1,String filename2) throws Exception
     {
        // tsy mety ehhhh 
        Scanner scanner = new Scanner(new File(filename1+".txt"));  
        Scanner scan = new Scanner(new File(filename2+".txt"));
        Vector<String> rep = new Vector<>();
        while (scanner.hasNextLine() && scan.hasNextLine()) {
            String alefa = scanner.nextLine();
            String alefa2 = scan.nextLine();
            String[] tab = alefa.split(" ");
            String[] table = alefa2.split(" ");
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    System.out.println(tab[i]+" "+table[j]);
                }
            }
            // System.out.println(alefa +" "+alefa2);
            }
        }   
     public static void reperazisation(String filename,String repere) throws Exception
     {
        Scanner scanner = new Scanner(new File(filename+".txt"));  
        while(scanner.hasNextLine())
        {
            String[] tab= scanner.nextLine().split(" ");
            // System.out.println("miditra");
            for (int i = 0; i < tab.length; i++) {
                System.out.println("mandedeux");
                if(tab[i].equals(repere))
                {
                    System.out.println("oui jean");
                    break;
                }
            }
        }
     }
     public static void produitCartesienne(){System.out.println("");}
     public static void division(){System.out.println("bina.com razankapoka nestle");}
}   