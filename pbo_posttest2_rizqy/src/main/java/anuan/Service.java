package anuan;

import java.util.ArrayList;

public class Service {
    private ArrayList<Musik> daftarMusik = new ArrayList<>();

    public void tambahMusik(Musik musik) {
        daftarMusik.add(musik);
    }

    public ArrayList<Musik> getDaftarMusik() {
        return daftarMusik;
    }

    public boolean ubahMusik(int index, Musik musikBaru) {
        if (index >= 0 && index < daftarMusik.size()) {
            daftarMusik.set(index, musikBaru);
            return true;
        }
        return false;
    }

    public boolean hapusMusik(int index) {
        if (index >= 0 && index < daftarMusik.size()) {
            daftarMusik.remove(index);
            return true;
        }
        return false;
    }

    public ArrayList<Musik> cariMusik(String keyword) {
        ArrayList<Musik> hasil = new ArrayList<>();
        for (Musik m : daftarMusik) {
            if (m.getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                hasil.add(m);
            }
        }
        return hasil;
    }
}
