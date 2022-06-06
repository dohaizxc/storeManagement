/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StoreManagement.DAO;

import StoreManagement.DTO.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

/**
 *
 * @author thanh
 */
public class SanPhamDAO {
        
    public ArrayList<SanPham> getListSanPham() {
        try {
            String sql = "SELECT * FROM SanPham";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<SanPham> dssp = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setDonViTinh(rs.getString(3));
                sp.setDonGia(rs.getFloat(4));
                sp.setSoLuong(rs.getInt(5));

                dssp.add(sp);
            }
            return dssp;
        } catch (SQLException e) {
        }

        return null;
    }

    public SanPham getSanPham(String ma) {
        try {
            String sql = "SELECT * FROM SanPham WHERE MaSP=?";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            pre.setString(1, ma);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                SanPham sp = new SanPham();

                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setDonViTinh(rs.getString(3));
                sp.setDonGia(rs.getFloat(4));
                sp.setSoLuong(rs.getInt(5));


                return sp;
            }
        } catch (SQLException e) {
        }

        return null;
    }
    public boolean updateQuantitySP(String ma, int soLuongMat) {
        SanPham sp = getSanPham(ma);
        int soLuong = sp.getSoLuong();
        sp.setSoLuong(soLuong - soLuongMat);
        try {
            String sql = "UPDATE SanPham SET SOLUONG=? WHERE MaSP=?";
            PreparedStatement pre = MyConnect.getJDBCConection().prepareStatement(sql);
            pre.setInt(1, sp.getSoLuong());
            pre.setString(2, sp.getMaSP());
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean themSanPham(SanPham sp) {
        try {
            String sql = "INSERT INTO SanPham(TenSP, DonViTinh, DonGia, SoLuong) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre =MyConnect.getJDBCConection().prepareStatement(sql);
            pre.setString(1, sp.getTenSP());
            pre.setString(2, sp.getDonViTinh());
            pre.setFloat(3, sp.getDonGia());
            pre.setInt(4, sp.getSoLuong());

            pre.execute();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }
}
