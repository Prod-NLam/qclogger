import java.io.BufferedWriter;

import java.io.FileWriter;

import java.util.ArrayList;



public class Test2 {



    public static void main(String[] args) {



        String logfile = "/Users/msh114901/Desktop/test.txt";

        ArrayList<String> al = new ArrayList<String>();

        al.add("안녕하세요?");

        al.add("여러분?");

        al.add("반갑습니다.");

        makeFile(logfile,al,true);

    }



    public static boolean makeFile(String _fileName, ArrayList<String> alContent, boolean bAppend)

    {

        boolean isOK;

        try

        {

            FileWriter fw=new FileWriter(_fileName, bAppend);

            BufferedWriter bw=new BufferedWriter(fw);



            String strContent;



            for(int i=0; i<alContent.size(); i++){

                strContent = alContent.get(i);



                bw.write(strContent);

                bw.newLine();

            }

            bw.flush();

            bw.close();

            fw.close();



            isOK= true;

        }

        catch (Exception e)

        {

            e.printStackTrace();

            isOK = false;

        }

        return isOK;

    }



}