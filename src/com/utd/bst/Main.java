package com.utd.bst;

import java.util.Properties;

import com.utd.bst.impl.BstImpl;
import com.utd.bst.util.ReadPropertyFile;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = ReadPropertyFile.readProperties("config.properties");
		BstImpl bstImpl = new BstImpl(prop.getProperty("List"));
		int[] nodetodelete = getNodesToDelete(prop.getProperty("DeleteNodes"));
		
		bstImpl.traverseBst();
		for(Integer n : nodetodelete) {
			bstImpl.deleteNode(n);
			bstImpl.traverseBst();
		}
		
		/*bstImpl.traverseBst();
		bstImpl.deleteNode(12);
		bstImpl.traverseBst();
		bstImpl.deleteNode(98);
		bstImpl.traverseBst();
		bstImpl.deleteNode(9);
		bstImpl.traverseBst();
		bstImpl.deleteNode(68);
		bstImpl.traverseBst();
		bstImpl.deleteNode(46);
		bstImpl.traverseBst();
		bstImpl.deleteNode(101);
		bstImpl.traverseBst();*/
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
