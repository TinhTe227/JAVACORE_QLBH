package vn.devpro.update;

import java.util.Scanner;

import vn.devpro.update.customer.CustomerManagement;
import vn.devpro.update.product.ProductManagement;
import vn.devpro.update.provider.ProviderManagement;
import vn.devpro.update.type.TypeManagement;



public class UpdateManagement {
	public static Scanner sc = new Scanner(System.in);
	public static void execute() {
		do {
			System.out.println("\n-------------Cap nhat thong tin he thong-----------");
			System.out.println("Chon chuc nang quan ly: ");
			System.out.println("\t1. Cap nhat nha cung cap");
			System.out.println("\t2. Cap nhat chung loai");
			System.out.println("\t3. Cap nhat san pham");
			System.out.println("\t4. Cap nhat khach hang");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1: 
				ProviderManagement.providerManagement();
				break;
			case 2: 
				TypeManagement.typeManagement();
				break;
			case 3: 
				ProductManagement.productManagement();
				break;
			case 4: 
				CustomerManagement.customerManagement();
				break;
			case 0: return;
			default:
				System.out.println("Lua chon khong hop le");
				return;
			}
		}while(true);
	}
}

