package applicantion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservantion;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date(dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservantion reservantion = new Reservantion(number, checkIn, checkOut);
            System.out.println("Reservantion: " + reservantion);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in date (dd/MM/yyyy): ");
            sc.nextLine();
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out  date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservantion.UpdateDates(checkIn, checkOut);
            System.out.println("Reservantion" + reservantion);

        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println("Error in reservantion" + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}
