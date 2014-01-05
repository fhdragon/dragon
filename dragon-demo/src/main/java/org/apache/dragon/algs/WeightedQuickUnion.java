package org.apache.dragon.algs;

/**
 * 加权quick-union api
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at Jan 5, 2014
 * @since 1.0
 */
public class WeightedQuickUnion extends AbstractUnionFind {

	//Local variables
	/**
	 * 对应索引节点的权重
	 */
	private int[] ws;
	
	//Constructor
	/**
	 * Creates a new <code>WeightedQuickUnion</code> instance. initialize N sites with integer names(0, N - 1)
	 * 
	 * @param count
	 */
	public WeightedQuickUnion(int count){
		super(count);
		ws = new int[count];
		for(int i = 0; i < count; i++){
			ws[i] = 1;
		}
	}
	
	//Logic
	/**
	 * add connection between p and q, small tree connect to large connect
	 * 
	 * @param p
	 * @param q
	 */
	@Override
	public void union(int p, int q) {
		//give p and q the same root
		int pid = find(p);
		int qid = find(q);
		//rename p's component to q's name
		if(pid != qid) {
			if(ws[pid] < ws[qid]){
				ids[pid] = qid;
				ws[qid] = ws[pid];
			}else{
				ids[qid] = pid;
				ws[pid] = ws[qid];
			}
			ids[p] = qid;
			count--;
		}
	}
	
	/**
	 * component identifier for p(0, N - 1)
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public int find(int p) {
		//find component name
		while(p != ids[p]){
			p = ids[p];
		}
		return p;
	}

}
