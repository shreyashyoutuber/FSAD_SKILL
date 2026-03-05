import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop","Dell Laptop",50000,10);
        Product p2 = new Product("Phone","Samsung Phone",20000,15);

        session.save(p1);
        session.save(p2);

        Product product = session.get(Product.class,1);
        System.out.println(product.getName());

        product.setPrice(55000);
        session.update(product);

        Product deleteProduct = session.get(Product.class,2);
        session.delete(deleteProduct);

        tx.commit();

        session.close();
        factory.close();
    }
}