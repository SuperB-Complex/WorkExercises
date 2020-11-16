package Nov15;

public class ReferenceAssignmentChainEffectWithNull {

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
        Object first = null,
                second = null,
                third = null;

        first = second;
        checkVariableReference("first", second, first, "second", second);

        third = first;
        checkVariableReference("third", first, third, "first", first);
        checkVariableReference("third", second, third, "second", second);

        second = new Object();
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
            System.out.println(variableOneName + " is " + variableOneSupposedValue + " when "
                    + variableTwoName + " is " + variableTwoValue);
        } else {
            System.out.println(variableOneName + " is " + variableOneValue + " when "
                    + variableTwoName + " is " + variableTwoValue);
        }
    }
}
