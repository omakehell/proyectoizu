import java.util.Random;
public class generarStats{
    public static void main(String[] args) {
        Random r = new Random();
        int max = 16;
        int min = 8;
            int[]loop=new int[6];
            System.out.println("lo que sale del math");
            for (int i = 0; i < loop.length; i++) {
                loop[i] = r.nextInt((max - min) + 1) + min;
                
                System.out.println(loop[i]);
            }            
    }
}