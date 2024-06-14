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
public class DienThoaiThongMinh extends DienThoai {
    private String congNgheManHinh;
    private String camBien;
    
    public DienThoaiThongMinh(){
        
    }
    public DienThoaiThongMinh(String maDienThoai,String tenDienThoai,double donGia,String maThuongHieu,int soLuong,String donViTinh,String heDieuHanh,int ram,int maLoaiSanPham,String congNgheManHinh,String camBien){
        super(maDienThoai,tenDienThoai,donGia,maThuongHieu,soLuong,donViTinh,heDieuHanh,ram,maLoaiSanPham);
        this.congNgheManHinh = congNgheManHinh;
        this.camBien = camBien;
    }
    
    public String getCongNgheManHinh(){
        return congNgheManHinh;
    }
    
    public void setCongNgheManHinh(String congNgheManHinh){
        this.congNgheManHinh = congNgheManHinh;
    }
    
    public String getCamBien(){
        return camBien;
    }
    
    public void setCamBien(String camBien){
        this.camBien = camBien;
    }
    
    @Override public void input(){
        super.input();
        System.out.print("Cong Nghe Man Hinh : ");
        congNgheManHinh = sc.nextLine();
        System.out.print("Cam Bien : ");
        camBien = sc.nextLine();
    }
    @Override public String toString(){
        return super.toString() + "Cong Nghe Man Hinh : "+getCongNgheManHinh() +"\n" + "Cam Bien : "+getCamBien()+"\n";
    }
    
    @Override void ghiFile() throws IOException{
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream ("dienthoai.txt",Boolean.TRUE));
        super.ghiFile();
        outStream.writeUTF(congNgheManHinh);
        outStream.writeUTF(camBien);
    }
}
