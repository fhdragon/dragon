package org.apache.dragon.commons.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * file utilities: read, write, delete etc.
 * 
 * @author F.H Dragon(wenlong.meng@gmail.com)
 * @version 1.0 at 2011/11/28
 * @since 1.0
 */
public class FileUtil {
	
	//local variable
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(FileUtil.class);
	
	//Logic
	/**
	 * Appends the specified string to the specified file，if the file isn't exists, create and append
	 * 
	 * @param path the specified path of file
	 * @param msg 
	 */
	public static void append(String path, String msg){
		FileWriter out = null;
		try {
			out = new FileWriter(new File(path), true);
			out.append(msg);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			CloseUtil.close(out);
		}
	}
	
	/**
	 * Appends the specified string(\n) to be the specified file, if the file isn't exists, create and append
	 * 
	 * @param path the specified path of file
	 * @param msg
	 */
	public static void appendln(String path, String msg){
		FileWriter out = null;
		try {
			out = new FileWriter(new File(path), true);
			out.append(msg).append('\n');		
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			CloseUtil.close(out);
		}
	}
	
	/**
	 * read the content from the specified file
	 * 
	 * @param path the specified file
	 * @return
	 */
	public static String read(String path){
		return read(new File(path));
	}
	
	/**
	 * read the content from the specified file
	 * 
	 * @param file the specified file
	 * @return
	 */
	public static String read(File file){
		BufferedReader br = null;
		try {
			StringBuilder result = new StringBuilder();
			String line;
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(br);
		}
		return null;
	}
	
	/**
	 * delete rootDir and its sub child(FileType.File -- file, FileType)
	 * 
	 * @param rootDir
	 * @param filter
	 * @param type
	 */
	public static void deletes(String rootDir, String filter, Type type){
		//file
		File file = new File(rootDir);
		//filter
		FileFilter _filter = new SimpleFileFilter(filter, type);
		//delete
		deletes(file, _filter);
	}
	
	/**
	 * 删除rootDir目录中(包含其所有层子目录)符合filter规则的文件夹
	 * 
	 * @param rootDir
	 * @param filter
	 * @param type
	 */
	public static void deletes(File file, FileFilter filter){
		//true : delete
		if(filter.accept(file)){
			delete(file);
		}else {
			//false: check and delete the child of the file
			if(file.isDirectory()){
				for(File f : file.listFiles()){
					deletes(f, filter);
				}
			}
		}
	}
	
	/**
	 * remove file and its sub child(file\dir)
	 * 
	 * @param file
	 */
	public static void delete(File file){
		//loop file of the dir 
		if(file.isDirectory()){
			for(File f : file.listFiles()){
				delete(f);
			}
		}
		//delete file or dir
		file.delete();
		logger.debug("delete file: " + file.getAbsolutePath());
	}
	
	/**
	 * simple file filter
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at Apr, 8 2013
	 * @since 1.0
	 */
	public static class SimpleFileFilter implements FileFilter{
		
		//local variables
		/**
		 * regex
		 */
		private String regex;
		/**
		 * type
		 */
		private Type type;
		
		//Constructor
		/**
		 * create a FileFilter with the specified regex and type
		 * 
		 * @param regex
		 * @param type
		 */
		public SimpleFileFilter(String regex, Type type){
			this.regex = regex;
			this.type = type;
		}

		/**
		 * test the file is match the regex
		 * 
		 * @param file
		 */
		@Override
		public boolean accept(File file) {
			String s = "";
			//file name
			if(this.type == Type.Name){
				s = file.getName();
			//file content
			}else if(this.type == Type.Content){
				//read the content from file
				s = read(file);
			}
			//test match
			Pattern p = Pattern.compile(this.regex);
			Matcher m = p.matcher(s);
			return m.find();
		}
	}
	
	//inner class
	/**
	 * 文件类型：文件、目录
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2011/11/28
	 * @since 1.0
	 */
	public static enum FileType{
		File,
		Dir,
		File_Dir
	}
	
	/**
	 * 文件类型：文件、目录
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2011/11/28
	 * @since 1.0
	 */
	public static enum Type{
		Name,
		Content
	}
	
}
