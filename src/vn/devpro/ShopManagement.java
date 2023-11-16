package vn.devpro;

import java.util.Scanner;

import vn.devpro.sale.cart.SaleManagement;
import vn.devpro.search.SearchManagement;
import vn.devpro.update.UpdateManagement;
import vn.devpro.update.customer.CustomerManagement;
import vn.devpro.update.product.ProductManagement;
import vn.devpro.update.provider.ProviderManagement;
import vn.devpro.update.type.TypeManagement;

public class ShopManagement {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ProviderManagement.init();
		ProductManagement.init();
		TypeManagement.init();
		CustomerManagement.init();

		do {
			System.out.println("\n=========QUAN LY SHOP QUAN AO NAM=============");
			System.out.println("Chon chuc nang quan ly: ");
			System.out.println("\t1. Cap nhat thong tin cua cua hang");
			System.out.println("\t2. Chuc nang Quan ly ban hang");
			System.out.println("\t3. Tim kiem thong tin ve cua hang");
			System.out.println("\t0. Thoat");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				UpdateManagement.execute();
				break;
			case 2:
				SaleManagement.execute();
				;
				break;
			case 3:
				SearchManagement.execute();
				break;
			case 0:
				System.out.println("Thoat chuong trinh");
				System.exit(0);
			default:
				System.out.println("Lua chon khong hop le");
				break;
			}
		} while (true);
	}
}
