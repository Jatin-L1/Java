package OOPS.Lec_Six;

public class EnumBasic {
    enum Week{
        Monday , Tuesday , Wednesday , Thursday , Friday , Saturday ,Sunday;
        // these are enum constants
        // public , static and final
        // since its final you can create child enums \
        // type is week

        Week(){
            System.out.println("Constructor called for" + this);
        }
        // this is not public or protected , only private aor defeault
        // why? we dont want to create new objects
        // this is not the enum concept, that'se why

        // internally: public static final Week Monday = new Week();
    }
    public static void main(String[] args) {
        Week week;
        week = Week.Monday;
        for(Week day : Week.values()){
            System.out.println(day);
        }

        System.out.println(week);
    }
    
}
