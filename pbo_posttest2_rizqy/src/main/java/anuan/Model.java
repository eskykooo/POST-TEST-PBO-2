package anuan;

public class Musik {
    private String judul;
    private String artis;
    private String genre;

    public Musik(String judul, String artis, String genre) {
        this.judul = judul;
        this.artis = artis;
        this.genre = genre;
    }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getArtis() { return artis; }
    public void setArtis(String artis) { this.artis = artis; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return judul + " - " + artis + " [" + genre + "]";
    }
}

