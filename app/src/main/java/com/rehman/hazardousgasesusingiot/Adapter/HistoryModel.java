package com.rehman.hazardousgasesusingiot.Adapter;

public class HistoryModel
{
    String DateTime;
    String VHumidity;
    String VMQ137;
    String Id;
    String VMQ2;
    String VMQ3;
    String VMQ4;
    String VMQ5;
    String VMQ6;
    String Vtemp;
    String img;


    public HistoryModel(String dateTime, String VHumidity, String VMQ137, String id, String VMQ2, String VMQ3, String VMQ4, String VMQ5, String VMQ6, String vtemp, String img) {
        DateTime = dateTime;
        this.VHumidity = VHumidity;
        this.VMQ137 = VMQ137;
        Id = id;
        this.VMQ2 = VMQ2;
        this.VMQ3 = VMQ3;
        this.VMQ4 = VMQ4;
        this.VMQ5 = VMQ5;
        this.VMQ6 = VMQ6;
        Vtemp = vtemp;
        this.img = img;
    }

    public HistoryModel() {
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getVHumidity() {
        return VHumidity;
    }

    public void setVHumidity(String VHumidity) {
        this.VHumidity = VHumidity;
    }

    public String getVMQ137() {
        return VMQ137;
    }

    public void setVMQ137(String VMQ137) {
        this.VMQ137 = VMQ137;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVMQ2() {
        return VMQ2;
    }

    public void setVMQ2(String VMQ2) {
        this.VMQ2 = VMQ2;
    }

    public String getVMQ3() {
        return VMQ3;
    }

    public void setVMQ3(String VMQ3) {
        this.VMQ3 = VMQ3;
    }

    public String getVMQ4() {
        return VMQ4;
    }

    public void setVMQ4(String VMQ4) {
        this.VMQ4 = VMQ4;
    }

    public String getVMQ5() {
        return VMQ5;
    }

    public void setVMQ5(String VMQ5) {
        this.VMQ5 = VMQ5;
    }

    public String getVMQ6() {
        return VMQ6;
    }

    public void setVMQ6(String VMQ6) {
        this.VMQ6 = VMQ6;
    }

    public String getVtemp() {
        return Vtemp;
    }

    public void setVtemp(String vtemp) {
        Vtemp = vtemp;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
