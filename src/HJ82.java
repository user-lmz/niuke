import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 数学家斐波那契提出的一种求解***分数的贪心算法，准确的算法表述应该是这样的：
 设某个真分数的分子为a，分母为b;
 把c=(b/a+1)作为分解式中第一个***分数的分母；
 将a-b%a作为新的a；
 将b*c作为新的b；
 如果a等于1，则最后一个***分数为1/b,算法结束；
 如果a大于1但是a能整除b，则最后一个***分数为1/(b/a),算法结束；
 否则重复上面的步骤。
 **/

public class HJ82{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] strArr = str.split("/");
            String[] resArr = new String[1];
            long a = Long.parseLong(strArr[0]);
            long b = Long.parseLong(strArr[1]);
            f(a, b, "", resArr);
            System.out.println(resArr[0]);
        }
    }

    private static void f(long a, long b, String resStr, String[] resArr) {
        if (a == 1 || b%a == 0) {
            resStr += 1+"/"+ b/a;
            resArr[0] = resStr;
        }else {
            long q1 = b/a;
            long r1 = b%a;
            long val1 = q1+1;
            resStr += 1+"/"+val1+"+";
            a = a - r1;
            b = b*(q1+1);
            f(a, b, resStr, resArr);
        }
    }
}