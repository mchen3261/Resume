//************************************************************

//  LinearNode.java       Author: Makayla Chen       Date: 2/20/2018
//  Course: Computer Science II: Section 2
//  Represents a node in a linked list.

//************************************************************

   
public class LinearNode<T>
{
	private LinearNode next;
    private T element;

    //---------------------------------------------------------

    //  Creates an empty node.

    //---------------------------------------------------------

    public LinearNode()
	{
		next = null;
		element = null;
    }

    //---------------------------------------------------------

    //  Creates a node storing the specified element.

    //---------------------------------------------------------

    public LinearNode (T elem)
    {
		next = null;
        element = elem;
    }

	//---------------------------------------------------------

    //  Returns the node that follows this one.

    //---------------------------------------------------------

    public LinearNode getNext()
    {
        return next;
    }//getNext
   
    //---------------------------------------------------------

    //  Sets the node that follows this one.

    //---------------------------------------------------------

    public void setNext (LinearNode node)
	{
        next = node;
    }//setNext   

    //---------------------------------------------------------

    //  Returns the element stored in this node.

    //---------------------------------------------------------

    public T getElement()
    {
        return element;
    }//getElement
   
    //---------------------------------------------------------

    //  Sets the element stored in this node.

    //---------------------------------------------------------

    public void setElement (T elem)
    {
        element = elem;
    }//setElement

}//LinearNode