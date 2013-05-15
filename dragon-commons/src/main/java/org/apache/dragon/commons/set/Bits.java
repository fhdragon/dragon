package org.apache.dragon.commons.set;

/**
 * bit collection interface: 定义位集合操作通用方法，see{@link BitArray}
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2012/02/01
 * @since 1.0
 */
public interface Bits {
	
	//Constants
	/**
	 * empty bits: match no bits
	 */
	EmptyBits EMPTY_BITS = new EmptyBits();
	/**
	 * full bits: match all bits
	 */
	FullBits FULL_BITS = new FullBits();

	//Logic
	/**
	 * Returns the value of the bit with the specified index. The value is
	 * <code>true</code> if the bit with the index <code>index</code> is
	 * currently set in this <code>Bits</code>; otherwise, the result is
	 * <code>false</code>.
	 * 
	 * @param index
	 *            the bit index.
	 * @return the value of the bit with the specified index.
	 * @exception IndexOutOfBoundsException
	 *                if the specified index is negative.
	 */
	public int get(int index);

	/**
	 * Sets the value(>-1) of the <code>bit</code> with the specified index to
	 * val.
	 * 
	 * @param index
	 *            the index of bits
	 * @param val
	 *            the value of the <code>bit</code> with the specified index
	 */
	public void set(int index, int val);
	
	/**
	 * Sets the all value of this bits to zero. 
	 */
	public void clear();

	/**
	 * Returns the total number of one bits in this bits. This is efficiently
	 * computed and cached, so that, if the bits is not changed, no
	 * recomputation is done for repeated calls.
	 * 
	 * @return the number of elements in this bits
	 */
	public int length();

	/**
	 * FullBits: see{@link Bits}}
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2012/02/01
	 * @since 1.0
	 */
	public static class FullBits implements Bits {

		//local variables

		//Construct
		/**
		 * Constructs an full Bits: any bit of this bits is 1
		 */
		public FullBits() {

		}
		
		//Logic
		/**
		 * Returns the value of the bit with the specified index. The value is
		 * <code>1</code> if the bit with the index <code>index</code> is
		 * currently set in this <code>Bits</code>; otherwise, the result is
		 * <code>0</code>.
		 * 
		 * @param index
		 *            the bit index.
		 * @return the value of the bit with the specified index. - 1
		 * @exception IndexOutOfBoundsException
		 *                if the specified index is negative.
		 */
		public int get(int index) {
			return 1;
		}

		/**
		 * Returns the total number of one bits in this bits. This is
		 * efficiently computed and cached, so that, if the bits is not changed,
		 * no recomputation is done for repeated calls.
		 * 
		 * @return the number of elements in this bits
		 */
		public int length() {
			return Integer.MAX_VALUE;
		}

		/**
		 * Sets the value of the <code>bit</code> with the specified index to
		 * val.
		 * 
		 * @param index
		 *            the index of bit
		 * @param val
		 *            the value of the <code>bit</code> with the specified index
		 * @return
		 * @throws UnsupportedOperationException if the <tt>set</tt> operation is not supported by this bits
		 */
		@Override
		public void set(int index, int val) {
			throw new UnsupportedOperationException();
		}

		/**
		 * Sets the all value of <code>index</code> to zero. 
		 * 
		 * @throws UnsupportedOperationException if the <tt>clear</tt> operation is not supported by this bits
		 */
		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "FullBits []";
		}
		
	}

	/**
	 * MatchNoBits: see{@link Bits}}
	 * 
	 * @author Wenlong Meng(wenlong.meng@gmail.com)
	 * @version 1.0 at 2012/02/01
	 * @since 1.0
	 */
	public static class EmptyBits implements Bits {

		//local variables

		//Construct
		/**
		 * Constructs an empty Bits
		 */
		public EmptyBits() {
			
		}

		//Logic
		/**
		 * Returns the value of the bit with the specified index. The value is
		 * <code>1</code> if the bit with the index <code>index</code> is
		 * currently set in this <code>Bits</code>; otherwise, the result is
		 * <code>0</code>.
		 * 
		 * @param index
		 *            the bit index.
		 * @return the value of the bit with the specified index. - 0
		 * @exception IndexOutOfBoundsException
		 *                if the specified index is negative.
		 */
		public int get(int index) {
			return 0;
		}

		/**
		 * Returns the total number of one bits in this bits. This is
		 * efficiently computed and cached, so that, if the bits is not changed,
		 * no recomputation is done for repeated calls.
		 * 
		 * @return the number of elements in this bits
		 */
		public int length() {
			return 0;
		}

		/**
		 * Sets the value of the <code>bit</code> with the specified index to
		 * val.
		 * 
		 * @param index
		 *            the index of bit
		 * @param val
		 *            the value of the <code>bit</code> with the specified index
		 * @return
		 * @throws UnsupportedOperationException if the <tt>set</tt> is not supported by this bits
		 */
		@Override
		public void set(int index, int val) {
			throw new UnsupportedOperationException();
		}

		/**
		 * Sets the all value of <code>index</code> to zero. 
		 */
		@Override
		public void clear() {
			//do nothing
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "EmptyBits []";
		}
	}
}
