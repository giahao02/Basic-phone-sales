/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DienThoai;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author hp
 */
public class DienThoaiPhoThong extends DienThoai {
    private int kichThuocManHinh;
    private int trongLuong;
    
    public DienThoaiPhoThong(){
        
    }
    
    public DienThoaiPhoThong(String maDienThoai,String tenDienThoai,double donGia,String maThuongHieu,int soLuong,String donViTinh,String heDieuHanh,int ram,int maLoaiSanPham, int kichThuocManHinh, int trongLuong){
        super(maDienThoai,tenDienThoai,donGia,maThuongHieu,soLuong,donViTinh,heDieuHanh,ram,maLoaiSanPham);
        this.kichThuocManHinh = kichThuocManHinh;
        this.trongLuong = trongLuong;
    }
    
    public int getKichThuocManHinh(){
        return kichThuocManHinh;
    }
    
    public void setKichThuocManHinh(int kichthuocmanhinh){
        this.kichThuocManHinh = kichthuocmanhinh;
    }
    
    public int getTrongLuong(){
        return trongLuong;
    }
    
    public void setTrongLuong(int trongLuong){
        this.trongLuong = trongLuong;
    }
    
    @Override public void input(){
        super.input();
        System.out.print("Kich Thuoc Man Hinh : ");
        kichThuocManHinh = sc.nextInt();
        System.out.print("Trong Luong : ");
        trongLuong = sc.nextInt();
    }
    
    @Override public String toString(){
        return super.toString() + "Kich Thuoc Man Hinh : "+getKichThuocManHinh() +"\n" +"Trong Luong : "+getTrongLuong() +"\n";
    }
    
    
    @Override void ghiFile() throws IOException{
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream ("dienthoai.txt",Boolean.TRUE));
        super.ghiFile();
        outStream.writeInt(kichThuocManHinh);
        outStream.writeInt(trongLuong);
    }
}
