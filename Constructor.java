public class Constructor {
    public static void main(String[] args) {
        Data tharvesh = new Data(113, 66);
        System.out.println("    ID: " + tharvesh.id + ", Marks: " + tharvesh.getMark());
        Data anish = new Data(114, 99);
        System.out.println("    ID: " + anish.id + ", Marks: " + anish.getMark());
    }    
}

class Data{
    protected int id;
    private int mark;
    Data(int roll, int val){
        //default vlaues
        id = roll;
        mark = val;
    }

    int getMark(){
        return mark;
    }
}