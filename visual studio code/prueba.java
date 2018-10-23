import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.UUID;
import java.util.Random;


public class prueba {

    public static void main(String[] args) {
        System.out.println("--Tirada de dado--");
        int _roll = roll(2,20,3);
        System.out.println("El resultado de la tirada ha sido:" + _roll);

        //[0] => NOMBRE USUARIO.
        //[1] => CONTRASEÑA.
        //[2] => NUMERO RNG PARA RECUPERAR CUENTA.
        System.out.println("--Creacion de usuario, contraseña y codigo de recuperacion--");
        String[] _crearCuenta = crearCuenta("usu1","pass1"); 
        for(int i = 0; i<_crearCuenta.length;i++){
           System.out.println(_crearCuenta[i].toUpperCase().replace("-", ""));
        }
        //[0] STR, [1]DEX, [2]CON. 
        //[3]INT, [4]WIS, [5]CHA.
        System.out.println("--RNG para creacion de stats--");
        int[] _stats = stats();
        System.out.print("STR: " + _stats[0] + ",");
        System.out.print("DEX: " + _stats[1] + ",");
        System.out.print("CON: " + _stats[2] + ",");
        System.out.print("INT: " + _stats[3] + ",");
        System.out.print("WIS: " + _stats[4] + ",");
        System.out.println("CHA: " + _stats[5] + ",");

        //[0] STR, [1]DEX, [2]CON. 
        //[3]INT, [4]WIS, [5]CHA.
        System.out.println("--seleccion de raza y aplicacion de cambios en stats.--");
        int[] _statsRaza = raza(_stats,"elfo");
        System.out.print("STR: " + _statsRaza[0] + ",");
        System.out.print("DEX: " + _statsRaza[1]+ ",");
        System.out.print("CON: " + _statsRaza[2]+ ",");
        System.out.print("INT: " + _statsRaza[3]+ ",");
        System.out.print("WIS: " + _statsRaza[4]+ ",");
        System.out.println("CHA: " + _statsRaza[5]);

        System.out.println("--Elegimos clase--");
        //[0] => NOMBRE DE CLASE - 
        //[1] => HPLVL1 - 
        //[2] => HABILIDAD INICIAL 1 - [3] => HABILIDAD INICIAL 2 - 
        //[4] => INICIATIVA
        //[5] => ARMA INICIAL
        //[6]=> SAVING THROWS
        String[] _clase = clase("cazador");
        System.out.println("CLASE ELEGIDA: " + _clase[0]);
        System.out.println("HP A LVL 1: " + _clase[1]);
        System.out.println("HABILIDAD 1: " + _clase[2]);
        System.out.println("HABILIDAD 2: " + _clase[3]);
        System.out.println("INICIATIVA: " + _clase[4]);
        System.out.println("ARMA INICIAL: " + _clase[5]);
        System.out.println("SAVING THROWS: " + _clase[6]);
    }
    public static int roll(int cantidad, int tamanoDado,int modificador){
        int resultado[] = new int[cantidad];
        int total=0;
        System.out.println("Se ha tirado: " + cantidad + "d" + tamanoDado + "+" + modificador);
                for(int i = 0;i < cantidad;i++){
                    resultado[i] = (int) (Math.random()*tamanoDado+1);
                    System.out.print(resultado[i] + " , ");
                    total=total+resultado[i];
                }
                System.out.println("+" + modificador);
                return total;
    }

    public static String[] crearCuenta(String user, String pass){
        String[] usuario = new String[3];
        System.out.println("Usuario =>");
        usuario[0] = user;
        System.out.println("Contraseña=>");
        usuario[1] = pass;
        usuario[2] = UUID.randomUUID().toString();
        return usuario;
    }
   public static int[] stats(){
    Random r = new Random();
        int max = 16;
        int min = 8;
            int[]loop=new int[6];
            for (int i = 0; i < loop.length; i++) {
                loop[i] = r.nextInt((max - min) + 1) + min;
            }
            return loop;
   }
   public static int[] raza(int[] stats_base, String nombre_raza){
    int[] stats_raza = new int[6];

    switch (nombre_raza.toUpperCase().trim()) {
        case "HUMANO": 
        System.out.println("RAZA SELECCIONADA: HUMANO. +1 TODAS LAS STATS");
        for (int i = 0; i < stats_base.length; i++) {
            stats_raza[i] = stats_base[i] + 1;
        }
            break;
            case "ELFO" : 
            System.out.println("RAZA SELECCIONADA: ELFO. +2 DEX, +1 CHA");
            for (int i = 0; i < stats_base.length; i++) {
                if(i == 1){
                    stats_raza[i] = stats_base[i] + 2;
                }else if(i == 5){
                    stats_raza[i] = stats_base[i] + 1;
                }else{
                    stats_raza[i] = stats_base[i];
                }
            }
        default:
            break;
    }

    return stats_raza;
   }
   public static String[] clase(String nombreClase){
       String[] clase_computada = new String[7];
    switch (nombreClase.toUpperCase().trim()) {
        case "BARBARO":
            clase_computada[0] = "BARBARO";
            clase_computada[1] = "12";
            clase_computada[2] = "RAGE";
            clase_computada[3] = "UNARMORED COMBAT";
            clase_computada[4] = "+2";
            clase_computada[5] = "BATTLEAXE";
            clase_computada[6] = "STR - CON";
            break;
            case "CAZADOR":
            clase_computada[0] = "CAZADOR";
            clase_computada[1] = "10";
            clase_computada[2] = "FAVORED ENEMY";
            clase_computada[3] = "NATURAL EXPLORER";
            clase_computada[4] = "+2";
            clase_computada[5] = "LONGBOW";
            clase_computada[6] = "STR - DEX";
            break;
            case "CLERIGO":
            clase_computada[0] = "CLERIGO";
            clase_computada[1] = "8";
            clase_computada[2] = "SPELLCASTING(CLERIC)";
            clase_computada[3] = "DIVINE DOMAIN";
            clase_computada[4] = "+2";
            clase_computada[5] = "WARHAMMER";
            clase_computada[6] = "WIS - CHA";
            break;
            case "MAGO":
            clase_computada[0] = "MAGO";
            clase_computada[1] = "6";
            clase_computada[2] = "SPELLCASTING";
            clase_computada[3] = "ARCANE RECOVERY";
            clase_computada[4] = "+2";
            clase_computada[5] = "SPELLBOOK";
            clase_computada[6] = "INT - WIS";
            break;
        default:
            clase_computada[0] = "NAN";
            clase_computada[1] = "NAN";
            clase_computada[2] = "NAN";
            clase_computada[3] = "NAN";
            clase_computada[4] = "NAN";
            clase_computada[5] = "NAN";
            break;
    }
    return clase_computada;
       
   }
}
