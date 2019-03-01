/**
 * Derived class that represents an assignment statement in the SILLY language.
 *   @author Dave Reed
 *   @version 2/3/19
 */
public class Assignment extends Statement {
    private Token vbl;
    private Expression expr;

    /**
     * Reads in a assignment statement from the specified TokenStream
     *   @param input the stream to be read from
     */
    public Assignment(TokenStream input) throws Exception {
        this.vbl = input.next(); // read in variable
        Token op = input.next(); // read in equal
        if (this.vbl.getType() != Token.Type.IDENTIFIER || !op.toString().equals("=")) { //test assignment
            throw new Exception("SYNTAX ERROR: Malformed assignment statement");
        }
        this.expr = new Expression(input); // save expression
    }

    /**
     * Executes the current assignment statement.
     */
    public void execute() throws Exception {
        Interpreter.MEMORY.storeVariable(this.vbl, this.expr.evaluate()); // MEMORY is static field of interpreter
        // evaluate the right hand side, assigns to variable
    }

    /**
     * Converts the current assignment statement into a String.
     *   @return the String representation of this statement
     */
    public String toString() {
        return this.vbl + " = " + this.expr;
    }
}
