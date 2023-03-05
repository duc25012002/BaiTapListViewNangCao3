package com.hdcompany.android02b1.listviewnangcaobai3.model;

public class DocGia {
    private String maDocGia;
    private String tenDocGia;
    private int gioiTinhDocGia;

    private boolean checked;

    public DocGia(String maDocGia, String tenDocGia, int gioiTinhDocGia, boolean checked) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.gioiTinhDocGia = gioiTinhDocGia;
        this.checked = checked;
    }

    public DocGia() {
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public int getGioiTinhDocGia() {
        return gioiTinhDocGia;
    }

    public void setGioiTinhDocGia(int gioiTinhDocGia) {
        this.gioiTinhDocGia = gioiTinhDocGia;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
