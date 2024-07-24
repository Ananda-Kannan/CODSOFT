import java.util.Scanner;
public class project1
 {
    private static final char AI = 'x';
    private static final char PERSON = 'o';
    private static final char EMP = ' ';
    private static char [][] floor = {{emp,emp,emp},{emp,emp,emp},{emp,emp,emp}};
    
    public static void main(String args[])throws Exception
    {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            personturn(scan);
            if(gameOverornot())
            {
                break;
            }
            artiinti();
            if(gameOverornot())
            {
                break;
            }
            printfloor();
        }
        scan.close();
    }
    private static void printfloor()
    {
        System.out.println("----------");
        for(int i=0;i<3;i++)
        {
            for(int k=0;k<3;k++)
            {
                System.out.println("|"+floor[i][k]);
            }
            System.out.println("|");
            System.out.println("----------");
        }
    }  
    private static void personturn(Scanner scan)
    {
        int row,colum;
        while(true)
        {
            System.out.println("Please enter your turn, whether row or column in your choice..");
            row = scan.nextInt()-1;
            colum = scan.nextInt()-1;
            if(row>=0 && row<3 && colum>=0 && colum<3 && floor[row][colum] == emp)
            {
                floor[row][colum] = PERSON;
                break;
            }
            else
            {
                System.out.println("this move is invalid");
            }
        }
    }
    private static void artiinti()
    {
        for(int i=0;i<3;i++)
        {
            for(int k=0;k<3;k++)
            {
                if (floor[i][k] == emp)
                {
                    floor[i][k] = AI;
                    return;
                }
            }
        }
    } 
    private static boolean gameOverornot()
    {
        if(personWonornot(PERSON))
        {
            printfloor();
            System.out.println("YOU WIN..!!");
            return true;
        }
        if(personWonornot(artiinti))
        {
            printfloor();
            System.out.println("AI wins..!!");
            return true;
        }
        if(floorfullornot())
        {
            printfloor();
            System.out.println("game draw!!");
            return true;
        }
       return false;
    }
    private static boolean personWonornot(char person)
    {
        for (int i=0;i<3;i++)
        {
            if(floor[i][0] == person && floor[i][1] == person && floor[i][2] == person)
            {
                return true;
            }
            if(floor[0][i] == person && floor[1][i] == person && floor[2][i] == person)
            {
                return true;
            }
        }
        if(floor[0][0] == person && floor[1][1] == person && floor[2][2] == person)
        {
            return true;
        }
        if(floor[0][2] == person && floor[1][1] == person && floor[2][0] == person)
        {
            return true;
        }
        return false;
    }
    private static boolean floorfullornot()
    {
        for(int i=0;i<3;i++)
        {
            for(int k=o;k<3;k++)
            {
                if(floor[i][j] == EMP)
                {
                    return false;
                }
            }
        }
        return true;
    }

}

