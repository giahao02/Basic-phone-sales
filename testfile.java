/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to 
change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DienThoai;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.*;
/**
 *
 * @author hp
 */
public class testfile {
    public static void main(String[] args) throws IOException {
        DSDT a = new DSDT();
//        a.nhapThongTinDienThoai();
//        a.ghiFile();
        a.docFile();
        a.xuatThongTinDienThoai();
    }
}
