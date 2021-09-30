import java.util.*;
public class fmean{
    public static void main(String[] args){
        int input, abc;
        Scanner febry = new Scanner(System.in);
        try{
            for(String m = "Y"; m.equals("Y")||m.equals("y"); ){
                System.out.print("Simple Program Menghitung Mean, Median dan Modus\nAuthor\t: Febry Afriansyah\nGithub\t: https://github.com/hatakecnk\n\n1. Menghitung mean\n2. Menghitung median\n3. Menghitung modus\n0. Keluar\n");
                System.out.print("Masukan Pilihan Anda (1/2/3/0): ");
                abc = febry.nextInt();
                try{
                    if (abc==1){
                        System.out.println("");
                        System.out.print("Masukkan berapa banyak data: ");
                        Scanner feb = new Scanner(System.in);
                        input = feb.nextInt();
                        if (input > 0){
                            System.out.println("\nMasukkan isi data berupa angka:");
                        int[] data =  new int[input];
                        for (int i = 0; i < input; i++)
                        {
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
                    else if (abc==2){
                        System.out.println("");
                        System.out.print("Masukkan berapa banyak data: ");
                        Scanner feb = new Scanner(System.in);
                        input = feb.nextInt();
                        if (input > 0){
                            System.out.println("\nMasukkan isi data berupa angka:");
                        int[] data =  new int[input];
                        for (int i = 0; i < input; i++)
                        {
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
                    else if (abc==3){
                        System.out.println("");
                        System.out.print("Masukkan berapa banyak data: ");
                        Scanner feb = new Scanner(System.in);
                        input = feb.nextInt();
                        if (input > 0){
                            System.out.println("\nMasukkan isi data berupa angka:");
                        int[] data =  new int[input];
                        for (int i = 0; i < input; i++)
                        {
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
                    else{
                        System.out.println("Terima kasih telah menggunakan program kami");
                        System.exit(1);
                    }
                }
                catch (InputMismatchException e) {
                    System.out.print("Input Salah!");
                    System.out.print("\nApakah anda ingin kembali ke menu utama? y/t: ");
                    Scanner lagi = new Scanner(System.in);
                    m = lagi.next();
                }
                for (String n = "T"; n.equals("T")||n.equals("t"); ){
                    System.out.println("Terimakasih");
                    System.exit(0);
                }
            }
            for (String n = "T"; n.equals("T")||n.equals("t"); ){
                System.out.println("Terimakasih");
                System.exit(0);
            }

        }
        catch (InputMismatchException e) {
            System.out.print("Input Salah!");
        }
    }


    static String modus(int[] data, int input)
    {
        int c;
        int[] b = new int[input];

        for (int i = 0; i < input; i++)
        {
            c = 1;

            if (data[i] == -1)
                b[i] = 0;
            else
            {
                for (int j = i+1; j < input; j++)
                {
                    if (data[i] == data[j])
                    {
                        c++;
                        data[j] = -1;
                    }
                }

                b[i] = c;
            }
        }

        int m = b[0];
        for (int i = 1; i < input; i++)
        {
            if (b[i] >= m)
                m = b[i];
        }

        String[] outputHasil = new String[input];
        for (int i = 0; i < input; i++)
        {
            if (b[i] == m)
                outputHasil[i] = String.valueOf(data[i]);
        }

        String[] modus = Arrays.stream(outputHasil).filter(Objects::nonNull).toArray(String[]::new);

        return String.join(", ", modus);
    }

    static double median(int[] dataArr)
    {
        double median;
        int[] data = urutkan(dataArr);

        if (data.length % 2 == 1)
            median = data[data.length / 2];
        else
            median = ((double) (data[data.length / 2] + data[(data.length / 2) - 1])) / 2;

        return median;
    }

    static double mean(int[] data)
    {
        int tambah = 0;
        for (int dataTambah : data)
        {
            tambah += dataTambah;
        }

        return tambah / (double) data.length;
    }

    static int[] urutkan(int[] data)
    {
        int temp;
        for (int i = 0; i < data.length-1; i++)
        {
            for (int j = data.length-1; j > i; j--)
            {
                if (data[j-1] > data[j])
                {
                    temp        = data[j];
                    data[j]     = data[j-1];
                    data[j-1]   = temp;
                }
            }
        }

        return data;
    }
}