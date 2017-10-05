package com.ats.test;

import com.ats.architecture.dao.*;
import com.ats.beans.AutoBeans;

public class AutoDaoDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AutoDaoImpl autoDao= new AutoDaoImpl();
		AutoBeans autoBean= new AutoBeans();
		autoDao.deleteAll();
		autoBean.setTarga(111);
		autoBean.setMarca("Fiat");
		autoBean.setModello("panda");
		autoBean.setPrezzo(6000);
		
		AutoBeans autoBean1= new AutoBeans();
		autoBean1.setTarga(112);
		autoBean1.setMarca("Lamborghini");
		autoBean1.setModello("noh");
		autoBean1.setPrezzo(150000);
		
		autoDao.addAuto(autoBean1);
		autoDao.addAuto(autoBean);
		
		AutoBeans tmp= new AutoBeans();
	    tmp.setTarga(111);
	    tmp.setPrezzo(5500);
	    autoDao.updateAuto(tmp);
		
	    tmp.setTarga(123);
	    autoDao.deleteAuto(tmp);
		
	    System.out.println(autoDao.selectAll());
		
		
		
	}

}
