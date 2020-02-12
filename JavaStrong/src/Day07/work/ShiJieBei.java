package Day07.work;

public class ShiJieBei {

    //举办年份	举办地点	冠军
    private String name;
    private String address;
    private String champion;

    public ShiJieBei() {
    }

    public ShiJieBei(String name, String address, String champion) {
        this.name = name;
        this.address = address;
        this.champion = champion;
    }

    public String getYear() {
        return name;
    }

    public void setYear(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    @Override
    public String toString() {
        return "ShiJieBei{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", champion='" + champion + '\'' +
                '}';
    }
}
