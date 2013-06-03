package org.apache.dragon.commons.web;

import org.apache.dragon.commons.lang.Filter;

/**
 * StringFilter:  HTML filter utility.
 * Reserved Characters in HTML: Some characters are reserved in HTML and XHTML. 
 * HTML and XHTML processors must support the five special characters listed in the table below:
 *	----------------------------------------------------------------
 * 	|	Character	Entity Number	Entity Name		Description    |
 *	|	"			&#34;			&quot;			quotation mark |
 *	|	'			&#39;			&apos;			apostrophe     |
 *	|	&			&#38;			&amp;			ampersand      |
 *	|	<			&#60;			&lt;			less-than      |
 *	|	>			&#62;			&gt;			greater-than   |
 *  ----------------------------------------------------------------
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2012/04/27
 * @since 1.0
 */
public abstract class HtmlFilter {
	
	//Logic
	/**
	 * Filter the specified str string for characters that are sensitive in
	 * HTML. 
	 * 
	 * @param str
	 *            The str string to be filtered
	 * @return null - if str is blannk
	 * @throws NullPointerException - if str is null
	 */
	public static String encode(String str){
		return HtmlFilter.DefaultCharENUM.encode(str);
	}
	
	/**
	 * decode str to html
	 * 
	 * @param str
	 * @throws NullPointerException if str is null
	 */
	public static String decode(String str){
		return HtmlFilter.DefaultCharENUM.decode(str);
	}
	
	//Implements
	/**
	 * CharNumStringFilter: char -> entity num
	 *
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2012/04/27
	 * @since 1.0
	 */
	public static class CharNumStringFilter implements Filter<String> {

		// Logic
		/**
		 * Filter the specified str string for characters that are sensitive in
		 * HTML. 
		 * 
		 * @param str
		 *            The str string to be filtered
		 * @return null - if str is blannk
		 * @throws NullPointerException - if str is null
		 * 
		 * @see jp.gummy.platform.filter.StringFilter#encode(java.lang.String)
		 */
		@Override
		public String encode(String str) {
			// str to char[]
			char content[] = str.toCharArray();

			// per char
			StringBuilder result = new StringBuilder(content.length);
			for (int i = 0; i < content.length; i++) {
				switch (content[i]) {
					case '<':
						result.append("&#60;");
						break;
					case '>':
						result.append("&#62;");
						break;
					case '&':
						result.append("&#38;");
						break;
					case '"':
						result.append("&#34;");
						break;
					case '\'':
						result.append("&#39;");
						break;
					default:
						result.append(content[i]);
				}
			}

			return (result.toString());
		}

		/**
		 * decode str to html
		 * 
		 * @param str
		 * @throws NullPointerException if str is null
		 * 
		 * @see jp.gummy.platform.filter.StringFilter#decode(java.lang.String)
		 */
		@Override
		public String decode(String str) {
			// str to char[]
			char cs[] = (str).toCharArray();

			// per char
			StringBuilder result = new StringBuilder(cs.length);
			for (int i = 0, ci = cs.length; i < ci; i++) {
				if(cs[i] == '&') {
					if(i < ci - 4 && cs[i + 1] == '#' && cs[i + 4] == ';'){
						if(cs[i + 2] == '6' && cs[i + 3] == '0'){
							i += 4;
							result.append('<');
						}else if(cs[i + 2] == '6' && cs[i + 3] == '2'){
							i += 4;
							result.append('>');
						}else if(cs[i + 2] == '3' && cs[i + 3] == '8'){
							i += 4;
							result.append('&');
						}else if(cs[i + 2] == '3' && cs[i + 3] == '9'){
							i += 4;
							result.append('\'');
						}else if(cs[i + 2] == '3' && cs[i + 3] == '4'){
							i += 4;
							result.append('"');
						}else{
							result.append(cs[i]);
						}
					}else{
						result.append(cs[i]);
					}
				}else{
					result.append(cs[i]);
				}
			}
			return result.toString();
		}
		
	}
	
	/**
	 * CharNameStringFilter: char -> entity name
	 *
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2012/04/27
	 * @since 1.0
	 */
	public static class CharNameStringFilter implements Filter<String> {
		
		// Logic
		/**
		 * Filter the specified str string for characters that are sensitive in
		 * HTML. 
		 * 
		 * @param str
		 *            The str string to be filtered
		 * @return null - if str is blannk
		 * @throws NullPointerException - if str is null
		 * 
		 * @see jp.gummy.platform.filter.StringFilter#encode(java.lang.String)
		 */
		@Override
		public String encode(String str) {
			// str to char[]
			char content[] = str.toCharArray();
			
			// per char
			StringBuilder result = new StringBuilder(content.length);
			for (int i = 0; i < content.length; i++) {
				switch (content[i]) {
				case '<':
					result.append("&lt;");
					break;
				case '>':
					result.append("&gt;");
					break;
				case '&':
					result.append("&amp;");
					break;
				case '"':
					result.append("&quot;");
					break;
				case '\'':
					result.append("&apos;");
					break;
				default:
					result.append(content[i]);
				}
			}
			
			return (result.toString());
		}
		
		/**
		 * decode str to html
		 * 
		 * @param str
		 * @throws NullPointerException if str is null
		 * 
		 * @see jp.gummy.platform.filter.StringFilter#decode(java.lang.String)
		 */
		@Override
		public String decode(String str) {
			// str to char[]
			char cs[] = (str).toCharArray();
			
			// per char
			StringBuilder result = new StringBuilder(cs.length);
			for (int i = 0, ci = cs.length; i < ci; i++) {
				if(cs[i] == '&') {
					if(i < ci - 3 && cs[i + 1] == 'l' && cs[i + 2] == 't' && cs[i + 3] == ';'){
						i += 3;
						result.append('<');
					}else if(i < ci - 3 && cs[i + 1] == 'g' && cs[i + 2] == 't' && cs[i + 3] == ';'){
						i += 3;
						result.append('>');
					}else if(i < ci - 4 && cs[i + 1] == 'a' && cs[i + 2] == 'm' && cs[i + 3] == 'p' && cs[i + 4] == ';'){
						i += 4;
						result.append('&');
					}else if(i < ci - 5 && cs[i + 1] == 'a' && cs[i + 2] == 'p' && cs[i + 3] == 'o' && cs[i + 4] == 's' && cs[i + 5] == ';'){
						i += 5;
						result.append('\'');
					}else if(i < ci - 5 && cs[i + 1] == 'q' && cs[i + 2] == 'u' && cs[i + 3] == 'o' && cs[i + 4] == 't' && cs[i + 5] == ';'){
						i += 5;
						result.append('"');
					}else{
						result.append(cs[i]);
					}
				}else{
					result.append(cs[i]);
				}
			}
			
			return result.toString();
		}
	}
	
	//Global Constants
	/**
	 * Default char <-> Entity Number
	 */
	public static final Filter<String> DefaultCharENUM = new CharNumStringFilter();
	/**
	 * Default char <-> Entity Name
	 */
	public static final Filter<String> DefaultCharENM = new CharNameStringFilter();
	
	//Test
	/**
	 * test...
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		String s = "&</school_name><major>理</major><faculty>情報系</fac>'\"&#60;\" is &amp;<\"asd";
		String ss = "&#38;&#60;/school_name&#62;&#60;major&#62;理&#60;/major&#62;&#60;faculty&#62;情報系&#60;/fac&#62;&#39;&#34;&#38;#60;&#34; is &#38;amp;&#60;&#34;asd";
		System.out.println("encode(String) : start " + System.nanoTime());
		if(encode(s).intern() == ss){
			System.out.println("encode(String) is ok");
		}else{
//			System.out.println("ss        = " + ss);
//			System.out.println("encode(s) = " + encode(s));
			throw new AssertionError("encode(String) is error");
		}
		System.out.println("encode(String) : stop " + System.nanoTime());
		System.out.println("decode(String) : start " + System.nanoTime());
		if(decode(ss).intern() == s){
			System.out.println("decode(String) is ok");
		}else{
//			System.out.println(s);
//			System.out.println(decode(ss));
			throw new AssertionError("decode(String) is error");
		}
		System.out.println("decode(String) : stop " + System.nanoTime());
		
		s = "&</school_name><major>理</major><faculty>情報系</fac>'\"&#60;\" is &amp;<\"asd";
		ss = "&amp;&lt;/school_name&gt;&lt;major&gt;理&lt;/major&gt;&lt;faculty&gt;情報系&lt;/fac&gt;&apos;&quot;&amp;#60;&quot; is &amp;amp;&lt;&quot;asd";
		System.out.println("HtmlFilter.DefaultCharENM.encode(String) : start " + System.nanoTime());
		if(HtmlFilter.DefaultCharENM.encode(s).intern() == ss){
			System.out.println("encode(String) is ok");
		}else{
//			System.out.println("ss        = " + ss);
//			System.out.println("encode(s) = " + HtmlFilter.DefaultCharENM.encode(s));
			throw new AssertionError("encode(String) is error");
		}
		System.out.println("HtmlFilter.DefaultCharENM.encode(String) : stop " + System.nanoTime());
		System.out.println("HtmlFilter.DefaultCharENM.decode(String) : start " + System.nanoTime());
		if(HtmlFilter.DefaultCharENM.decode(ss).intern() == s){
			System.out.println("decode(String) is ok");
		}else{
//			System.out.println(s);
//			System.out.println(decode(ss));
			throw new AssertionError("decode(String) is error");
		}
		System.out.println("HtmlFilter.DefaultCharENM.decode(String) : stop " + System.nanoTime());
	}

}
