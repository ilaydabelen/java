package main;
class ElitUye extends Uye {
    public ElitUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
    }

    public String toString() {
        return "Elit\t" + super.toString();
    }
}


