import java.io.*;

public class HJ71 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while((str=bf.readLine())!=null){
            str=str.toLowerCase();
            String s=bf.readLine().toLowerCase();
            boolean [][] flag=new boolean[str.length()+1][s.length()+1];
            flag[0][0]=true;
            if(str.charAt(0)=='*'){
                flag[1][0]=true;
            }
            for(int i=1;i<=str.length();i++){
                char ch=str.charAt(i-1);
                for(int j=1;j<=s.length();j++){
                    char c=s.charAt(j-1);
                    if(ch=='?'){
                        if(check(c)){
                            flag[i][j]=flag[i-1][j-1];
                        }else{
                            flag[i][j]=false;
                        }
                    }else if(ch=='*'){
                        if(check(c)){
                            flag[i][j]=flag[i-1][j-1]||flag[i][j-1]||flag[i-1][j];
                        }else{
                            flag[i][j]=false;
                        }
                    }else if(ch==c){
                        flag[i][j]=flag[i-1][j-1];
                    }else{
                        flag[i][j]=false;
                    }
                }
            }
            System.out.println(flag[str.length()][s.length()]);
        }
    }

    public static boolean check(char ch){
        if(ch>='a'&&ch<='z'||ch>='0'&&ch<='9'){
            return true;
        }
        return false;
    }

}
