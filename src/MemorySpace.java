import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines the memory space for the SILLY interpreter.
 *   @author Dave Reed
 *   @version 2/3/19
 */
public class MemorySpace {
    private Map<Token, DataValue> stack;

    /**
     * Constructs an empty memory space.
     */
    public MemorySpace() {
        this.stack = new HashMap<Token, DataValue>();
    }

    /**
     * Declares a variable (and stores null) in the stack segment.
     * @param token the variable name
     */
    public void declareVariable(Token token) throws Exception {
        if (!this.stack.containsKey(token)) {
            this.stack.put(token, null);
        }
        else {
            throw new Exception("RUNTIME ERROR: variable " + token + " already declared");
        }
    }

    /**
     * Stores a variable/value in the stack segment.
     *   @param token the variable name
     *   @param val the value to be stored under that name
     */
    public void storeVariable(Token token, DataValue val) throws Exception {
        if (this.stack.containsKey(token)) {
            this.stack.put(token,  val);
        }
        else {
            throw new Exception("RUNTIME ERROR: variable " + token + " not declared");
        }
    }

    /**
     * Retrieves the value for a variable (from the stack segment).
     *   @param token the variable name
     *   @return the value stored under that name
     */
    public DataValue lookupVariable(Token token) throws Exception {
        if (this.stack.containsKey(token)) {
            return this.stack.get(token);
        }
        else {
            throw new Exception("RUNTIME ERROR: variable " + token + " not assigned");
        }
    }
}
