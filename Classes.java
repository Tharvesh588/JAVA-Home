// protected access modifier la declear panna , intha package la mattum thaan access panna mudiyum
class Data{
    private String name;
    private int roll; // intha variable la data class outside access panna mudiyadhu
    public void displayDetails(){
        System.out.println("Name: " + name);
        System.out.println("Id: " + roll);
    }
    public void setData(String str, int num) {
        name = str;
        roll = num;
    }
}

class Classes {
    public static void main(String[] args) {
        Data tharvesh = new Data();
        tharvesh.setData("Tharvesh", 113);
        tharvesh.displayDetails();

        Data tutor = new Data();
        tutor.setData("Anvar", 201667);
        tutor.displayDetails();
        
    }
}
