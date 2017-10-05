package com.ats.architecture.dao;


import java.util.*;

import com.ats.beans.AutoBeans;

public interface AutoDao {
	public void addAuto(AutoBeans auto);
	public void updateAuto(AutoBeans auto);

	public void deleteAll();
	public void deleteAuto (AutoBeans auto);

	public LinkedList<AutoBeans> selectAll();
}
