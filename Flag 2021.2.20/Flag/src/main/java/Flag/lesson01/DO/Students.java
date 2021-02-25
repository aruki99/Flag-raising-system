package Flag.lesson01.DO;

public class Students {
    String name;
    String yiban_id;
    int paiWei;

    public Students(String yiban_id, String name, int paiWei) {
        this.paiWei = paiWei;
        this.name = name;
        this.yiban_id = yiban_id;
    }

    public int getPaiWei() {
        return paiWei;
    }

    public void setPaiWei(int paiWei) {
        this.paiWei = paiWei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYiban_id() {
        return yiban_id;
    }

    public void setYiban_id(String yiban_id) {
        this.yiban_id = yiban_id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + paiWei + '\'' +
                "name='" + name + '\'' +
                "zhanghao='" + yiban_id + '\'' +
                '}';
    }
}
