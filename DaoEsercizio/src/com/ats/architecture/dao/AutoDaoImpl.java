package com.ats.architecture.dao;

import java.sql.*;
import java.util.LinkedList;

import com.ats.Connection.ConnectionFactory;
import com.ats.beans.AutoBeans;


public class AutoDaoImpl implements AutoDao {

	Connection conn=null;
	PreparedStatement ps= null;
	ResultSet rs= null;

	public AutoDaoImpl(){

	}

	private Connection getConnection(){
		Connection con;
		con=ConnectionFactory.getIstance().getConnection();
		return con;
	}


	public void addAuto(AutoBeans auto){
		try{
			String query="insert into auto (targa, marca, modello, prezzo) values(?,?,?,?)";
			conn= getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, auto.getTarga());
			ps.setString(2, auto.getMarca());
			ps.setString(3, auto.getModello());
			ps.setDouble(4, auto.getPrezzo());
			ps.executeQuery();
			System.out.println("auto inserita correttamente");
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public void updateAuto(AutoBeans auto){
		
		String query="update auto set prezzo=? where targa=?";
		conn= getConnection();
		try{
			ps=conn.prepareStatement(query);
			ps.setDouble(1, auto.getPrezzo());
			ps.setInt(2, auto.getTarga());
			ps.executeQuery();
			System.out.println(" auto modificata correttamente");
			ps.close();
			conn.close();
		}catch(SQLException e ){

			System.out.println("ops c'è stato qualche problema.");
			System.out.println("Modifica prezzo non riuscita!");
		}
	}

	public void deleteAll(){
		String query="delete from auto";
		conn= getConnection();
		try{
			ps=conn.prepareStatement(query);

			ps.executeQuery();

			ps.close();
			conn.close();
		}catch(SQLException e ){

			System.out.println("ops c'è stato qualche problema.");

		}

	}

	public void deleteAuto (AutoBeans auto) {
		String query="delete from auto where targa=?";
		try{
			conn=getConnection();
			ps=conn.prepareStatement(query);
			ps.setInt(1, auto.getTarga());
			ps.executeQuery();
			System.out.println("Operazione eseguita");
			ps.close();
			conn.close();
		}catch(SQLException e){
			System.out.println("c'è stato un errore");
		}

	}

	public LinkedList<AutoBeans> selectAll() {
		String query="select* from student";
		LinkedList <AutoBeans> auto= new LinkedList<AutoBeans>();
		try{
			conn=getConnection();
			ps=conn.prepareStatement(query);
			rs=	ps.executeQuery();

			while(rs.next()){

				AutoBeans tmp=new AutoBeans();
				tmp.setTarga(rs.getInt("targa"));
				tmp.setMarca(rs.getString("marca"));
				tmp.setModello(rs.getString("modello"));
				tmp.setPrezzo(rs.getDouble("prezzo"));
				auto.add(tmp);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Selezione non riuscita!");
		}
		return auto;

	}



}
