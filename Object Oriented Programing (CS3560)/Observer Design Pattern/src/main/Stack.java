package main;

public interface Stack {
	/*
	 * modeled by: String of Object 
	 * initial value: <>
	 */
	void Push(Object x);

	/*
	 * precondition: true 
	 * postcondition: self = <#x> * #self
	 */
	Object Pop();

	/*
	 * precondition: self != empty_string 
	 * postcondition: there exists a: String of Object, 
	 *                             b: Object 
	 *                                (#self = <b> * a) and 
	 *                                (self = a) and 
	 *                                (Pop() = b)
	 */
	Object Top();

	/*
	 * precondition: self != empty_string
	 * postcondition: there exists a: String of Object, 
	 *                             b: Object 
	 *                                (#self = <b> * a) and 
	 *                                (self = #self) and 
	 *                                (Top() = b)
	 */
	int Length();
	/*
	 * precondition: true 
	 * postcondition: Length = |self|
	 */
}