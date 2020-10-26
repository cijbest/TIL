package com.hive;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChartController {
	// HIVE 계정
	String url = "jdbc:hive2://192.168.111.130:10000/default";
	String userid = "root";
	String password = "111111";

	public ChartController() {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/getdata.mc")
	@ResponseBody
	public void getdata(HttpServletResponse res) throws Exception {
		Connection con = null;
		JSONArray ja = new JSONArray();
		
		// ★ Exception이 날 수 있는 부분이므로 꼭 try~catch 해주자
		try {
			con = DriverManager.getConnection(url, userid, password);
			
			PreparedStatement pstmt = con.prepareStatement("SELECT ROUND(AVG(speed),1), ROUND(AVG(temp),1), "
					+ "ROUND(AVG(oiltemp),1) FROM cardata GROUP BY(logdate)");
			ResultSet rset = pstmt.executeQuery();
			
			// [{name:'Sweden', data: [0,....]}, {}]
			JSONObject jo1 = new JSONObject();
			jo1.put("name", "SPEED");
			JSONArray d1 = new JSONArray();
			
			JSONObject jo2 = new JSONObject();
			jo2.put("name", "TEMP");
			JSONArray d2 = new JSONArray();
			
			JSONObject jo3 = new JSONObject();
			jo3.put("name", "OILTEMP");
			JSONArray d3 = new JSONArray();
			
			
			while (rset.next()) {
				d1.add(rset.getFloat(1));
				d2.add(rset.getFloat(2));
				d3.add(rset.getFloat(3));
				//d4.add(rset.getFloat(4));
			}
			jo1.put("data", d1);
			jo2.put("data", d2);
			jo3.put("data", d3);

			ja.add(jo1);
			ja.add(jo2);
			ja.add(jo3);
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}

		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	}
	
	@RequestMapping("/getdata2.mc")
	@ResponseBody
	public void getdata2(HttpServletResponse res) throws Exception {
		Connection con = null;
		JSONArray ja = new JSONArray();
		
		// ★ Exception이 날 수 있는 부분이므로 꼭 try~catch 해주자
		try {
			con = DriverManager.getConnection(url, userid, password);
			
			PreparedStatement pstmt = con.prepareStatement("SELECT rpm FROM cardata WHERE logdate='car.log.2020-09-26'");
			ResultSet rset = pstmt.executeQuery();
			
			// [{name:'Sweden', data: [0,....]}, {}]
			JSONObject jo1 = new JSONObject();
			jo1.put("name", "09-26");
			JSONArray d1 = new JSONArray();
			
			JSONObject jo2 = new JSONObject();
			jo2.put("name", "09-27");
			JSONArray d2 = new JSONArray();
			
			JSONObject jo3 = new JSONObject();
			jo3.put("name", "09-28");
			JSONArray d3 = new JSONArray();
			
			while (rset.next()) {
				d1.add(rset.getFloat(1));
			}
			jo1.put("data", d1);
			ja.add(jo1);
			
			
			pstmt = con.prepareStatement("SELECT rpm FROM cardata WHERE logdate='car.log.2020-09-27'");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				d2.add(rset.getFloat(1));
			}
			jo2.put("data", d2);
			ja.add(jo2);
			
			
			pstmt = con.prepareStatement("SELECT rpm FROM cardata WHERE logdate='car.log.2020-09-28'");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				d3.add(rset.getFloat(1));
			}
			jo3.put("data", d3);
			ja.add(jo3);

		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}

		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	}
	
}
