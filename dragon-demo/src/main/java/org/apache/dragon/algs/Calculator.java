package org.apache.dragon.algs;

/**
 * Calculator: 计算器实现
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Dec 30, 2013
 * @since 1.0
 */
public class Calculator {

	//Local variables
	
	//Logic
	/**
	 * parse s and calc it: 双栈算术
	 * 
	 * @param s
	 * @return
	 */
	public static double calc(String s) {
		double result = 0.0;
		Stack<String> ops = new ArrayStack<String>();
		Stack<Double> vals = new ArrayStack<Double>();
		for(String c : s.split("")){
			if(c.equals("(") || c.equals(" ")){
				
			}else if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
				ops.push(c);
			}else if(c.equals(")")){
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+")){
					v += vals.pop();
				}else if(op.equals("-")){
					v -= vals.pop();
				}else if(op.equals(" * ")){
					v *= vals.pop();
				}else if(op.equals("/")){
					v /= vals.pop();
				}
				vals.push(v);
			}else{
				vals.push(Double.parseDouble(s));
			}
		}
		return result;
	}

}
