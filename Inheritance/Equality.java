package Inheritance;

import java.sql.Date;

public class Equality {
    static class Hall{
       private String name;
       private long contactNumber;
       private Double costPerDay;
       private String ownerName;
       private Date bookingDate;

       Hall(){}
       Hall(String name, Long contactNumber, Double costPerDay, String ownerName, Date bookingDate) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.costPerDay = costPerDay;
        this.ownerName = ownerName;
        this.bookingDate = bookingDate;
       }
       public String getName() {
           return name;
       }
       public long getContactNumber() {
           return contactNumber;
       }
       public Double getCostPerDay() {
           return costPerDay;
       }
       public String getOwnerName() {
           return ownerName;
       }
       public Date getBookingDate() {
           return bookingDate;
       }
       public void setName(String name) {
           this.name = name;
       }
       public void setContactNumber(long contactNumber) {
           this.contactNumber = contactNumber;
       }
       public void setCostPerDay(Double costPerDay) {
           this.costPerDay = costPerDay;
       }
       public void setOwnerName(String ownerName) {
           this.ownerName = ownerName;
       }
       public void setBookingDate(Date bookingDate) {
           this.bookingDate = bookingDate;
       }

       @Override
       public boolean equals(Object obj) {
           if (this == obj)
               return true;
           if (obj == null || getClass() != obj.getClass())
               return false;
           Hall hall = (Hall) obj;
           if(this.name.equals(hall.name) && this.contactNumber==hall.contactNumber && this.costPerDay==hall.costPerDay && this.ownerName.equals(hall.ownerName) && this.bookingDate==hall.bookingDate) return true;

           return false;
       }

    }

    public static void main(String[] args) {
        Hall h1 = new Hall(
            "Jatin",
            82849698L,
            1800.0,
            "JATIN",
            Date.valueOf("2025-05-28")
        );
        Hall h2 = new Hall( "Jatin",
            82849698L,
            1800.0,
            "JATI",
            Date.valueOf("2025-05-28"));

        System.out.println(h1.equals(h1));

    }
    
}
