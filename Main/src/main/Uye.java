package main;
class Uye {
    String isim;
    String soyisim;
    String email;

    public Uye(String isim, String soyisim, String email) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
    }

    public String toString() {
        return this.isim + "\t" + this.soyisim + "\t" + this.email;
    }
}
