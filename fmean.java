// Author : Febry Afriansyah //
// Github : https://github.com/hatakecnk //

import java.util.*; // Import semua module yang ada di java.util //
import java.text.*; // Import semua module yang ada di java.text //
public class fmean{
    private String getTanggal(){
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMM yyyy");
        Date date = new Date();
        return dateFormat.format(date);  
    }  
    private String getJam(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss a zz");
        Date date = new Date();
        return dateFormat.format(date);  
    }
    public static void main(String[] args){
        for(String m = "Y"; m.equals("Y")||m.equals("y"); ){ // Looping menu //
            try{ // Menampilkan menu pilihan //
                Scanner febry = new Scanner(System.in);
                System.out.print("\nSimple Program Menghitung Mean, Median dan Modus\nAuthor\t: Febry Afriansyah\nGithub\t: https://github.com/hatakecnk\n");
                fmean tgl = new fmean();  
                System.out.println("Tanggal\t: "+tgl.getTanggal()); 
                System.out.println("Jam\t: "+tgl.getJam());
                System.out.print("\nMenu:\n1. Menghitung mean\n2. Menghitung median\n3. Menghitung modus\n0. Keluar\nMasukan Pilihan Anda (1/2/3/0): ");
                int abc = febry.nextInt();
                if (abc==1){ // pilihan 1 menghitung mean //
                    System.out.print("\nMasukkan berapa banyak data: ");
                    Scanner feb = new Scanner(System.in);
                    int input = feb.nextInt();
                    if (input > 0){
                        System.out.println("\nMasukkan isi data berupa angka:");
                        int[] data =  new int[input];
                        for (int i = 0; i < input; i++){
                            System.out.print("- Isi Data ke-" +(i + 1)+ " = ");
                            data[i] = feb.nextInt();
                    }
                    System.out.println("\nHasil :");
                    System.out.printf("Mean\t= %.1f%n", mean(data));
                    System.out.print("Apakah anda ingin kembali ke menu utama? y/t: ");
                    Scanner lagi = new Scanner(System.in);
                    m = lagi.next();
                    }
                    else
                        System.err.println("Silahkan masukkan banyak data lebih dari 0");
                }
                else if (abc==2){ // Pilihan 2 menghitung median //
                    System.out.print("\nMasukkan berapa banyak data: ");
                    Scanner feb = new Scanner(System.in);
                    int input = feb.nextInt();
                    if (input > 0){
                        System.out.println("\nMasukkan isi data berupa angka:");
                        int[] data =  new int[input];
                        for (int i = 0; i < input; i++){
                            System.out.print("- Isi Data ke-" +(i + 1)+ " = ");
                            data[i] = feb.nextInt();
                    }
                    System.out.println("\nHasil :");
                    System.out.printf("Median\t= %.1f%n", median(data));
                    System.out.print("Apakah anda ingin kembali ke menu utama? y/t: ");
                    Scanner lagi = new Scanner(System.in);
                    m = lagi.next();
                    }
                    else
                        System.err.println("Silahkan masukkan banyak data lebih dari 0");
                }
                else if (abc==3){ // pilihan 3 menghitung modus //
                    System.out.print("\nMasukkan berapa banyak data: ");
                    Scanner feb = new Scanner(System.in);
                    int input = feb.nextInt();
                    if (input > 0){
                        System.out.println("\nMasukkan isi data berupa angka:");
                        int[] data =  new int[input];
                        for (int i = 0; i < input; i++){
                            System.out.print("- Isi Data ke-" +(i + 1)+ " = ");
                            data[i] = feb.nextInt();
                    }
                    System.out.println("\nHasil :");
                    System.out.printf("Modus\t= %s%n", modus(data, input));
                    System.out.print("Apakah anda ingin kembali ke menu utama? y/t: ");
                    Scanner lagi = new Scanner(System.in);
                    m = lagi.next();
                    }
                    else
                        System.err.println("Silahkan masukkan banyak data lebih dari 0");
                }
                else if (abc>3){
                    System.out.print("Input Salah\nApakah anda ingin kembali ke menu utama? y/t: ");
                    Scanner lagi = new Scanner(System.in);
                    m = lagi.next();
                }
                else{ // Keluar //
                    System.out.println("Terima kasih telah menggunakan program kami");
                    System.exit(0);
                }
            }
            catch (Exception e) {
                System.out.print("Input Salah\nApakah anda ingin kembali ke menu utama? y/t: ");
                Scanner lagi = new Scanner(System.in);
                m = lagi.next();
            }
        }
        for(String m = "Y"; m != ("Y")||m !=("y"); ){ // Keluar dari loopinng //
            System.out.println("Terima Kasih telah menggunakan program kami");
            System.exit(0);
        }
    }

    static String modus(int[] data, int input){ // hitung modus //
        int c;
        int[] b = new int[input];
        for (int i = 0; i < input; i++){
            c = 1;
            if (data[i] == -1)
                b[i] = 0;
            else{
                for (int j = i+1; j < input; j++){
                    if (data[i] == data[j]){
                        c++;
                        data[j] = -1;
                    }
                }
                b[i] = c;
            }
        }
        int m = b[0];
        for (int i = 1; i < input; i++){
            if (b[i] >= m)
                m = b[i];
        }
        String[] outputHasil = new String[input];
        for (int i = 0; i < input; i++){
            if (b[i] == m)
                outputHasil[i] = String.valueOf(data[i]);
        }
        String[] modus = Arrays.stream(outputHasil).filter(Objects::nonNull).toArray(String[]::new);
        return String.join(", ", modus);
    }

    static double median(int[] dataArr){ // Hitung median //
        double median;
        int[] data = urutkan(dataArr);
        if (data.length % 2 == 1)
            median = data[data.length / 2];
        else
            median = ((double) (data[data.length / 2] + data[(data.length / 2) - 1])) / 2;
        return median;
    }

    static double mean(int[] data){ // Hitung mean //
        int tambah = 0;
        for (int dataTambah : data){
            tambah += dataTambah;
        }
        return tambah / (double) data.length;
    }

    static int[] urutkan(int[] data){
        int temp;
        for (int i = 0; i < data.length-1; i++){
            for (int j = data.length-1; j > i; j--){
                if (data[j-1] > data[j]){
                    temp        = data[j];
                    data[j]     = data[j-1];
                    data[j-1]   = temp;
                }
            }
        }
        return data;
    }
}
