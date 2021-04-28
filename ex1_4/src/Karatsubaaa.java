import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Karatsubaaa {
    public static BigInteger Karatsyba(BigInteger x, BigInteger y, int n){
        if (n==1){
            return x.multiply(y);
        }
        BigInteger Pow_n = BigInteger.valueOf((long) Math.pow(10, n));
        BigInteger Pow_nHalf = BigInteger.valueOf((long) Math.pow(10, n/2));

        BigInteger a = x.divide(Pow_nHalf);
        BigInteger b = x.mod(Pow_nHalf);
        BigInteger c = y.divide(Pow_nHalf);
        BigInteger d = y.mod(Pow_nHalf);

        BigInteger ac = Karatsyba(a, c, n/2);
        BigInteger bd = Karatsyba(b, d, n/2);
        BigInteger pq = Karatsyba(a.add(b), c.add(d), n/2);

        BigInteger abcd = pq.subtract(ac).subtract(bd);
        return ac.multiply(Pow_n).add(abcd.multiply(Pow_nHalf).add(bd));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во знаков в числах: ");
        int N = scanner.nextInt();
        System.out.print("Введите 2 числа через пробел: ");
        String s = reader.readLine();
        String[] numbStr = s.split(" ");

        System.out.print("\n");
        BigInteger x = new BigInteger(numbStr[0]);
        BigInteger y = new BigInteger(numbStr[1]);
        BigInteger Pow = new BigInteger("10");
        /*if (N % 2 == 1){
            N++;
            x = x.multiply(Pow);
            y = y.multiply(Pow);
        }*/
        System.out.print("Результат: ");
        System.out.print(Karatsyba(x, y, N));

    }

}
