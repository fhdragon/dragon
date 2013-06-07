package org.apache.dragon.commons.set;

/**
 * The <code>Stack</code> class represents a last-in-first-out (LIFO) stack of objects. It extends class <tt>Vector</tt>
 * with five operations that allow a vector to be treated as a stack. The usual <tt>push</tt> and <tt>pop</tt>
 * operations are provided, as well as a method to <tt>peek</tt> at the top item on the stack, a method to test for
 * whether the stack is <tt>empty</tt>, and a method to <tt>search</tt> the stack for an item and discover how far it is
 * from the top.
 * <p>
 * When a stack is first created, it contains no items.
 * 
 * <p>
 * A more complete and consistent set of LIFO stack operations is provided by the {@link Deque} interface and its
 * implementations, which should be used in preference to this class. For example:
 * 
 * <pre>
 * {
 * 	&#064;code
 * 	Deque&lt;Integer&gt; stack = new ArrayDeque&lt;Integer&gt;();
 * }
 * </pre>
 * 
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2013-6-6
 * @since 1.0
 */
public interface Stack<E> {

	// Logic
	/**
	 * Pushes an item onto the top of this stack. This has exactly the same effect as: <blockquote>
	 * 
	 * <pre>
	 * addElement(item)
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param item
	 *            the item to be pushed onto this stack.
	 * @return the <code>item</code> argument.
	 * @see java.util.Vector#addElement
	 */
	long push(E item);

	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * 
	 * @return The object at the top of this stack (the last item of the <tt>Vector</tt> object).
	 * @exception EmptyStackException
	 *                if this stack is empty.
	 */
	E pop();

	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * 
	 * @return the object at the top of this stack (the last item of the <tt>Vector</tt> object).
	 * @exception EmptyStackException
	 *                if this stack is empty.
	 */
	E peek();

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return <code>true</code> if and only if this stack contains no items; <code>false</code> otherwise.
	 */
	boolean empty();

	/**
	 * Removes all of the elements from this collection (optional operation). The collection will be empty after this
	 * method returns.
	 */
	void clear();

	/**
	 * Returns the number of elements in this collection. If this collection contains more than <tt>Long.MAX_VALUE</tt>
	 * elements, returns <tt>Long.MAX_VALUE</tt>.
	 * 
	 * @return the number of elements in this collection
	 */
	long size();

}
