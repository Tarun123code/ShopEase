package com.shop;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			resp.sendRedirect("index.html");
			return;
		}
		else {
			String productName = (String) req.getParameter("productName");
			Long productId = Long.parseLong((String) req.getParameter("productId"));
			int productQuantity = Integer.parseInt((String) req.getParameter("quantity"));
			Long productPrice = Long.parseLong((String) req.getParameter("price"));
			
			long totalPrice = productPrice * productQuantity;



			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Shopping Cart</title>");
			
			pw.println("<style>");
			pw.println("* { box-sizing: border-box; }");
			
			pw.println("body {");
			pw.println("  font-family: Arial, sans-serif;");
			pw.println("  margin: 0;");
			pw.println("  background: #f3f4f6;");
			pw.println("  color: #333;");
			pw.println("}");
			
			pw.println("nav {");
			pw.println("  background: #1f2937;");
			pw.println("  padding: 18px 40px;");
			pw.println("  display: flex;");
			pw.println("  justify-content: space-between;");
			pw.println("  align-items: center;");
			pw.println("}");
			
			pw.println("nav .brand {");
			pw.println("  color: white;");
			pw.println("  font-size: 22px;");
			pw.println("  font-weight: bold;");
			pw.println("}");
			
			pw.println("nav a {");
			pw.println("  color: white;");
			pw.println("  text-decoration: none;");
			pw.println("  margin-left: 25px;");
			pw.println("  font-size: 15px;");
			pw.println("}");
			
			pw.println("nav a:hover { color: #fbbf24; }");
			
			pw.println(".container {");
			pw.println("  max-width: 650px;");
			pw.println("  margin: 50px auto;");
			pw.println("  padding: 20px;");
			pw.println("}");
			
			pw.println(".cart-card {");
			pw.println("  background: white;");
			pw.println("  border-radius: 14px;");
			pw.println("  padding: 30px;");
			pw.println("  box-shadow: 0 6px 20px rgba(0,0,0,0.08);");
			pw.println("}");
			
			pw.println(".success {");
			pw.println("  text-align: center;");
			pw.println("  margin-bottom: 28px;");
			pw.println("}");
			
			pw.println(".success-icon {");
			pw.println("  display: inline-block;");
			pw.println("  background: #dcfce7;");
			pw.println("  color: #15803d;");
			pw.println("  border-radius: 50%;");
			pw.println("  width: 55px;");
			pw.println("  height: 55px;");
			pw.println("  line-height: 55px;");
			pw.println("  font-size: 28px;");
			pw.println("}");
			
			pw.println(".success h1 {");
			pw.println("  font-size: 26px;");
			pw.println("  margin: 15px 0 8px;");
			pw.println("  color: #166534;");
			pw.println("}");
			
			pw.println(".success p {");
			pw.println("  color: #6b7280;");
			pw.println("  margin: 0;");
			pw.println("}");
			
			pw.println(".section-title {");
			pw.println("  font-size: 18px;");
			pw.println("  font-weight: bold;");
			pw.println("  margin-bottom: 18px;");
			pw.println("  border-bottom: 1px solid #e5e7eb;");
			pw.println("  padding-bottom: 12px;");
			pw.println("}");
			
			pw.println(".detail-row {");
			pw.println("  display: flex;");
			pw.println("  justify-content: space-between;");
			pw.println("  gap: 15px;");
			pw.println("  padding: 12px 0;");
			pw.println("  border-bottom: 1px solid #f0f0f0;");
			pw.println("}");
			
			pw.println(".detail-label { color: #6b7280; }");
			pw.println(".detail-value { font-weight: 600; text-align: right; }");
			
			pw.println(".total-row {");
			pw.println("  display: flex;");
			pw.println("  justify-content: space-between;");
			pw.println("  margin-top: 20px;");
			pw.println("  padding: 18px;");
			pw.println("  background: #f9fafb;");
			pw.println("  border-radius: 8px;");
			pw.println("  font-size: 19px;");
			pw.println("  font-weight: bold;");
			pw.println("}");
			
			pw.println(".total-price { color: #047857; }");
			
			pw.println(".buttons {");
			pw.println("  display: flex;");
			pw.println("  gap: 12px;");
			pw.println("  margin-top: 25px;");
			pw.println("}");
			
			pw.println(".btn {");
			pw.println("  flex: 1;");
			pw.println("  text-align: center;");
			pw.println("  padding: 13px;");
			pw.println("  border-radius: 8px;");
			pw.println("  text-decoration: none;");
			pw.println("  font-weight: bold;");
			pw.println("  font-size: 14px;");
			pw.println("}");
			
			pw.println(".btn-primary {");
			pw.println("  background: #2563eb;");
			pw.println("  color: white;");
			pw.println("}");
			
			pw.println(".btn-primary:hover { background: #1d4ed8; }");
			
			pw.println(".btn-secondary {");
			pw.println("  border: 1px solid #d1d5db;");
			pw.println("  color: #374151;");
			pw.println("}");
			
			pw.println(".btn-secondary:hover { background: #f3f4f6; }");
			
			pw.println("@media (max-width: 600px) {");
			pw.println("  nav { padding: 16px; }");
			pw.println("  nav .brand { font-size: 18px; }");
			pw.println("  nav a { margin-left: 12px; font-size: 13px; }");
			pw.println("  .container { margin: 20px auto; padding: 12px; }");
			pw.println("  .cart-card { padding: 22px; }");
			pw.println("  .buttons { flex-direction: column; }");
			pw.println("}");
			pw.println("</style>");
			
			pw.println("</head>");
			pw.println("<body>");
			
			// Navigation bar
			pw.println("<nav>");
			pw.println("  <span class='brand'>ShopEase</span>");
			pw.println("  <div>");
			pw.println("    <a href='products.html'>Products</a>");
			pw.println("    <a href='logout'>Logout</a>");
			pw.println("  </div>");
			pw.println("</nav>");
			
			// Cart card
			pw.println("<div class='container'>");
			pw.println("  <div class='cart-card'>");
			
			pw.println("    <div class='success'>");
			pw.println("      <div class='success-icon'>&#10003;</div>");
			pw.println("      <h1>Added to Cart!</h1>");
			pw.println("      <p>Your item has been added successfully.</p>");
			pw.println("    </div>");
			
			pw.println("    <div class='section-title'>Product Details</div>");
			
			pw.println("    <div class='detail-row'>");
			pw.println("      <span class='detail-label'>Product ID</span>");
			pw.println("      <span class='detail-value'>" + productId + "</span>");
			pw.println("    </div>");
			
			pw.println("    <div class='detail-row'>");
			pw.println("      <span class='detail-label'>Product Name</span>");
			pw.println("      <span class='detail-value'>" + productName + "</span>");
			pw.println("    </div>");
			
			pw.println("    <div class='detail-row'>");
			pw.println("      <span class='detail-label'>Price per item</span>");
			pw.println("      <span class='detail-value'>&#8377;" + productPrice + "</span>");
			pw.println("    </div>");
			
			pw.println("    <div class='detail-row'>");
			pw.println("      <span class='detail-label'>Quantity</span>");
			pw.println("      <span class='detail-value'>" + productQuantity + "</span>");
			pw.println("    </div>");
			
			pw.println("    <div class='total-row'>");
			pw.println("      <span>Total Price</span>");
			pw.println("      <span class='total-price'>&#8377;" + totalPrice + "</span>");
			pw.println("    </div>");
			
			pw.println("    <div class='buttons'>");
			pw.println("      <a class='btn btn-secondary' href='products.html'>Continue Shopping</a>");
			pw.println("      <a class='btn btn-primary' href='products.html'>Shop More</a>");
			pw.println("    </div>");
			
			pw.println("  </div>");
			pw.println("</div>");
			
			pw.println("</body>");
			pw.println("</html>");


	    }
	}	

}
