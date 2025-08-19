package Inheritance;

public class c {
    public static class Customer{
        private String customerName;
        private String customerEmail;
        private String customerType;
        private String customerLocation;

        public void setCustomerName(String customerName){
            this.customerName = customerName;
        }
        public void setCustomerType(String customerType){
            this.customerType = customerType;
        }
        public void setCustomerEmail(String customerEmail){
            this.customerEmail = customerEmail;
        }
        public void setCustomerLocation(String customerLocation){
            this.customerLocation = customerLocation;
        }

        public String getCustomerName(){
            return customerName;

        }
        public String getCustomerEmail(){
            return customerEmail;

        }
        public String getCustomerType(){
            return customerType;

        }
        public String getCustomerLocation(){
            return customerLocation;

        }
    }
    public static void main(String[] args) {
        Customer cus = new Customer();
        cus.setCustomerName("Jatin Sharma");
        System.out.println(cus.getCustomerName());
    }
}
