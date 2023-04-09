package main;
class GenelUye extends Uye {
    public GenelUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
    }

    public String toString() {
        return "Genel\t" + super.toString();
    }
}
