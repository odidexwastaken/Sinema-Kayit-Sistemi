import java.util.Scanner;

public class sinemaKayitSistemi {
    
    
    
    static int maks_film = 10;
    static int maks_musteri = 20;


    static String[] filmAd = new String[maks_film];
    static String[] filmTur = new String[maks_film];
    static int[] filmDk = new int[maks_film];
    static int filmSayisi = 0;


    static String[] musteriAd = new String[maks_musteri];
    static String[] musteriMail = new String[maks_musteri];
    static int musteriSayisi = 0;


    static int[][] biletler = new int[maks_musteri][maks_film];


    public static void main(String[] args) {
        
        
        
        Scanner scanner = new Scanner(System.in);
        int secenek;


        do {
            
            System.out.println("\n--- Sinema Müşteri Kayıt Sistemi ---");
            System.out.println("1. Film Ekle");
            System.out.println("2. Film Listesi");
            System.out.println("3. Müşteri Ekle");
            System.out.println("4. Müşteri Listesi");
            System.out.println("5. Bilet Oluştur");
            System.out.println("6. Bilet Listesi");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secenek = scanner.nextInt();
            scanner.nextLine();

            switch (secenek) {
                
                case 1:
                    filmEkle(scanner);
                    break;
                    
                case 2:
                    filmListe();
                    break;
                    
                case 3:
                    musteriEkle(scanner);
                    break;
                    
                case 4:
                    musteriListe();
                    break;
                    
                case 5:
                    biletEkle(scanner);
                    break;
                    
                case 6:
                    biletListe();
                    break;
                    
                case 0:
                    System.out.println("\nÇıkış yapılıyor...");
                    break;
                    
                default:
                    System.out.println("\nGeçersiz seçim");
            }

        } while (secenek != 0);
    }

    static void filmEkle(Scanner scanner) {
        
        if (filmSayisi >= maks_film) {
            System.out.println("\nMaksimum film sayısına ulaşıldı");
            return;
        }

        System.out.print("\nFilm Adı: ");
        filmAd[filmSayisi] = scanner.nextLine();

        System.out.print("\nFilm Süresi (dakika): ");
        filmDk[filmSayisi] = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nFilm Türü: ");
        filmTur[filmSayisi] = scanner.nextLine();

        filmSayisi++;
        System.out.println("\nFilm başarıyla eklendi");
    }

    static void musteriEkle(Scanner scanner) {
        
        if (musteriSayisi >= maks_musteri) {
            System.out.println("\nMaksimum müşteri sayısına ulaşıldı");
            return;
        }

        System.out.print("\nMüşteri Adı: ");
        musteriAd[musteriSayisi] = scanner.nextLine();

        System.out.print("\nMüşteri Email: ");
        musteriMail[musteriSayisi] = scanner.nextLine();

        musteriSayisi++;
        System.out.println("\nMüşteri başarıyla eklendi");
        
    }

    static void filmListe() {
        
        System.out.println("\n--- Film Listesi ---");
        
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println((i + 1)+". "+filmAd[i]+", "+filmDk[i]+" dk, Tür: "+filmTur[i]);
        }
    }

    static void musteriListe() {
        
        System.out.println("\n--- Müşteri Listesi ---");
        
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println((i + 1)+". "+musteriAd[i]+", "+musteriMail[i]);
        }
    }

    static void biletEkle(Scanner scanner) {
        
        if (musteriSayisi == 0 || filmSayisi == 0) {
            System.out.println("\nLütfen önce film ve müşteri ekleyin");
            return;
        }

        musteriListe();
        System.out.print("\nMüşteri numarasını girin: ");
        int musteriIndex = scanner.nextInt() - 1;

        filmListe();
        System.out.print("\nFilm numarasını girin: ");
        int filmIndex = scanner.nextInt() - 1;

        if (musteriIndex >= 0 && musteriIndex < musteriSayisi && filmIndex >= 0 && filmIndex < filmSayisi) {

            biletler[musteriIndex][filmIndex] = 1;
            System.out.println("\nBilet başarıyla oluşturuldu");
        } 
        else {
            System.out.println("\nGeçersiz müşteri veya film numarası");
        }
    }

    static void biletListe() {
        
        System.out.println("\n--- Bilet Listesi ---");
        
        for (int i = 0; i < musteriSayisi; i++) {
            
            for (int j = 0; j < filmSayisi; j++) {
                
                if (biletler[i][j] == 1) {
                    System.out.println(musteriAd[i]+" -> "+filmAd[j]);
                }
            }
        }
    }
}
