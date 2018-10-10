package com.njusoft.its.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
public class DirAndFileUtil {
	/**
	 * 递归创建文件夹
	 * 
	 * @param dirPath
	 * @param isCover
	 *            若存在文件夹 是够覆盖
	 * @return
	 */
	public static boolean mkDirs(String dirPath, boolean isCover) {
		File file = new File(dirPath);
		if (!file.exists()) {
			file.mkdirs();
		} else {
			if (isCover) {
				file.delete();
				file.mkdirs();
			}
		}
		return true;
	}
	
	public static boolean isExits(String path) {
		File file = new File(path);
		return file.exists();
	}
	public static boolean deleteFileOrDir(String path) {
		boolean succcess=false;
		File file = new File(path);
		if (file.exists()) {
			file.delete();
			succcess=true;
		}
		return succcess;
	}
	/**
	 * 
	 * @param path
	 * @param header
	 * @param contentList
	 * @param isAppend 
	 * @return
	 * @throws IOException
	 */
	public static boolean writeFileLineByLine(String path, String header, List<String> contentList,boolean isAppend) throws IOException {
		BufferedWriter bw = null;
		try {
			if (isAppend) {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path),true), "UTF-8"));
			}else{
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path)), "UTF-8"));
			}
			if (Utils.validateStringNull(header)) {
				bw.write(header);
				bw.newLine();
			}
			for (String record : contentList) {
				bw.write(record);
				bw.newLine();
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
		return true;
	}
	/**
	 * 按行读取
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<String> readFileLineByLine(String path) throws IOException {
		List<String>  contents=new ArrayList<>();
		File file=new File(path);
		BufferedReader br=null;
	    br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
	    String content=null;
		try {
			while ((content=br.readLine())!=null) {
				contents.add(content);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (null!=br) {
				br.close();
			}
		}
		return contents;
		
	}
}
