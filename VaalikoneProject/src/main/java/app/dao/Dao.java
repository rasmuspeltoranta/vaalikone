package app.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.model.Candidate;
// all made by Rasmus

public class Dao {
	private Connection conn;
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	public void addUser(String username, String pw, String salt) {
		String sql = "insert into useraccount(username, hashedpassword, salt) values(?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, pw);
			stmt.setString(3, salt);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}
	public String getUserSalt(String username) {
		String result = "";
		String sql = "select salt from useraccount where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if ( rs.next()) {
				result = rs.getString("salt");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public String getUserPasswordHash(String username) {
		String result="";
		String sql = "select hashedpassword from useraccount where username = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if ( rs.next()) {
				result = rs.getString("hashedpassword");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
		public int saveCandidate(Candidate candidate) {
			Statement stmt=null;
			int count=0;
			try {
				stmt = conn.createStatement();
				count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values("+candidate.getEhdokas_id()+", '"+candidate.getSukunimi()+"', '"+candidate.getEtunimi()+"', '"+candidate.getPuolue()+"', '"+candidate.getKotipaikkakunta()+"', "+candidate.getIka()+", '"+candidate.getMiksi_eduskuntaan()+"', '"+candidate.getMita_asioita_haluat_edistaa()+"', '"+candidate.getAmmatti()+"')");
			} catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
	}
	public ArrayList<Candidate> readAllCandidates() {
		ArrayList<Candidate> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Candidate candidate=new Candidate();
				candidate.setEhdokas_id(rs.getInt("ehdokas_id"));
				candidate.setSukunimi(rs.getString("sukunimi"));
				candidate.setEtunimi(rs.getString("etunimi"));
				candidate.setPuolue(rs.getString("puolue"));
				candidate.setKotipaikkakunta(rs.getString("kotipaikkakunta"));
				candidate.setIka(rs.getInt("ika"));
				candidate.setMiksi_eduskuntaan(rs.getString("miksi_eduskuntaan"));
				candidate.setMita_asioita_haluat_edistaa(rs.getString("mita_asioita_haluat_edistaa"));
				candidate.setAmmatti(rs.getString("ammatti"));
				list.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Candidate getCandidateInfo(int ehdokas_id) {
		Candidate result = null;
		String sql = "select * from ehdokkaat where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, ehdokas_id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Candidate();
				result.setEhdokas_id(resultset.getInt("ehdokas_id"));
				result.setSukunimi(resultset.getString("sukunimi"));
				result.setEtunimi(resultset.getString("etunimi"));
				result.setPuolue(resultset.getString("puolue"));
				result.setKotipaikkakunta(resultset.getString("kotipaikkakunta"));
				result.setIka(resultset.getInt("ika"));
				result.setMiksi_eduskuntaan(resultset.getString("miksi_eduskuntaan"));
				result.setMita_asioita_haluat_edistaa(resultset.getString("mita_asioita_haluat_edistaa"));
				result.setAmmatti(resultset.getString("ammatti"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int updateCandidate(Candidate candidate) {
		int count = 0;
		String sql = "update ehdokkaat set sukunimi = ?, etunimi = ?, puolue = ?, kotipaikkakunta = ?, ika = ?, miksi_eduskuntaan = ?, mita_asioita_haluat_edistaa = ?, ammatti = ? where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, candidate.getSukunimi());
			stmt.setString(2, candidate.getEtunimi());
			stmt.setString(3, candidate.getPuolue());
			stmt.setString(4, candidate.getKotipaikkakunta());
			stmt.setInt(5, candidate.getIka());
			stmt.setString(6, candidate.getMiksi_eduskuntaan());
			stmt.setString(7, candidate.getMita_asioita_haluat_edistaa());
			stmt.setString(8, candidate.getAmmatti());
			stmt.setInt(9, candidate.getEhdokas_id());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public void RemoveCandidate(int ehdokas_id) {
		String sql = "delete from ehdokkaat where ehdokas_id=?";
		try {
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		
			statement.setInt(1, ehdokas_id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	

	
