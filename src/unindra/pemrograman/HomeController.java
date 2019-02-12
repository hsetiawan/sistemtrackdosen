package unindra.pemrograman;

import unindra.pemrograman.dao.DosenDao;
import unindra.pemrograman.helper.Log;
import unindra.pemrograman.model.DosenModel;

import java.io.IOException;
import java.util.Scanner;

public class HomeController {
    public final static String line_strip = "-----------------------------------------------------------------------------------------------";

    public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
             String line = "===============================================================================================";
            getDialog(scanner, line);
        }

        private static void getDialog(Scanner scanner, String line) {
            Log.i(line_strip);
            Log.i("Apakah anda Dosen ? (Yes/No) : ");
            String isDosen = scanner.next();
            isDosen = isDosen.toLowerCase();
            if(isDosen.startsWith("n")){
                isStudents(scanner, line);
            }
            isDosen(scanner, line);

        }

        private static void isDosen(Scanner scanner, String line) {
            Log.dosen(line_strip);
            Log.dosen("Hallo Dosen");
            Log.dosen("Silahkan masukan NIP anda : ");String NIP = scanner.next();
            if(NIP != ""){
                DosenDao dosenDao = new DosenDao();
                String getDosen = dosenDao.getByNIP(NIP);
                 if(getDosen.length() == 0 ){
                    Log.e("Data tidak ditemukan");
                    doExit(scanner, line_strip);
                }

                Log.dosen(line_strip);
                Log.dosen(getDosen);
                Log.dosen(line_strip);
                System.out.println(" ");
                Log.dosen("Tekan :");
                Log.dosen("1. Bila ingin Ubah Profile. \n2. Bila ingin Ubah Jadwal mengajar. \nPILIH : ");String pilih = scanner.next();
                if(pilih.toLowerCase().equals("1")){
                    DosenModel dosenModel = new DosenModel();
                    System.out.println("UBAH PROFILE (beri tanda '-' bila tidak ingin mengubah)");
                    System.out.print("Nama : ");String nama = scanner.next(); dosenModel.setNamaDosen(nama);
                    System.out.print("Alamat : ");String alamat = scanner.next(); dosenModel.setNamaDosen(alamat);
                    System.out.print("No HP : ");String noHp = scanner.next(); dosenModel.setNamaDosen(noHp);
                    System.out.println("SAVE (Yes/No)");String isSave = scanner.next();
                }

                if(pilih.toLowerCase().equals("2")){

                }
            }
        }

        private static void isStudents(Scanner scanner, String line) {
            System.out.println(line);
            System.out.print("Cari Dosen (Masukan Nama/NIP Dosen) : ");
            String cari = scanner.next();

            DosenDao dosenDao = new DosenDao();
            String result = dosenDao.view(cari);
            if(result != "") {
                System.err.println("Data tidak ditemukan");
                doExit(scanner, line);
            }

            System.out.println(line);
            System.out.println(result);
            doExit(scanner, line);


        }

        private static void doExit(Scanner scanner, String line) {
            Log.w("Keluar Program ? (Yes/No) :");
            if (isExit(scanner.next())) {
                System.exit(0);
            }

            getDialog(scanner, line);

        }

        public static Boolean isExit(String param){
            Boolean result = false;
            if(param != "" && param.toLowerCase().startsWith("y"))  result = true;
            return result;
        }


}
