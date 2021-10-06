import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/*      
 */

public class Assignment_2 {
    public static void Bisection(polynomial p, double interval_start, double interval_end, double tolerance) throws IOException {
        WriteFile data=new WriteFile("C:\\Users\\Abbasi\\OneDrive\\Desktop\\Abdurehman\\Abdurehman\\IBA\\Fall 2021\\Numerical Analysis\\Assignment 2\\Data.txt",true);
        double Pa = func(p, interval_start);
        double Pb = func(p, interval_end);
        int counter=0;
        if ((Pa * Pb) > 0) {
            System.out.println("interval not suitable for Bisection method. Input new interval");
            return;
        }
        data.writeToFile("Iteration" +"                " +"P(x)"+"                             " +"F(Px)");
        Double Px=interval_start;
        while ((interval_end - interval_start) >= tolerance) {
             Px = (interval_start + interval_end) / 2.0;
            if(func(p,Px)==0.0){
                break;
            }
            else if((func(p,Px)*func(p,interval_start))<0){
                interval_end=Px;
            }
            else {
                interval_start=Px;
            }
            counter++;
            data.writeToFile("");
            data.writeToFile((counter)+"                        "+(Px) +"                              "+func(p,Px));
        }
        System.out.println("The number of Iterations are " + counter);
        System.out.println("The root is "+Px);
        data.writeToFile("");
        data.writeToFile("It took us "+counter+" iterations to reach our root that is "+(Px));
    }
    public static double func(polynomial p, double value){
        //double Px= (interval_start+interval_end)/2.0;
        double sum=0;
        Eqnode temp= p.Head;
        while (temp!=null) {
            double coff = temp.coefficient;
            double power = temp.power;
            sum = sum + (coff * (Math.pow(value, power)));
            temp=temp.next;
        }
        return sum;
    }
    public static void main(String [] args) throws IOException {
        polynomial p1= new polynomial();
        p1.insert(1,3);
        p1.insert(4,2);
        p1.insert(-10,0);
        Bisection(p1,1,2,0.0001);
        System.out.println("Text file created having all the iterations and the root");
    }
}
