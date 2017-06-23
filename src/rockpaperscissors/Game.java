/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author A613431
 */
public class Game {
    public void start() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean played = false;
        while(true)
        {             
                if(played == true)
                {
                    System.out.println("Grasz dalej? Y/N");

                    String playAgain = br.readLine();       
                    if("N".equals(playAgain) || "n".equals(playAgain))
                    {
                        break;
                    }
                    if(!"Y".equals(playAgain) && !"y".equals(playAgain))
                    {
                        System.out.println("Niewłaściwa odpowiedź");
                        continue;
                    }
                    else
                    {
                        played = false;
                    }                   
                }
                System.out.println("Wybierz figurę \n1) Kamień\n2) Papier\n3) Nożyce\n4) Wyjście");
                try{
                    String chosen = br.readLine();
                    int chosenInt = 6; 
                    try{                       
                    chosenInt = Integer.parseInt(chosen);
                    }                  
                    catch(NumberFormatException e)                              
                    {
                        System.out.println("Niewłaściwa odpowiedź");  
                        continue;
                    }
                    if (chosenInt == 4)
                    {
                        break;
                    }
                    
                System.out.println(play(chosenInt));
                played = true;
                }
                catch(IOException e)
                {
                    System.out.println("Wprowadzono nieprawdłową wartość");
                }
            }                        
        }
        
    private String play(int chosen)
    {
        Random r = new Random();
        int drawn = r.nextInt(3)+1;
        if(drawn == 1)
            System.out.println("Przeciwnik wybrał kamień");
        if(drawn == 2)
            System.out.println("Przeciwnik wybrał papier");
        if (drawn == 3)
            System.out.println("Przeciwnik wybrał nożyczki");
        String result = "";
        if(chosen > 4 || chosen < 0)
           result = "wprowadzono niewłaściwą wartość";
        if(chosen == 1)
            result = rock(drawn);
        if(chosen == 2)
            result = paper(drawn);
        if(chosen == 3)
            result = scissors(drawn);
        return result;
    }
    
    private String rock(int drawn)
    {
        if(drawn == 2)
            return "Przegrałeś";
        if(drawn == 3)
            return "Wygrałeś";
        if(drawn == 1)
            return "Remis";
        return "cokolwiek";
    }
        private String paper(int drawn)
    {
        if(drawn == 3)
            return "Przegrałeś";
        if(drawn == 1)
            return "Wygrałeś";
        if(drawn == 2)
            return "Remis";
        return "cokolwiek";
    }
            private String scissors(int drawn)
    {
        if(drawn == 1)
            return "Przegrałeś";
        if(drawn == 2)
            return "Wygrałeś";
        if(drawn == 3)
            return "Remis";
        return "cokolwiek";
    }
    

}
