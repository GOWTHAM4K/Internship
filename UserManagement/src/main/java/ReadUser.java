import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReadUser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		
		PrintWriter out = resp.getWriter();
		
		try
		{
			Connection con = DBconnector.getDbConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from login_user");
			JSONArray row = new JSONArray();
			while(rs.next()) {
				
					
					JSONObject js = new JSONObject();
					js.put("uid",rs.getInt("uid"));
					js.put("uname",rs.getString("username"));
					js.put("pwd",rs.getString("passwd"));
					row.put(js);
					
					
				
			}
			out.println(row);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
