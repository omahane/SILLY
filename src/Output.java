/**
 * Derived class that represents an output statement in the SILLY language.
 *   @author Dave Reed
 *   @version 2/3/19
 */
public class Output extends Statement {
    private Expression expr; // need to be able store this expression for the purposes of outputting it
    // probably need to create an ArrayList to give a list of expressions


    /**
     * Reads in an output statement from the specified TokenStream.
     *   @param input the stream to be read from
     */
    public Output(TokenStream input) throws Exception {
        if (!input.next().toString().equals("output")) {
            throw new Exception("SYNTAX ERROR: Malformed output statement");
        }

        this.expr = new Expression(input);
    }

    /**
     * Executes the current output statement.
     */
    public void execute() throws Exception {
        DataValue result = this.expr.evaluate();
        if (result.getType() == Token.Type.STRING) {
            String str = (String)(result.getValue());
            System.out.println(str.substring(1, str.length()-1) + " ");
        }
        else {
            System.out.println(result.getValue());
        }
    }

    /**
     * Converts the current output statement into a String.
     *   @return the String representation of this statement
     */
    public String toString() {
        return "output " + this.expr;
    }
}
