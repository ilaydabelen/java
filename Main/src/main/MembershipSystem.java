package main;
import java.io.*;
import java.util.*;

public class MembershipSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1- Elit uye ekleme");
            System.out.println("2- Genel uye ekleme");
            System.out.println("3- Mail gonderme");
            System.out.println("0- Cikis");
            System.out.print("Seciminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Programdan cikiliyor...");
                break;
            } else if (choice == 1) {
                addEliteMember(scanner);
            } else if (choice == 2) {
                addRegularMember(scanner);
            } else if (choice == 3) {
                sendMail(scanner);
            } else {
                System.out.println("Hatali secim!");
            }
        }

        scanner.close();
    }

    private static void addEliteMember(Scanner scanner) {
        try {
            FileWriter writer = new FileWriter("kullanicilar.txt", true);
            System.out.print("Isim: ");
            String name = scanner.nextLine();
            System.out.print("Soyisim: ");
            String surname = scanner.nextLine();
            System.out.print("E-posta: ");
            String email = scanner.nextLine();
            ElitUye elitUye = new ElitUye(name, surname, email);
            writer.write(elitUye.toString() + "\n");
            writer.close();
            System.out.println("Elit uye basariyla eklendi!");
        } catch (IOException e) {
            System.out.println("Dosya yazma hatasi!");
        }
    }

    private static void addRegularMember(Scanner scanner) {
        try {
            FileWriter writer = new FileWriter("kullanicilar.txt", true);
            System.out.print("Isim: ");
            String name = scanner.nextLine();
            System.out.print("Soyisim: ");
            String surname = scanner.nextLine();
            System.out.print("E-posta:");
            String email = scanner.nextLine();
            GenelUye genelUye = new GenelUye(name, surname, email);
            writer.write(genelUye.toString() + "\n");
            writer.close();
            System.out.println("Genel uye basariyla eklendi!");
          } catch (IOException e) {
            System.out.println("Dosya yazma hatasi!");
          }
    }
    private static void sendMail(Scanner scanner) {
        System.out.println("Mail gonderme secenekleri:");
        System.out.println("1- Elit uyelere mail");
        System.out.println("2- Genel uyelere mail");
        System.out.println("3- Tum uyelere mail");
        System.out.print("Seçiminiz: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Mail basligi: ");
        String subject = scanner.nextLine();
        System.out.print("Mail icerigi: ");
        String content = scanner.nextLine();
        
        try {
            FileReader reader;
            if (choice == 1) {
                reader = new FileReader("kullanicilar.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts[0].equals("Elit Uye:")) {
                        String email = parts[2];
                        sendMail(email, subject, content);
                    }
                }
                bufferedReader.close();
                System.out.println("Mail basariyla gonderildi!");
            } else if (choice == 2) {
                reader = new FileReader("kullanicilar.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    if (parts[0].equals("Genel Uye:")) {
                        String email = parts[2];
                        sendMail(email, subject, content);
                    }
                }
                bufferedReader.close();
                System.out.println("Mail başarıyla gönderildi!");
            } else if (choice == 3) {
                reader = new FileReader("kullanicilar.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split("\t");
                    String email = parts[2];
                    sendMail(email, subject, content);
                }
                bufferedReader.close();
                System.out.println("Mail başarıyla gönderildi!");
            } else {
                System.out.println("Hatalı seçim!");
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası!");
        }
    }

	private static void sendMail(String email, String subject, String content) {
		// TODO Auto-generated method stub
		
	}
}
           