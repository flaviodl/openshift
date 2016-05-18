public class Tris
{

  // Metodo Costruttore
  // Creo una matrice 3*3 vuota
  public Tris()
  {
    board = new String[rows][columns];
    for(int i=0; i<rows; i++)
      for(int j =0; j<columns; j++)
      {
          board[i][j] = " ";
      }
  }

  // Metodo che restituisce lo stato della matrice
  public String tostring()
  {
    String r = "";
    for(int i=0; i<rows; i++)
    {
        r = r + "|";
        for (int j=0; j<columns ; j++)
          r=r + board[i][j];
        r = r + "|\n";
    }
    return r;
  }

  // Metodo che permette di inserire una giocata
  public void set(int i, int j, String player)
  {
      if(board[i][j] != " ")
      {
        throw new IllegalArgumentException("Posizione occupata");
      }
      board[i][j] = player;
  }

  // Metodo che restituisce il nome del giocatore vincitore
  public String getWinner()
  {
    int k = 0;
    int h = 0;
    // Verifico se il tris è presente in una riga
    for(int i=0; i<rows; i++)
    {
        for (int j=0; j<columns ; j++)
        {
          if(board[i][j]== "x")
          {
            k++;
            if(k==3){ return " VINCE IL GIOCATORE X "; }
          }
          else
          {
             if(board[i][j] == "o")
             {
                h++;
                if(h==3){ return " VINCE IL GIOCATORE O "; }
             }
          }
        }
        k=0;
        h=0;
    }
    // Verifico se il tris è presente in una colonna
    for(int i=0; i<columns; i++)
    {
        for (int j=0; j<rows ; j++)
        {
          if(board[j][i]== "x")
          {
            k++;
            if(k==3){ return " VINCE IL GIOCATORE X "; }
          }
          else
          {
             if(board[j][i] == "o")
             {
                h++;
                if(h==3){ return " VINCE IL GIOCATORE O "; }
             }
          }
        }
        k=0;
        h=0;
    }

    // Verifico se il tris è presente in una diagonale
    for(int i=0; i<rows; i++)
    {
        int j = i;
        if(board[i][j]== "x")
        {
            k++;
            if(k==3){ return " VINCE IL GIOCATORE X "; }
        }
        else
        {
           if(board[i][j] == "o")
           {
              h++;
              if(h==3){ return " VINCE IL GIOCATORE O "; }
           }
        }
    }
    k=0;
    h=0;
    int j = 2;
    for(int i=0; i<rows; i++)
    {
        if(board[i][j] == "x")
        {
            k++;
            if(k==3){ return " VINCE IL GIOCATORE X "; }
        }
        else
        {
           if(board[i][j] == "o")
           {
              h++;
              if(h==3){ return " VINCE IL GIOCATORE O "; }
           }
        }
        j--;
    }
    return "" ;
  }

  private String[][] board;
  private static final int rows = 3;
  private static final int columns = 3;
}
import java.util.Scanner;
public class Gioca
{

  public static void main(String[] args)
  {
      int numGiocate = 0;
      String player = "x";

      // Costruisco un nuovo oggetto Tris
      Tris game = new Tris();
      Scanner in = new Scanner(System.in);

      // Procedo con il gioco
      while(true)
      {
          // Giocata del giocatore
          System.out.println(game.toString());
          System.out.print("inserisci riga per " + player);
          System.out.println(" (-1 per uscire): ");

          int riga = in.nextInt();

          if (riga < 0) return;

          System.out.print("Inserisci colonna per " +player);
          System.out.println(" : ");

          int colonna = in.nextInt();

          // Inserimento giocata
          game.set(riga,colonna,player);

          // Visualizzo lo stato del tris
          System.out.println(game.tostring());

          // Verifico se è presente un vincitore
          String verifica = game.getWinner();
          if(verifica.equalsIgnoreCase(" VINCE IL GIOCATORE X ") || verifica.equalsIgnoreCase(" VINCE IL GIOCATORE O "))
          {
              // Il gioco termina se un giocatore vince la partita
              System.out.println(verifica);
              return;
          }

          numGiocate++;
          if(numGiocate==9)
          {
            // Se il tris è pieno e non c'è vincitore, la partita termina
            System.out.println("NESSUN VINCITORE");
            return;
          }

          // Se ha giocato X allora dopo gioca O, altrimenti viceversa
          if(player=="x") player = "o";
          else player = "x";
      }

  }
}
