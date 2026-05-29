package homeworks;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Odev_2 {

    static String dosyaAdi = "envanter.txt";
    static String logDosyasi = "oyun_log.txt";

    static String SIMULE_API_URL = "https://api.survivalgame.com/v1/loot/spawn?zone=kasaba";

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);

        // EKSTRA ÖZELLİK 1: KULLANICI ŞİFRE DENETİMİ
        System.out.println("=== HAYATTA KALMA SİSTEMİNE GİRİŞ ===");
        int hak = 3;
        boolean girisBasarili = false;

        while (hak > 0) {
            System.out.print("Kullanıcı Adı: ");
            String kullanici = giris.nextLine();
            System.out.print("Şifre: ");
            String sifre = giris.nextLine();
            // kullanıcı adı : beşiktaş  şifre : 1234
            if (kullanici.equals("beşiktaş") && sifre.equals("1234")) {
                System.out.println("Giriş Başarılı! Sisteme yönlendiriliyorsunuz...\n");
                girisBasarili = true;
                logYaz("Sisteme başarılı admin girişi yapıldı.");
                break;
            } else {
                hak--;
                System.out.println("Hatalı giriş! Kalan hakkınız: " + hak);
            }
        }

        if (!girisBasarili) {
            System.out.println("Giriş hakkınız bitti. Sistem kapatılıyor.");
            logYaz("Sisteme başarısız giriş denemesi yapıldı.");
            giris.close();
            return;
        }

        int secim = 0;

        do {
            System.out.println("\n==== HAYATTA KALMA OYUNU ENVANTER SİSTEMİ ====");
            System.out.println("[1] Dünyadan Loot Topla (Veri Çek)");
            System.out.println("[2] Çantayı İncele (Listele)");
            System.out.println("[3] Eşya Tamir Et (Güncelle)");
            System.out.println("[4] Eşyayı Çöpe At (Sil)");
            System.out.println("[5] Sistem Loglarını Görüntüle (Ekstra Özellik)");
            System.out.println("[6] Çıkış");
            System.out.print("Seçim Yapınız: ");

            try {
                secim = giris.nextInt();
                giris.nextLine();
            } catch (Exception e) {
                System.out.println("Hatalı giriş yaptınız! Lütfen sayı giriniz.");
                giris.nextLine();
                continue;
            }

            switch (secim) {
                case 1:
                    veriCek();
                    break;
                case 2:
                    altMenuListele(giris);
                    break;
                case 3:
                    guncelle(giris);
                    break;
                case 4:
                    sil(giris);
                    break;
                case 5:
                    logOku();
                    break;
                case 6:
                    System.out.println("Oyun kaydedildi. Çıkış yapılıyor...");
                    logYaz("Sistemden güvenli çıkış yapıldı.");
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız.");
            }

        } while (secim != 6);

        giris.close();
    }

    public static void veriCek() {
        System.out.println("Loot Sunucusuna Bağlanılıyor: " + SIMULE_API_URL);

        String jsonVerisi = "[{\"id\":1,\"ad\":\"Pasli Balta\",\"tur\":\"SILAH\",\"agirlik\":2.5,\"durum\":45},{\"id\":2,\"ad\":\"Konserve Fasulye\",\"tur\":\"GIDA\",\"agirlik\":0.4,\"durum\":100},{\"id\":3,\"ad\":\"Bandaj\",\"tur\":\"SAGLIK\",\"agirlik\":0.1,\"durum\":100},{\"id\":4,\"ad\":\"Beyzbol Sopasi\",\"tur\":\"SILAH\",\"agirlik\":1.2,\"durum\":70},{\"id\":5,\"ad\":\"Sise Su\",\"tur\":\"GIDA\",\"agirlik\":0.5,\"durum\":100},{\"id\":6,\"ad\":\"Ilk Yardim Kiti\",\"tur\":\"SAGLIK\",\"agirlik\":1.5,\"durum\":100},{\"id\":7,\"ad\":\"Yapiskan Bant\",\"tur\":\"MALZEME\",\"agirlik\":0.2,\"durum\":80},{\"id\":8,\"ad\":\"Pompali Tufek\",\"tur\":\"SILAH\",\"agirlik\":3.8,\"durum\":60},{\"id\":9,\"ad\":\"Enerji Icecegi\",\"tur\":\"GIDA\",\"agirlik\":0.3,\"durum\":100},{\"id\":10,\"ad\":\"Agri Kesici\",\"tur\":\"SAGLIK\",\"agirlik\":0.1,\"durum\":100},{\"id\":11,\"ad\":\"Civi Kutusu\",\"tur\":\"MALZEME\",\"agirlik\":0.8,\"durum\":100},{\"id\":12,\"ad\":\"Tabanca\",\"tur\":\"SILAH\",\"agirlik\":1.1,\"durum\":85},{\"id\":13,\"ad\":\"Konserve Et\",\"tur\":\"GIDA\",\"agirlik\":0.5,\"durum\":100},{\"id\":14,\"ad\":\"Antibiyotik\",\"tur\":\"SAGLIK\",\"agirlik\":0.1,\"durum\":100},{\"id\":15,\"ad\":\"El Feneri\",\"tur\":\"MALZEME\",\"agirlik\":0.4,\"durum\":50},{\"id\":16,\"ad\":\"Av Bicagi\",\"tur\":\"SILAH\",\"agirlik\":0.6,\"durum\":90},{\"id\":17,\"ad\":\"Elma\",\"tur\":\"GIDA\",\"agirlik\":0.2,\"durum\":30},{\"id\":18,\"ad\":\"Kan Torbasi\",\"tur\":\"SAGLIK\",\"agirlik\":0.5,\"durum\":100},{\"id\":19,\"ad\":\"Pil\",\"tur\":\"MALZEME\",\"agirlik\":0.1,\"durum\":100},{\"id\":20,\"ad\":\"Demir Boru\",\"tur\":\"SILAH\",\"agirlik\":2.0,\"durum\":55},{\"id\":21,\"ad\":\"Bozuk Sut\",\"tur\":\"GIDA\",\"agirlik\":1.0,\"durum\":10},{\"id\":22,\"ad\":\"Adrenalin Ignesi\",\"tur\":\"SAGLIK\",\"agirlik\":0.1,\"durum\":100},{\"id\":23,\"ad\":\"Halat\",\"tur\":\"MALZEME\",\"agirlik\":1.2,\"durum\":95},{\"id\":24,\"ad\":\"Pala\",\"tur\":\"SILAH\",\"agirlik\":1.8,\"durum\":75},{\"id\":25,\"ad\":\"Kurutulmus Et\",\"tur\":\"GIDA\",\"agirlik\":0.3,\"durum\":100},{\"id\":26,\"ad\":\"Radyasyon Hapi\",\"tur\":\"SAGLIK\",\"agirlik\":0.1,\"durum\":100},{\"id\":27,\"ad\":\"Cadir\",\"tur\":\"MALZEME\",\"agirlik\":4.5,\"durum\":80},{\"id\":28,\"ad\":\"Arbalet\",\"tur\":\"SILAH\",\"agirlik\":2.8,\"durum\":65},{\"id\":29,\"ad\":\"Taze Havuc\",\"tur\":\"GIDA\",\"agirlik\":0.2,\"durum\":85},{\"id\":30,\"ad\":\"Gaz Maskesi\",\"tur\":\"MALZEME\",\"agirlik\":1.0,\"durum\":40}]";

        try {
            String[] esyalar = jsonVerisi.split("\\},\\{");
            FileWriter fw = new FileWriter(dosyaAdi, false);
            int sayac = 0;

            for (String esya : esyalar) {
                String id = parcaGetir(esya, "\"id\":", 0);
                String ad = parcaGetir(esya, "\"ad\":\"", 1);
                String tur = parcaGetir(esya, "\"tur\":\"", 1);
                String agirlik = parcaGetir(esya, "\"agirlik\":", 0);
                String durum = parcaGetir(esya, "\"durum\":", 0);

                if (ad != null) {
                    fw.write(id + ";" + ad + ";" + tur + ";" + agirlik + ";" + durum + "\n");
                    sayac++;
                }
            }
            fw.close();
            System.out.println(sayac + " adet eşya çantaya eklendi.");
            logYaz("API'den veriler çekildi ve txt dosyasına başarıyla yazıldı.");

        } catch (Exception e) {
            System.out.println("Veri çekilirken hata oluştu!");
            logYaz("HATA: Veri çekme işlemi başarısız oldu.");
        }
    }

    public static String parcaGetir(String veri, String anahtar, int tur) {
        int index = veri.indexOf(anahtar);
        if (index != -1) {
            int basla = index + anahtar.length();
            int bitis = 0;

            if (tur == 1) {
                bitis = veri.indexOf("\"", basla);
            } else {
                bitis = veri.indexOf(",", basla);
                if (bitis == -1) {
                    bitis = veri.indexOf("}", basla);
                    if (bitis == -1) bitis = veri.indexOf("]", basla);

                    if (bitis == -1) bitis = veri.length();
                }
            }

            if (bitis > basla) {
                return veri.substring(basla, bitis).replace("{", "").replace("[", "").replace("]", "").trim();
            }
        }
        return null;
    }

    public static void altMenuListele(Scanner giris) {
        int secim2 = 0;
        System.out.println("\n==== Çantayı Listele ====");
        System.out.println("[1] Eşya türüne göre listele");
        System.out.println("[2] Ağırlığa göre listele");
        System.out.println("[3] Bütün eşyaları listele");
        System.out.println("[4] Üst menüye dön");
        System.out.print("Seçim: ");

        try {
            secim2 = giris.nextInt();
            giris.nextLine();
        } catch (Exception e) {
            System.out.println("Hatalı seçim!");
            return;
        }

        try {
            File dosya = new File(dosyaAdi);
            if (!dosya.exists()) {
                System.out.println("Çanta boş. Önce dünyadan loot toplayın (Menü 1).");
                return;
            }

            Path filePath = dosya.toPath();
            List<String> stringList = Files.readAllLines(filePath, Charset.defaultCharset());

            // HİZALAMA SİSTEMİ
            System.out.printf("%-4s | %-20s | %-10s | %-10s | %s\n", "ID", "AD", "TÜR", "AĞIRLIK", "DURUM");
            System.out.println("-------------------------------------------------------------------");

            if (secim2 == 1) {
                System.out.print("Tür girin (SILAH, GIDA, SAGLIK, MALZEME): ");
                String arananTur = giris.nextLine().toUpperCase();

                for (String satir : stringList) {
                    String[] parcalar = satir.split(";");
                    if (parcalar.length >= 5 && parcalar[2].toUpperCase().contains(arananTur)) {
                        System.out.printf("%-4s | %-20s | %-10s | %-7s kg | %%%s\n", parcalar[0], parcalar[1], parcalar[2], parcalar[3], parcalar[4]);
                    }
                }
            } else if (secim2 == 2) {
                System.out.print("Maksimum ağırlık sınırını girin (Örn: 2.0): ");
                double maxAgirlik = giris.nextDouble();

                for (String satir : stringList) {
                    String[] parcalar = satir.split(";");
                    if (parcalar.length >= 5) {
                        double mevcutAgirlik = Double.parseDouble(parcalar[3]);
                        if (mevcutAgirlik <= maxAgirlik) {
                            System.out.printf("%-4s | %-20s | %-10s | %-7s kg | %%%s\n", parcalar[0], parcalar[1], parcalar[2], parcalar[3], parcalar[4]);
                        }
                    }
                }
            } else if (secim2 == 3) {
                for (String satir : stringList) {
                    String[] parcalar = satir.split(";");
                    if (parcalar.length >= 5) {
                        System.out.printf("%-4s | %-20s | %-10s | %-7s kg | %%%s\n", parcalar[0], parcalar[1], parcalar[2], parcalar[3], parcalar[4]);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Listeleme hatası! Önce loot toplayın.");
        }
    }

    public static void guncelle(Scanner giris) {
        try {
            File dosya = new File(dosyaAdi);
            if (!dosya.exists()) {
                System.out.println("Güncellenecek eşya yok, çanta boş.");
                return;
            }
            Path filePath = dosya.toPath();
            List<String> stringList = Files.readAllLines(filePath, Charset.defaultCharset());

            System.out.print("Tamir edilecek eşyanın tam adını giriniz: ");
            String arananAd = giris.nextLine();
            String cevap;
            boolean bulundu = false;

            for (int i = 0; i < stringList.size(); i++) {
                String satir = stringList.get(i);
                String[] parcalar = satir.split(";");

                if (parcalar.length >= 5 && parcalar[1].equalsIgnoreCase(arananAd)) {
                    System.out.println("Bulunan Eşya: " + parcalar[0] + " - " + parcalar[1] + " (" + parcalar[2] + ") " + parcalar[3] + "kg Durum:%" + parcalar[4]);
                    System.out.print("Değiştirmek istediğiniz veri bu mu?(e/h): ");
                    cevap = giris.nextLine();

                    if (cevap.toLowerCase().equals("e")) {
                        System.out.print("Yeni dayanıklılık durumunu giriniz (%0-100): ");
                        String yeniDurum = giris.nextLine();

                        String yeniSatir = parcalar[0] + ";" + parcalar[1] + ";" + parcalar[2] + ";" + parcalar[3] + ";" + yeniDurum;
                        stringList.set(i, yeniSatir);
                        bulundu = true;
                        logYaz(parcalar[1] + " isimli eşyanın durumu güncellendi.");
                        break;
                    } else {
                        System.out.println("İşlem iptal edildi.");
                        return;
                    }
                }
            }

            if (!bulundu) {
                System.out.println("Aradığınız eşya çantada bulunamadı.");
                return;
            }


            FileWriter fw = new FileWriter(dosyaAdi, false);
            for (String listeSatiri : stringList) {
                fw.write(listeSatiri + "\n");
            }
            fw.close();
            System.out.println("Eşya başarıyla güncellendi.");

        } catch (Exception e) {
            System.out.println("Güncelleme işlemi sırasında hata oluştu.");
        }
    }

    public static void sil(Scanner giris) {
        try {
            File dosya = new File(dosyaAdi);
            if (!dosya.exists()) {
                System.out.println("Silinecek eşya yok, çanta boş.");
                return;
            }
            Path filePath = dosya.toPath();
            List<String> stringList = Files.readAllLines(filePath, Charset.defaultCharset());

            System.out.print("Çöpe atmak (silmek) istediğiniz eşyanın tam adını giriniz: ");
            String arananAd = giris.nextLine();
            String cevap;
            boolean bulundu = false;

            for (int i = 0; i < stringList.size(); i++) {
                String satir = stringList.get(i);
                String[] parcalar = satir.split(";");

                if (parcalar.length >= 5 && parcalar[1].equalsIgnoreCase(arananAd)) {
                    System.out.println("Bulunan Eşya: " + parcalar[0] + " - " + parcalar[1] + " (" + parcalar[2] + ") " + parcalar[3] + "kg Durum:%" + parcalar[4]);
                    System.out.print("Silmek istediğiniz veri bu mu?(e/h): ");
                    cevap = giris.nextLine();

                    if (cevap.toLowerCase().equals("e")) {
                        stringList.remove(i);
                        bulundu = true;
                        logYaz(parcalar[1] + " isimli eşya çöpe atıldı.");
                        break;
                    } else {
                        System.out.println("İşlem iptal edildi.");
                        return;
                    }
                }
            }

            if (!bulundu) {
                System.out.println("Aradığınız eşya çantada bulunamadı.");
                return;
            }


            FileWriter fw = new FileWriter(dosyaAdi, false);
            for (String listeSatiri : stringList) {
                fw.write(listeSatiri + "\n");
            }
            fw.close();
            System.out.println("Eşya başarıyla çantadan atıldı (silindi).");

        } catch (Exception e) {
            System.out.println("Silme işlemi sırasında hata oluştu.");
        }
    }

    // EKSTRA ÖZELLİK 2: TARİHSEL İŞLEMLER VE LOGLAMA
    public static void logYaz(String mesaj) {
        try {

            LocalDateTime simdi = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String tarihZaman = simdi.format(format);

            FileWriter fw = new FileWriter(logDosyasi, true);
            fw.write("[" + tarihZaman + "] " + mesaj + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Log dosyasına yazılamadı.");
        }
    }

    // EKSTRA ÖZELLİK 3: LOGLARI GÖRÜNTÜLEME
    public static void logOku() {
        System.out.println("\nSİSTEM LOG KAYITLARI");
        try {
            File dosya = new File(logDosyasi);
            if (!dosya.exists()) {
                System.out.println("Henüz bir log kaydı bulunmuyor.");
                return;
            }
            Path filePath = dosya.toPath();
            List<String> logListesi = Files.readAllLines(filePath, Charset.defaultCharset());

            for (String satir : logListesi) {
                System.out.println(satir);
            }
            System.out.println("----------------------------");
        } catch (Exception e) {
            System.out.println("Loglar okunurken hata oluştu.");
        }
    }
}