import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HJ18 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[7];
        String in;
        while((in = bf.readLine()) != null && in.length() != 0) {
            String[] split = in.split("~");
            String ip = split[0];
            String mask = split[1];

            String[] ips = ip.split("\\.");
            int num1 = 0;
            int num2 = 0;
            try{
                num1 = Integer.parseInt(ips[0]);
                num2 = Integer.parseInt(ips[1]);
                Integer.parseInt(ips[2]);
                Integer.parseInt(ips[3]);

            }catch (NumberFormatException e) {
                count[5]++;
                continue;
            }

            boolean isIP = isIP(ip);
            boolean isMask = isMask(mask);

            if (isIP && isMask) {
                count = countIP(ip,count);
            } else if ((isIP == false || isMask == false) && num1 != 127 && num1 != 127) {
                count[5]++;
            }
        }
        for(int i=0;i<6;i++)
            System.out.print(count[i]+" ");
        System.out.print(count[6]);
    }

    private static int[] countIP(String ip, int[] count) {
        String[] split = ip.split("\\.");
        int first = Integer.parseInt(split[0]);
        if (isPrivateIP(ip)) count[6]++;

        if (first >=1 && first <= 126)
            count[0]++;
        else if (first >= 128 && first <= 191)
            count[1]++;
        else if (first >= 192 && first <= 223)
            count[2]++;
        else if (first >= 224 && first <= 239)
            count[3]++;
        else if (first >= 240 && first <= 255)
            count[4]++;
        return count;
    }

    private static boolean isPrivateIP(String ip) {
        String[] split = ip.split("\\.");
        //根据范围即可
        if(Integer.parseInt(split[0])==10) return true;
        else if(Integer.parseInt(split[0])==172&&(Integer.parseInt(split[1])>15&&Integer.parseInt(split[1])<32)){
            return true;
        }else if(Integer.parseInt(split[0])==192&&Integer.parseInt(split[1])==168){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isMask(String mask) {
        String[] maskarr = mask.split("\\.");
        boolean result = false;
        int[] maskRange = {254, 252, 248, 240, 224, 192, 128, 0};
        List<Integer> list = new ArrayList<>();
        for (int i: maskRange)
            list.add(i);
        if ("255".equals(maskarr[0]) && "255".equals(maskarr[1])
                && "255".equals(maskarr[2])) {
            if (list.contains(Integer.parseInt(maskarr[3]))) {
                result = true;
            }
        }
        else if ("255".equals(maskarr[0]) && "255".equals(maskarr[1])) {
            if (list.contains(Integer.parseInt(maskarr[2]))
                    && "0".equals(maskarr[3])) {
                result = true;
            }
        }
        else if ("255".equals(maskarr[0])) {
            if (list.contains(Integer.parseInt(maskarr[1]))
                    && "0".equals(maskarr[2]) && "0".equals(maskarr[3])) {
                result = true;
            }
        }
        else if (list.contains(Integer.parseInt(maskarr[0]))) {
            if ("0".equals(maskarr[1]) && "0".equals(maskarr[2])
                    && "0".equals(maskarr[3])) {
                result = true;
            }
        }
        return result;
    }

    private static boolean isIP(String ip) {
        String[] IParr = ip.split("\\.");
        boolean isTrue = true;
        for (int i = 0; i < IParr.length; i++) {
            if (IParr[i].length() <= 0 || Objects.equals(IParr[i], "")) {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }
}
