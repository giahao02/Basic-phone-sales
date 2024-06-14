package DienThoai;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSHoaDon {
	private HoaDon[]  dshd = new HoaDon[0];
	private int n;
	private	DSChiTietHoaDon dscthd = new DSChiTietHoaDon(); 
	public DSHoaDon() {}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong hoa don:");
		n = sc.nextInt();
		dshd = new HoaDon[n];
		for(int i=0;i<n;i++) {
			dshd[i] = new HoaDon();
			dshd[i].nhap();
		}
	}
	
	public void ghiFile() throws IOException {
		DataOutputStream outStream 
			= new DataOutputStream(new FileOutputStream("hoadon.txt"));
		outStream.writeInt(dshd.length);
		for(int i=0;i<dshd.length;i++) {
			dshd[i].ghiFile();
		}
		dscthd.ghiFile();
		outStream.close();
	}
		
	public void docFile() {
		int i = 0;
		try {
			DataInputStream inStream 
				= new DataInputStream (new FileInputStream("hoadon.txt"));
			int n = inStream.readInt();
			dshd = new HoaDon[n];
			try {
				while(true) {
					String mahoadon = inStream.readUTF();
					String makh = inStream.readUTF();
					String manv = inStream.readUTF();
					String ngaylap = inStream.readUTF();
					double tongtien = inStream.readDouble();
					dshd[i] = new HoaDon(mahoadon,makh,manv,ngaylap,tongtien);
					i++;
				}
			}catch(EOFException e) {
			}	
			finally {
				dscthd.docFile();
				inStream.close();
			}
		}catch(IOException e) {
		}
	}
	
	public void xuat() {
		if(dshd.length == 0) System.out.println("Danh sach rong");
		else {
			for(int i=0;i<dshd.length;i++) {
				dshd[i].xuat();
			}
		}
	}
	

	public int checkTrungMaHoaDon(String mahoadon) {
		for(int i=0;i<dshd.length;i++) {
			if(mahoadon.equals(dshd[i].getMahoadon())==true)
				return 1;
		}
		return 0;
	}
	
	public void them(String makh) {
		if(dshd.length == 0) {
			dshd = new HoaDon[1];
			dshd[0] = new HoaDon("3001",makh);
			dshd[0].nhap();
			dscthd.them(dshd[0].getMahoadon());
			ChiTietHoaDon[] ds1 =  dscthd.getChiTietHoaDon();
			double sum = 0;
			for(int i=0;i<ds1.length;i++)
				if( ("3001".equals(ds1[i].getMahoadon()) )== true) {
					sum = sum + ds1[i].getThanhtien() + ds1[i].getThue();
				}
			dshd[n].setTongtien(sum);
		}
		else {
				n = dshd.length;
				dshd = Arrays.copyOf(dshd,dshd.length+1);
				int ma = Integer.parseInt(dshd[n-1].getMahoadon()) + 1 ;
				String mahoadon = Integer.toString(ma);
				dshd[n] = new HoaDon(mahoadon,makh);
				dshd[n].nhap();
				dscthd.them(dshd[n].getMahoadon());
				ChiTietHoaDon[] ds1 =  dscthd.getChiTietHoaDon();
				double sum = 0;
				for(int i=0;i<ds1.length;i++)
					if( (mahoadon.equals(ds1[i].getMahoadon()) )== true) {
						sum = sum + ds1[i].getThanhtien() + ds1[i].getThue();
					}
				dshd[n].setTongtien(sum);
		}
	}	
	
	public void them(HoaDon x) {
		n= dshd.length;
		dshd = Arrays.copyOf(dshd,n+1);
		dshd[n] = new HoaDon(x);
//		n++;
	}
	
	public void xoa () {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma hoa don can xoa:");
		String mahoadon = sc.nextLine();
		int pos = 0,check = 0;
		for(int i=0;i<dshd.length;i++) {
			if( (mahoadon.equals(dshd[i].getMahoadon()) )== true) {
				pos = i;
				check = 1;
			}
		}
		if(check == 1 ) xoa(mahoadon,pos);
		else  System.out.println("Khong tim thay ma hoa don");
		
	}
	
	public void xoa (String mahoadon,int p) {
		for(int i=p;i < dshd.length-1;i++)
			dshd[i] = dshd[i+1];
		dshd = Arrays.copyOf(dshd, dshd.length -1);
	}
	
	public HoaDon timMaHoaDon(String mahoadon) {
		for(int i=0;i<dshd.length;i++)
			if( (mahoadon.equals(dshd[i].getMahoadon()) )== true) {
				return dshd[i];
			}
		return null;
	}
	
	public void timMaHoaDon() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma hoa don can tim:");
		String mahoadon = sc.nextLine();
		HoaDon hd1 = timMaHoaDon(mahoadon);
		if(hd1 != null) {
			hd1.xuat();
		}
		else System.out.println("Khong tim thay");
	}
	
	private static HoaDon[] timMaKH(HoaDon[] dshd ,String makh) {
		HoaDon[] dshd1 = new HoaDon[0];
		int j = 0;
		for(int i=0;i< dshd.length;i++)
			if( (makh.equals(dshd[i].getMakh()) )== true) {
				dshd1 = Arrays.copyOf(dshd1,dshd1.length+1);
				dshd1[j] = new HoaDon();
				dshd1[j] = dshd[i];
				j++;
			}
		return dshd1; 
	}
	
	public void timMaKH() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma khach hang can tim:");
		String makh = sc.nextLine();
		HoaDon dshd1[] = timMaKH(dshd,makh);
		if(dshd1 != null ) {
			for(int i=0;i<dshd1.length;i++) {
				dshd1[i].xuat();
			}
		}
		else System.out.println("Khong tim thay");
	}
	public void timMaKH(String makh) {
		Scanner sc = new Scanner(System.in);
		HoaDon[] dshd1 = timMaKH(dshd,makh);
		if(dshd1.length !=0 ) {
			for(int i=0;i<dshd1.length;i++) {
				dshd1[i].xuat();
				dscthd.xuat(dshd1[i].getMahoadon());
			}
				
			
		}
		else System.out.println("Khong tim thay");
	}
	
	
	private static HoaDon[] timMaNhanVien(HoaDon[] dshd ,String manv) {
		HoaDon[] dshd1 = new HoaDon[0];
		int j = 0;
		for(int i=0;i< dshd.length;i++)
			if( (manv.equals(dshd[i].getManv()) )== true) {
				dshd1 = Arrays.copyOf(dshd1,dshd1.length+1);
				dshd1[j] = new HoaDon();
				dshd1[j] = dshd[i];
				j++;
			}
		return dshd1; 
	}

	public void timMaNhanVien() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma nhan vien can tim:");
		String manv = sc.nextLine();
		HoaDon dshd1[] = timMaNhanVien(dshd,manv);
		if(dshd1[0] != null ) {
			for(int i=0;i<dshd1.length;i++)
				dshd1[i].xuat();
		}
		else System.out.println("Khong tim thay");
		
	}
	
	private static HoaDon[] timNgayLap(HoaDon[] dshd, String ngaylap) {
		HoaDon[] dshd1 = new HoaDon[0];
		int j = 0;
		for(int i=0;i< dshd.length;i++)
			if( (ngaylap.equals(dshd[i].getNgaylap()) )== true) {
				dshd1 = Arrays.copyOf(dshd1,dshd1.length+1);
				dshd1[j] = new HoaDon();
				dshd1[j] = dshd[i];
				j++;
			}
		return dshd1; 
	}
	
	public void timNgayLap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ngay lap can tim:");
		String ngaylap = sc.nextLine();
		HoaDon dshd1[] = timNgayLap(dshd,ngaylap);
		if(dshd1[0] != null ) {
			for(int i=0;i<dshd1.length;i++)
				dshd1[i].xuat();
		}
		else System.out.println("Khong tim thay");
	}
	
	public void suaMaKH(HoaDon hd1) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Sua ma khach hang thanh:");
		String makh = sc.nextLine();
		hd1.setMakh(makh);
		for(int i=0;i<dshd.length;i++) 
			if( (hd1.getMahoadon().equals(dshd[i].getMahoadon()) )== true) 
				dshd[i].setMakh(hd1.getMakh());
	}
	
	public void suaMaNhanVien(HoaDon hd1) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Sua ma nhan vien thanh:");
		String manv = sc.nextLine();
		hd1.setManv(manv);
		for(int i=0;i<dshd.length;i++) 
			if( (hd1.getMahoadon().equals(dshd[i].getMahoadon()) )== true) 
				dshd[i].setManv(hd1.getManv());
	}
	
	public void suaNgayLap(HoaDon hd1) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Sua ngay lap thanh:");
		String ngaylap = sc.nextLine();
		hd1.setNgaylap(ngaylap);
		for(int i=0;i<dshd.length;i++) 
			if( (hd1.getMahoadon().equals(dshd[i].getMahoadon()) )== true) 
				dshd[i].setNgaylap(hd1.getNgaylap());
	}
	
	public void ThongKe() {
		double s = 0;
		for(int i=0;i<dshd.length;i++) {
			s = s + dshd[i].getTongtien();
		}
		System.out.println("So luong hoa don:"+dshd.length);
	}

	
}
