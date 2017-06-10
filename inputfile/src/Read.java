
        import java.*;
        import  java.io.FileInputStream;
        import  java.io.FileOutputStream;
        import java.io.IOException;
        import java.util.ArrayList;

        public class Read {
    public static void main(String[] args) {
        ArrayList a=new ArrayList();
        try{
            FileInputStream fin = new FileInputStream("C:\\Users\\asus\\Desktop\\info.txt");

            int i =0;
            while ((i=fin.read())!=-1){

                System.out.println((char)i);
                String s=null;
                if((char)i!='/'){
                    s=s+(char)i;

                }
                a.add(s);


            }
            for (int k=0 ;k <a.size();k++){
                System.out.println(a.get(k));
            }
         //  GUI obj=new GUI()
            fin.close();
            System.out.println("s.th");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
