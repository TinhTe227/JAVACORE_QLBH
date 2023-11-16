package vn.devpro.sale.cart;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.update.customer.Customer;
import vn.devpro.update.customer.CustomerManagement;
import vn.devpro.update.product.Product;
import vn.devpro.update.product.ProductManagement;

public class SaleManagement {
	private static int autoId = 1;
	public static Scanner sc = new Scanner(System.in);

	private static ArrayList<Cart> listCart = new ArrayList<Cart>();

	private static ArrayList<Cart> payedCart = new ArrayList<Cart>();

	public static ArrayList<Cart> getListCart() {
		return listCart;
	}

	public static void setListCart(ArrayList<Cart> listCart) {
		SaleManagement.listCart = listCart;
	}

	public static ArrayList<Cart> getPayedCart() {
		return payedCart;
	}

	public static void setPayedCart(ArrayList<Cart> payedCart) {
		SaleManagement.payedCart = payedCart;
	}

	public static void execute() {
		do {
			System.out.println("\n-------------Quan ly ban hang------------------");
			System.out.println("Chon chuc nang quan ly: ");
			System.out.println("\t1. Tao  gio hang");
			System.out.println("\t2. Cap nhat gio hang");
			System.out.println("\t3. Them gio hang vao danh sach");
			System.out.println("\t4. Hien thi danh sach cac gio hang");
			System.out.println("\t5. Thong ke tong so tien thu duoc theo khach hang");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				createCart();
				break;
			case 2:
				updateCart();
				break;
			case 3:
				addCart();
				break;
			case 4:
				display();
				break;
			case 5:
				count();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
				break;
			}
		} while (true);
	}

	private static void createCart() {
		System.out.println("---------------Tao gio hang cho khach den shop----------------------");
		System.out.print("Nhap id khach hang: ");
		int idCustomer = Integer.parseInt(sc.nextLine());

		ArrayList<Integer> listProductID = new ArrayList<Integer>();

		listCart.add(new Cart(autoId++, idCustomer, listProductID));

		System.out.println("Tao gio hang thanh cong");
	}

	// Them gio hang vao danh sach sau khi gio hang da duoc thanh toan
	private static void addCart() {
		System.out.println("---------------Them gio hang vao danh sach da thanh toan---------------");
		System.out.print("Nhap id gio hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findCartById(id);
		if (index == -1) {
			System.out.println("Gio hang khong ton tai");
			return;
		}
		payedCart.add(listCart.get(index));
		System.out.println("Them gio hang vao danh sach thanh cong");

		// Cap nhat lai so luong san pham trong danh sach san pham
		// Lay ra id cac san pham trong gio hang
		for (int i = 0; i < listCart.get(index).getListProduct().size(); i++) {
			int idSP = listCart.get(index).getListProduct().get(i);
			// Tim so luong da mua cua san pham
			int index2 = ProductListManagement.findProductListById(idSP, listCart.get(index).getId());
			int amount = ProductListManagement.getListProduct().get(index2).getAmount();
			// Tim vi tri cua san pham trong danh sach san pham
			Product x = ProductManagement.getProductById(idSP);
			int currentAmount = x.getAmount();
			x.setAmount(currentAmount - amount);
		}

	}

	private static void display() {
		double tongTien = 0;
		for (Cart x : payedCart) {
			x.display();
			tongTien += x.tongTien();
		}
		System.out.printf("\t\tTong tien thu duoc tu tat ca cac gio hang: %10.2f%n", tongTien);
	}

	private static void count() {
		System.out.println("------------Thong ke tong so tien thu duoc theo khach hang----------------");
		for (Customer x : CustomerManagement.getList()) {
			double tongTien = 0;
			int idCustomer = x.getId();
			System.out.println("ID khach hang: " + idCustomer);
			for (Cart cart : payedCart) {
				if (cart.getCustomerID() == idCustomer) {
					tongTien += cart.tongTien();
				}
			}
			System.out.printf("Tong tien thu duoc tu khach hang co ID %d: %10.2f%n", idCustomer, tongTien);
		}

	}

	private static void updateCart() {
		System.out.println("----------------Cap nhat gio hang------------------");
		System.out.print("Nhap id gio hang muon cap nhat: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findCartById(id);
		if (index == -1) {
			System.out.println("Gio hang chua duoc khoi tao");
			return;
		}
		listCart.get(index).update();
	}

	public static int findCartById(int id) {
		for (int i = 0; i < listCart.size(); i++) {
			if (listCart.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
}