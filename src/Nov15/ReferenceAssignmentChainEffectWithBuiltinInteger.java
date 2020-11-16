package Nov15;

public class ReferenceAssignmentChainEffectWithBuiltinInteger {

    /**
     * first is null when second is null
     * third is null when first is null
     * third is null when second is null
     * first is null when second is java.lang.Object@6e0be858
     * third is null when first is null
     * third is null when second is java.lang.Object@6e0be858
     * @param args
     */
    public static void main(String args[])
    {
        Object first = new Integer(1),
                second = new Integer(2),
                third = new Integer(3);

        first = second;
        checkVariableReference("first", second, first, "second", second);

        third = first;
        checkVariableReference("third", first, third, "first", first);
        checkVariableReference("third", second, third, "second", second);

        second = new Integer(22);
        checkVariableReference("first", second, first, "second", second);
        checkVariableReference("third", first, third, "first", first);
        checkVariableReference("third", second, third, "second", second);
    }

    public static void checkVariableReference(String variableOneName,
                                              Object variableOneSupposedValue,
                                              Object variableOneValue,
                                              String variableTwoName,
                                              Object variableTwoValue) {
        if (variableOneValue == variableOneSupposedValue) {
            System.out.println(variableOneName + " is " + variableOneSupposedValue
                    + " when " + variableTwoName + " is " + variableTwoValue);
        } else {
            System.out.println(variableOneName + " is " + variableOneValue
                    + " and hashcode of " + variableOneName + " is " + variableOneValue.hashCode()
                    + " when " + variableTwoName + " is " + variableTwoValue);
        }
    }
}
