public class BinarySearchTree< E extends Comparable<E> > {

    // A static nested class used to store the elements of this tree

    private static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;
        private Node( E value ) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node<E> root = null;
    
    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add( E obj ) {

        // pre-condtion:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        // special case:

        if ( root == null ) {
            root = new Node<E>( obj );
            return true;
        }

        // general case:

        return add( obj, root );
    }

    private boolean add( E obj, Node<E> current ) {

        boolean result;
        int test = obj.compareTo( current.value );

        if ( test == 0 ) {
            result = false;
        } else if ( test < 0 ) {
            if ( current.left == null ) {
                current.left = new Node<E>( obj );
                result = true;
            } else {
                result = add( obj, current.left );
            }
        } else {
            if ( current.right == null ) {
                current.right = new Node<E>( obj );
                result = true;
            } else {
                result = add( obj, current.right );
            }
        }
        return result;
    }

    /**
     * Looks up for obj in this BinarySearchTree, returns true
     * if obj is found and false otherwise.
     *
     * @param obj value to look for
     * @return true if the object has been found and false otherwise
     */

    public boolean contains( E obj ) {

        // pre-condtion:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        return contains( obj, root );
    }

    private boolean contains( E obj, Node<E> current ) {

        boolean result;

        if ( current == null ) {

            result = false;

        } else {

            int test = obj.compareTo( current.value );

            if ( test == 0 ) {

                result = true;

            } else if ( test < 0 ) {

                result = contains( obj, current.left );

            } else {

                result = contains( obj, current.right );

            }
        }
        return result;
    }

    // Implement the method max()
    public E max() {
        Node<E> root1 = root;

        if(root1 == null) {
            return null;
        }
        while(root1.right != null) {
            root1 = root1.right;
        }

        return root1.value;
    }
    
    // Implement the method min()
    public E min() {

        Node<E> root1 = root;

        if(root1 == null) {
            return null;
        }
        while(root1.left != null) {
            root1 = root1.left;
        }

        return root1.value;
    }
    
    // Implement the method depth()
    public int depth() {

        Node<E> rootl = root;
        Node<E> rootr = root;
        int size = 1;

        if(rootl == null && rootr == null) {
            return 0;
        }

        while(rootl.left != null) {
            size++;
        }
        while(rootr.right != null) {
            size++;
        }


        return size;
    }
    
    // Implement the method isTwoTree()
    public boolean isTwoTree() {

        return false;

    }

    
    public String toString() {
        return toString( root );
    }

    private String toString( Node<E> current ) {

        if ( current == null ) {
            return "()";
        }

        return "(" + toString( current.left ) + current.value + toString( current.right ) + ")";
    }

}
