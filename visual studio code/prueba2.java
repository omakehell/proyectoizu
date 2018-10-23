import java.util.ArrayList;
import java.util.Scanner;
public class prueba2 {

    public static void main(String[] args) {
        roll();
    }
    public static void roll(){
        Scanner teclado = new Scanner(System.in);
        int _roll;
        String _rollString="";
        String _roll_expression = teclado.nextLine();

        for (int i=0 ; i<_roll_expression.length(); i++){
            Character c = _roll_expression.charAt(i);
            if(c.equals(",")){
               System.out.println("coma");
            }else{
                _rollString = _rollString + c;
            }
        }
        System.out.println(_rollString);
    }
}