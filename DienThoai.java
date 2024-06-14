/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DienThoai;

import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author hp
 */
public class DienThoai {

    private String maDienThoai;
    private String tenDienThoai;
    private double donGia; 
    private String maThuongHieu;
    private int soLuong;
    private String donViTinh;
    private String heDieuHanh;
    private int ram;
    private int maLoaiSanPham;
    Scanner sc = new Scanner(System.in);
//    private static int instance = 0;

    public DienThoai() {
//        instance++;
    }
    

    public DienThoai(String maDienThoai, String tenDienThoai, double donGia, String maThuongHieu, int soLuong, String donViTinh, String heDieuHanh, int ram, int maLoaiSanPham) {
        this.maDienThoai = maDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.donGia = donGia;
        this.maThuongHieu = maThuongHieu;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.heDieuHanh = heDieuHanh;
        this.ram = ram;
        this.maLoaiSanPham = maLoaiSanPham;
    }

    DienThoai(DienThoai dt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaDienThoai() {
        return maDienThoai;
    }

    public void setMaDienThoai(String maDienThoai) {
        this.maDienThoai = maDienThoai;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public void input() {
        System.out.println("-------------------------");
        System.out.print("Ma Loai San Pham :");
        maLoaiSanPham = sc.nextInt();
        sc.nextLine();
        System.out.print("Ma dien thoai : ");
        maDienThoai = sc.nextLine();
        System.out.print("Ten Dien Thoai : ");
        tenDienThoai = sc.nextLine();
        System.out.print("Ma Thuong Hieu :");
        maThuongHieu = sc.nextLine();
        System.out.print("He Dieu Hanh : ");
        heDieuHanh = sc.nextLine();
        System.out.print("Ram : ");
        ram = sc.nextInt();
        System.out.print("So Luong : ");
        soLuong = sc.nextInt();
        sc.nextLine();
        System.out.print("Don Gia : ");
        donGia = sc.nextDouble();
        sc.nextLine();
        System.out.print("Don Vi Tinh : ");
        donViTinh = sc.nextLine();
    }

    @Override
    public String toString() {
        return "----------------\n" + "Ma Loai San Pham : " + getMaLoaiSanPham() + "\n" + "Ma Dien Thoai :" + getMaDienThoai() + "\n" + "Ten Dien Thoai : " + getTenDienThoai() + "\n" + "Ma Thuong Hieu : " + getMaThuongHieu() + "\n"
                + "He Dieu Hanh : " + getHeDieuHanh() + "\n" + "Ram : " + getRam() + "Gb" + "\n"
                + "So Luong : " + getSoLuong() + "\n" + "Don Gia : " + getDonGia() + "\n" + "Don Vi Tinh : " + getDonViTinh() + "\n";

    }

    void ghiFile() throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("dienthoai.txt", Boolean.TRUE));
        outStream.writeInt(maLoaiSanPham);
        outStream.writeUTF(maDienThoai);
        outStream.writeUTF(tenDienThoai);
        outStream.writeUTF(maThuongHieu);
        outStream.writeUTF(heDieuHanh);
        outStream.writeInt(ram);
        outStream.writeInt(soLuong);
        outStream.writeDouble(donGia);
        outStream.writeUTF(donViTinh);
        outStream.close();
    }

}
