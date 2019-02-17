package com.utd.bst;

import java.util.Properties;

import com.utd.bst.impl.BstImpl;
import com.utd.bst.util.ReadPropertyFile;

public class Main {

	public static void main(String[] args) {

		Properties prop = ReadPropertyFile.readProperties("config.properties");
		BstImpl bstImpl = new BstImpl(prop.getProperty("List"));
		int[] nodetodelete = getNodesToDelete(prop.getProperty("DeleteNodes"));
		
		bstImpl.traverseBst();
		for(Integer n : nodetodelete) {
			bstImpl.deleteNode(n);
			bstImpl.traverseBst();
		}
	}
	
	static int[] getNodesToDelete(String list) {
		String[] strList = list.split(",");
		int[] deleteList = new int[strList.length];
		int i = 0;
		while(i<strList.length) {
			deleteList[i] = Integer.parseInt(strList[i++]);
		}
		return deleteList;
	}

}
