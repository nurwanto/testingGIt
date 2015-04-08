import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Operator
{
    public void Operator() { }

    private static Konfigurasi konff = new Konfigurasi();

    public static Boolean cekKali(List<String> soal1)
    {
        for (int e = 0; e < soal1.size(); e++)
        {
            if (soal1.get(e).equals(konff.SymKali))
            {
                return true;
            }
        }
        return false;
    }

    public static Boolean cekBagi(List<String> soal3)
    {
        for (int e = 0; e < soal3.size(); e++)
        {
            if (soal3.get(e).equals(konff.SymBagi))
            {
                return true;
            }
        }
        return false;
    }

    // Mengetahui indeks yang operator kali paling awal
    public static int IdxKali(List<String> soal2)
    {
        int ssK =0;
        for (int w = 0; w < soal2.size(); w++)
        {
            if (soal2.get(w).equals(konff.SymKali))
            {
                ssK = w;
                w = soal2.size();
            }
        }
        return ssK;
    }

    // Mengetahui indeks bagi paling awal
    public static int IdxBagi(List<String> soal4)
    {
        int ssB=0;
        for (int w = 0; w < soal4.size(); w++)
        {
            if (soal4.get(w).equals(konff.SymBagi))
            {
                ssB = w;
                w = soal4.size();
            }
        }
        return ssB;
    }
    // untuk kasus dalam kurung
    public static Boolean cekKali1(List<String> soal1, int ib, int ia)
    {
        for (int e = ib; e < ia; e++)
        {
            if (soal1.get(e).equals(konff.SymKali))
            {
                return true;
            }
        }
        return false;
    }

    public static Boolean cekBagi1(List<String> soal3, int ib, int ia)
    {
        for (int e = ib; e < ia; e++)
        {
            if (soal3.get(e).equals(konff.SymBagi))
            {
                return true;
            }
        }
        return false;
    }

    // Mengetahui indeks yang operator kali paling awal
    public static int IdxKali1(List<String> soal2, int ib, int ia)
    {
        int ssK = 0;
        for (int w = ib; w < ia; w++)
        {
            if (soal2.get(w).equals(konff.SymKali))
            {
                ssK = w;
                w = ia;
            }
        }
        return ssK;
    }

    // Mengetahui indeks bagi paling awal
    public static int IdxBagi1(List<String> soal4, int ib, int ia)
    {
        int ssB = 0;
        for (int w = ib; w < ia; w++)
        {
            if (soal4.get(w).equals(konff.SymBagi))
            {
                ssB = w;
                w = ia;
            }
        }
        return ssB;
    }

    public static String PreToIn(String strku){
        String temps = "";
        List<String> ctq = new ArrayList<String>(Arrays.asList(strku.split(" ")));
        if(konff.CalType.equals("Aritmetic")){
            for(int i =0; i < ctq.size(); i++){
                if(ctq.get(i).equals(konff.SymTambah) || ctq.get(i).equals(konff.SymKurang) || ctq.get(i).equals(konff.SymKali) ||
                    ctq.get(i).equals(konff.SymBagi) || ctq.get(i).equals(konff.SymMod))
                    {
                    temps += ctq.get(i+1) + " " + ctq.get(i) + " " + ctq.get(i+2)+ " ";
                    i = i+2;
                }else{
                    temps += ctq.get(i) + " ";
                }
            }
        }else{
              for(int i =0; i < ctq.size(); i++){
                if(ctq.get(i).equals(konff.SymAnd) || ctq.get(i).equals(konff.SymOr) || ctq.get(i).equals(konff.SymXor) ||
                    ctq.get(i).equals(konff.SymKD) || ctq.get(i).equals(konff.SymKDS) || ctq.get(i).equals(konff.SymLD) || ctq.get(i).equals(konff.SymLDS)
                     || ctq.get(i).equals(konff.SymSD) || ctq.get(i).equals(konff.SymTSD))
                    {
                    temps += ctq.get(i+1) + " " + ctq.get(i) + " " + ctq.get(i+2)+ " ";
                    i = i+2;
                }else{
                    temps += ctq.get(i) + " ";
                }
            }
        }
      //  System.out.println("PreToIn : " +temps);
        
        return temps;
    }
    
    public static String PostToIn(String strku){
        String temps = "";
        List<String> ctq = new ArrayList<String>(Arrays.asList(strku.split(" ")));
        
        if(konff.CalType.equals("Aritmetic")){
            for(int i =0; i < ctq.size(); i++){
                if(i+2 < ctq.size() && (ctq.get(i+2).equals(konff.SymTambah) || ctq.get(i+2).equals(konff.SymKurang) || ctq.get(i+2).equals(konff.SymKali) ||
                ctq.get(i+2).equals(konff.SymBagi) || ctq.get(i+2).equals(konff.SymMod)))
                {
                    temps += ctq.get(i) + " " + ctq.get(i+2) + " " + ctq.get(i+1)+ " ";
                    i = i+2;
                }else{
                    temps += ctq.get(i) + " ";
                }
            }
        }else{
            for(int i =0; i < ctq.size(); i++){
                if(i+2 < ctq.size() && (ctq.get(i+2).equals(konff.SymAnd) || ctq.get(i+2).equals(konff.SymOr) || ctq.get(i+2).equals(konff.SymXor) ||
                    ctq.get(i+2).equals(konff.SymKD) || ctq.get(i+2).equals(konff.SymKDS) || ctq.get(i+2).equals(konff.SymLD) || ctq.get(i+2).equals(konff.SymLDS)
                     || ctq.get(i+2).equals(konff.SymSD) || ctq.get(i+2).equals(konff.SymTSD)))
                {
                    temps += ctq.get(i) + " " + ctq.get(i+2) + " " + ctq.get(i+1)+ " ";
                    i = i+2;
                }else{
                    temps += ctq.get(i) + " ";
                }
            }
        }

        //System.out.println("PostToIn : "+temps);

        return temps;
    }
}
