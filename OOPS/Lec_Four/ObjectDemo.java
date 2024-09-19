package OOPS.Lec_Four;

public class ObjectDemo {
    int n = 34;
    public ObjectDemo(int n) {
        this.n = n;
    }
    
    public static void main(String[] args) {
        ObjectDemo obj =new ObjectDemo(34); 
        ObjectDemo obj1 =obj; 
        System.out.println(obj.hashCode());
        System.out.println(obj1.hashCode());

        System.out.println(obj instanceof ObjectDemo);
        System.out.println(obj.getClass());
        }

    @Override
    public int hashCode() {
        return super.hashCode();
        // return n;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ObjectDemo other = (ObjectDemo) obj;
        if (n != other.n)
            return false;
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
