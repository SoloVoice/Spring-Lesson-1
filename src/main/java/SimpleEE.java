import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "simpleServlet", urlPatterns = "/simple")
public class SimpleEE extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List<Product> prodStorage = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            prodStorage.add(new Product(i, "productName" + i, 1000));
        }
        for (Product p : prodStorage) {
            sb.append("Product ID: " + p.getId() + "| Product Name: " + p.getTitle() + "| Product Cost: " + p.getCost() + "\n");
        }
        out.printf(sb.toString());
    }

}