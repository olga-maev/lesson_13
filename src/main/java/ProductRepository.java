public class ProductRepository {
    protected Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeId(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyId = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() != id) {
                tmp[copyId] = products[i];
            }
            copyId++;
        }
        products = tmp;

    }
}
