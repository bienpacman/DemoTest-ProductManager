import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();
ReadAndWrite readAndWrite = new ReadAndWrite();

    Scanner scanner = new Scanner(System.in);

    public void add() {
        int id = (products.size() > 0) ? (products.size() + 1) : 1;
        System.out.println("Product id +" + id);
        String name = inputName();
        double price = inputPrice();
        int quantity = inputQuantity();
        String describe = inputDescribe();

        Product product = new Product(id, name, price, quantity, describe);
        products.add(product);
    }

    private String inputDescribe() {
        System.out.println("Ghi chú :");
        return scanner.nextLine();
    }

    private int inputQuantity() {
        System.out.println("Nhập số lượng :");
        while (true) {
            try {
                Integer quantity = Integer.parseInt((scanner.nextLine()));
                if (quantity < 0) {
                    throw new NumberFormatException();
                }
                return quantity;
            } catch (NumberFormatException e) {
                System.out.println("Số lượng không hợp lệ !! Vui lòng nhập lại :");
            }
        }

    }

    private double inputPrice() {
        System.out.println("Nhập giá :");
        while (true) {
            try {
                double price = Double.parseDouble((scanner.nextLine()));
                if (price < 0) {
                    throw new NumberFormatException();
                }
                return price;
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ ! Vui lòng nhập lại :");
            }
        }
    }

    private String inputName() {
        System.out.println("Nhập tên sản phẩm :");
        return scanner.nextLine();
    }

    public int inputId() {
        System.out.print("Nhập id :");
        while (true) {
            try {
                int id = Integer.parseInt(scanner.nextLine());
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Id không tồn tại . Nhập lại đi :");
            }
        }
    }

    public void edit(int id) {
        boolean isExited = false;
        int size = products.size();
        for (int i = 0; i < size; i++) {
            if (products.get(i).getId() == id) {
                isExited = true;
                products.get(i).setName(inputName());
                products.get(i).setPrice(inputPrice());
                products.get(i).setQuantity(inputQuantity());
                products.get(i).setDescribe(inputDescribe());
                break;
            }
        }
        if (!isExited) {
            System.out.printf("id = %d không tồn tại . \n", id);
        } else {
        }
    }

    public void delete(int id) {
        Product product = null;
        int size = products.size();
        for (int i = 0; i < size; i++) {
            if (products.get(i).getId() == id) {
                product = products.get(i);
                break;
            }
        }
        if (product != null) {
            products.remove(product);
        } else {
            System.out.printf("id = %id không tồn tại . \n", id);
        }
    }

    public void show() {
        System.out.println("__________________________DANH SÁCH SẢN PHẨM____________________________");
        System.out.println();
        System.out.printf("%-10s%-21s%-17s%-14s%s\n", "ID", "Tên sản phẩm", "Giá", "Số lượng ", "Ghi chú");
        for (Product product : products) {
            System.out.println("_____________________________________________________________________________");
            System.out.printf("%-14s%-17s%-19s%-14s%s\n", product.getId(), product.getName(), product.getPrice(), product.getQuantity(), product.getDescribe());
        }
    }

    public void sortProductByPrice1() {
        Collections.sort(products, new SortProductByPrice1());
    }

    public void sortProductByPrice2() {
        Collections.sort(products, new SortProductByPrice2());
    }

public double  getMax(){
        double max = products.get(0).getPrice();
    for (int i = 0; i < products.size(); i++) {
        if (products.get(i).getPrice() > max){
            max = products.get(i).getPrice();
        }
    }
    System.out.println("Sản phẩm có giá lớn nhất là :" +max);
    return max;
}
}