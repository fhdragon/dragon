package org.apache.dragon.commons.set;

/**
 * BitArray: implementation of the <tt>Bits</tt> interface. see{@link Bits}
 * 
 * This class is a member of the Java Collections Framework</a>.
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2012/02/01
 * @since 1.0
 */
public class BitArray implements Bits {

	// local variables
	/**
	 * The content of this bits: The internal field corresponding to the
	 * serialField "words".
	 */
	private byte[] words;
	/**
	 * BitArray are packed into arrays of "words." Currently a word is a long,
	 * which consists of 64 bits, requiring 6 address bits. The choice of word
	 * size is determined purely by performance concerns.
	 */
	private final static int ADDRESS_BITS_PER_WORD = 3;
	private final static int BITS_PER_WORD = 1 << ADDRESS_BITS_PER_WORD;
	private final static int BIT_INDEX_MASK = BITS_PER_WORD - 1;
	/**
	 * Used to shift left or right for a partial word mask
	 */
	private static final int WORD_MASK = 0xFF;
	/**
	 * table of bits/byte
	 */
	private static final byte[] BYTE_COUNTS = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2,
			2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
			1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4,
			4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4,
			3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3,
			3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6,
			4, 5, 5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4,
			4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4,
			3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5,
			5, 6, 5, 6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6,
			3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5,
			5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7,
			6, 7, 7, 8 };
	/**
	 * the count of 'one' bit： -1 => if the array has been modified
	 */
	private int count;

	// Constructor
	/**
	 * Constructs an empty Bits
	 */
	public BitArray() {
		// init words
		initWords(1 << 16);
	}

	/**
	 * Creates a bit set whose initial size is large enough to explicitly
	 * represent bits with indices in the range <code>0</code> through
	 * <code>nbits-1</code>. All bits are initially <code>false</code>.
	 * 
	 * @param nbits
	 *            the initial size of the bit set.
	 * @exception NegativeArraySizeException
	 *                if the specified initial size is negative.
	 */
	public BitArray(int nbits) {
		// nbits can't be negative; size 0 is OK
		if (nbits < 0)
			throw new NegativeArraySizeException("nbits < 0: " + nbits);

		// init words
		initWords(nbits);
	}

	/**
	 * init words
	 * 
	 * @param nbits
	 */
	private void initWords(int nbits) {
		words = new byte[wordIndex(nbits - 1) + 1];
	}

	/**
	 * Given a bit index, return word index containing it.
	 * 
	 * @param bitIndex
	 */
	private static int wordIndex(int bitIndex) {
		return bitIndex >> ADDRESS_BITS_PER_WORD;
	}

	// Logic
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
	@Override
	public int get(int index) {
		// check range
		rangeCheck(index);

		return (words[wordIndex(index)] & (1 << (index & BIT_INDEX_MASK)));
	}

	/**
	 * Returns the total number of one bits in this bits. This is efficiently
	 * computed and cached, so that, if the bits is not changed, no
	 * recomputation is done for repeated calls.
	 * 
	 * @return the number of elements in this bits
	 */
	@Override
	public int length() {
		// if the array has been modified
		if (count == -1) {
			int c = 0;
			int end = words.length;
			for (int i = 0; i < end; i++) {
				c += BYTE_COUNTS[words[i] & WORD_MASK]; // sum bits per byte
			}
			count = c;
		}

		return count;
	}

	/**
	 * Sets the value(>-1) of the <code>bit</code> with the specified index to
	 * val.
	 * 
	 * @param index
	 *            the index of bits
	 * @param val
	 *            the value of the <code>bit</code> with the specified index - 0/1
	 */
	@Override
	public void set(int index, int val) {
		// check range
		rangeCheck(index);

		// set value
		words[wordIndex(index)] |= val << (index & BIT_INDEX_MASK);

		// flag: -1 => if the array has been modified
		count = -1;
	}

	/**
	 * Sets the all value of this bits to zero.
	 */
	@Override
	public void clear() {
		//loop: set a byte of this bits is 0, in other word, any bit of this bits is 0
		int i = words.length;
		while(--i > 0){
			words[i] = 0;
		}
		
		// 0 => if this bits is empty
		count = 0;
	}

	/**
	 * Checks if the given index is in range. If not, throws an appropriate
	 * runtime exception. This method does *not* check if the index is negative:
	 * It is always used immediately prior to an array access, which throws an
	 * ArrayIndexOutOfBoundsException if index is negative.
	 * 
	 * @param index
	 *            the index of bits
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 *             - if index is negative
	 */
	private void rangeCheck(int index) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("Index: " + index);
		}
	}

}
