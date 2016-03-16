/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Connector.AlchemyConnector;
import Connector.RedisConnector;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 * @author Danica
 */
@WebServlet(urlPatterns = {"/AlchemyandRedisServlet"})
public class AlchemyandRedisServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
				
		String FACE_ENDPOINT_URL = "http://gateway-a.watsonplatform.net/calls/url/URLGetRankedImageFaceTags";
		
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
			String imageURL = (String) request.getParameter("imageURL");
			
			AlchemyConnector alchemyconnector = new AlchemyConnector();
			RedisConnector redisconnector = new RedisConnector();
			
			request.setAttribute("password", redisconnector.getPassword());
			request.setAttribute("host", redisconnector.getHost());
			request.setAttribute("port", redisconnector.getPort());
			
			StringBuilder sb = new StringBuilder();
			String line;
		
			URL face_url = new URL(FACE_ENDPOINT_URL+"?url="+imageURL+"&apikey="+alchemyconnector.getAPIKey()+"&outputMode=json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(face_url.openStream()));
			while ((line = reader.readLine()) != null){
				sb.append(line);
			}
			
			String imageJSON = sb.toString();
			
			//JSON Parser
			JSONParser parser = new JSONParser();
            Object obj = parser.parse(imageJSON);
            
            JSONObject imageURLJSON = (JSONObject) obj;
            
            JSONArray imageFacesJSON = (JSONArray) imageURLJSON.get("imageFaces");
            JSONObject imageFaces = (JSONObject) imageFacesJSON.get(0);
         
            JSONObject ageJSON = (JSONObject) imageFaces.get("age");
            String ageRange = ageJSON.get("ageRange").toString();
            
            JSONObject genderJSON = (JSONObject) imageFaces.get("gender");
            String gender = genderJSON.get("gender").toString();
			
			request.setAttribute("age", ageRange);
			request.setAttribute("gender", gender);
			
			//Store in Redis Service
			//Jedis jedis = null;
			try {
				//jedis = redisconnector.getPool().getResource();
				//jedis.lpush("Age", ageRange);
				//jedis.lpush("Gender", gender);
				
				//List<String> agelist = jedis.mget("Age");
				//request.setAttribute("age", agelist);
				
				//List<String> genderlist = jedis.mget("Gender");
				//request.setAttribute("gender", genderlist);
				
				//request.setAttribute("age", jedis.get("Age"));
				//request.setAttribute("gender", jedis.get("Gender"));
			} finally {
				//jedis.close();
			}
			
			response.setContentType("text/html");
			response.setStatus(200);
			request.getRequestDispatcher("viewinfo.jsp").forward(request, response);
		} catch (Exception e) {
		}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
