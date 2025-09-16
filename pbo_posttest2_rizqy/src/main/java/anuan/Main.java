package anuan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Service service = new Service();

    public static void main(String[] args) {
        int pilihan = 0;

        System.out.println("==============================================");
        System.out.println("Selamat Datang di Daftar Musik Hipdut Favorit!");
        System.out.println("==============================================");

        while (pilihan != 6) {
            System.out.println("\n===== MANAJEMEN DAFTAR MUSIK PRIBADI =====");
            System.out.println("1. Tambah Musik");
            System.out.println("2. Lihat Daftar Musik");
            System.out.println("3. Update Musik");
            System.out.println("4. Hapus Musik");
            System.out.println("5. Cari Musik");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = validasiInt();

            switch (pilihan) {
                case 1 -> tambahMusik();
                case 2 -> lihatMusik();
                case 3 -> ubahMusik();
                case 4 -> hapusMusik();
                case 5 -> cariMusik();
                case 6 -> System.out.println("Bye-bye beb, see you later!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static int validasiInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Masukkan angka yang valid: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static void tambahMusik() {
        sc.nextLine();
        System.out.print("Judul: ");
        String judul = sc.nextLine().trim();
        System.out.print("Artis: ");
        String artis = sc.nextLine().trim();
        System.out.print("Genre: ");
        String genre = sc.nextLine().trim();

        if (judul.isEmpty() || artis.isEmpty() || genre.isEmpty()) {
            System.out.println("Semua field harus diisi!");
            return;
        }

        service.tambahMusik(new Musik(judul, artis, genre));
        System.out.println("Musik berhasil ditambahkan.");
    }

    private static void lihatMusik() {
        ArrayList<Musik> daftar = service.getDaftarMusik();
        if (daftar.isEmpty()) {
            System.out.println("Daftar musik kosong!");
        } else {
            System.out.println("\n=== Playlist Hipdut Asik ===");
            for (int i = 0; i < daftar.size(); i++) {
                System.out.println((i + 1) + ". " + daftar.get(i));
            }
        }
    }

    private static void ubahMusik() {
        lihatMusik();
        ArrayList<Musik> daftar = service.getDaftarMusik();
        if (daftar.isEmpty()) return;

        System.out.print("Pilih nomor musik yang ingin diubah: ");
        int index = validasiInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= daftar.size()) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        System.out.print("Judul baru: ");
        String judul = sc.nextLine().trim();
        System.out.print("Artis baru: ");
        String artis = sc.nextLine().trim();
        System.out.print("Genre baru: ");
        String genre = sc.nextLine().trim();

        if (judul.isEmpty() || artis.isEmpty() || genre.isEmpty()) {
            System.out.println("Semua field harus diisi!");
            return;
        }

        if (service.ubahMusik(index, new Musik(judul, artis, genre))) {
            System.out.println("Musik berhasil diubah.");
        } else {
            System.out.println("Gagal mengubah musik.");
        }
    }

    private static void hapusMusik() {
        lihatMusik();
        ArrayList<Musik> daftar = service.getDaftarMusik();
        if (daftar.isEmpty()) return;

        System.out.print("Pilih nomor musik yang ingin dihapus: ");
        int index = validasiInt() - 1;
        if (service.hapusMusik(index)) {
            System.out.println("Musik berhasil dihapus.");
        } else {
            System.out.println("Nomor tidak valid.");
        }
    }

    private static void cariMusik() {
        sc.nextLine();
        System.out.print("Masukkan judul yang dicari: ");
        String keyword = sc.nextLine().trim();

        ArrayList<Musik> hasil = service.cariMusik(keyword);
        if (hasil.isEmpty()) {
            System.out.println("Tidak ada musik dengan judul \"" + keyword + "\".");
        } else {
            System.out.println("Hasil pencarian:");
            for (Musik m : hasil) {
                System.out.println("- " + m);
            }
        }
    }
}
