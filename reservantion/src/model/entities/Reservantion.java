package model.entities;
import org.w3c.dom.DOMException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;
public class Reservantion {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservantion(Integer roomNumber, Date checkIn, Date checkOut){
        if(!checkOut.after(checkIn)){
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber){
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn(){
        return checkIn;
    }
    public Date getCheckOut(){
        return checkOut;
    }

    //n tenho set do checkin e checkout pq ele só pode ser alterado pelo metodo update

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void UpdateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("Reservantion dates for update must be future dates");
        }
        else if(!checkOut.after(checkIn)){
            throw new DomainException("Check out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString(){
        return "Room "
                +roomNumber
                + ", check-in: "
                +sdf.format(checkIn)
                +", check-out: "
                +sdf.format(checkOut)
                + ","
                + duration()
                + " nights";
    }
}
