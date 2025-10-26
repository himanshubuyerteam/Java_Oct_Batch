import OOPS2.Doctor;

class NurseData  extends DoctorClass{
    int nurseId;
    NurseData(int nurseId){
        this.nurseId=nurseId;
    }
}
public class Nurse {
   public static void main(String[] args) {
    NurseData nd=new NurseData(1);
    nd.age=100;
    System.out.println(nd.age);
   }

}
