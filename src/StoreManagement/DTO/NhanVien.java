
package StoreManagement.DTO;

public class NhanVien {

    private String maNV;
    private String ten;
    private String gioiTinh;    

    public NhanVien() {
    }

    public NhanVien(String maNV, String ten, String gioiTinh) {
        this.maNV = maNV;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

}

