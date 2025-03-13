package tuan4;

public class Staff extends Person {
	private String school;
    private Double pay;

    public Staff(String name,String address, String school, Double pay) {
        super(name,address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff{" +

                "Name"+super.getName()+"address: "+super.getAddress()+"school"+ school + '\'' +
                ", pay=" + pay +
                '}';
    }

}
