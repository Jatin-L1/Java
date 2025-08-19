public class SexyPattern {
    public static void main(String[] args) {
        String str1 = "CGPA achi karunga";
        String str2 =  "Chud gaye guru";
        StringBuilder sb1 = new StringBuilder("CGPA achi karunga");
        StringBuilder sb2 = new StringBuilder("Chud gaye guru");
        for(int j = sb1.length();j>=0;j--){
            if(j!=0)System.out.println(sb1.substring(0,j));
        }
        for(int j = 2 ; j<=sb2.length();j++){
            System.out.println(sb2.substring(0,j));
        }
    }
}
