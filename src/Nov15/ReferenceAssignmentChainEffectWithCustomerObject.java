package Nov15;

public class ReferenceAssignmentChainEffectWithCustomerObject {

    static final class IceCream {
        final int price = 7;
    }

    public static void main(String[] args) {
        threeVariablesCheckReference();

        System.out.println();

        threeVariablesCheckReferenceWithHashCode();

        System.out.println();

        fourVariablesCheckReferenceWithHashCode();
    }

    /**
     * first is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858 when second is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858
     * third is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858 when first is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858
     * third is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858 when second is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858
     * first is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858 and hashcode of first is 1846274136 when second is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@61bbe9ba
     * third is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858 when first is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858
     * third is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@6e0be858 and hashcode of third is 1846274136 when second is Nov15.ReferenceAssignmentChainEffectWithCustomerObject$IceCream@61bbe9ba
     */
    public static void threeVariablesCheckReference() {
        IceCream first = new IceCream(),
                second = new IceCream(),
                third = new IceCream();

        first = second;
        checkVariableReference("first", second, first, "second", second);

        third = first;
        checkVariableReference("third", first, third, "first", first);
        checkVariableReference("third", second, third, "second", second);

        second = new IceCream();
        checkVariableReference("first", second, first, "second", second);
        checkVariableReference("third", first, third, "first", first);
        checkVariableReference("third", second, third, "second", second);
    }

    /**
     * first is 1627674070 when second is 1627674070
     * third is 1627674070 when first is 1627674070
     * third is 1627674070 when second is 1627674070
     * first is 1627674070 and hashcode of first is 1627674070 when second is 1360875712
     * third is 1627674070 when first is 1627674070
     * third is 1627674070 and hashcode of third is 1627674070 when second is 1360875712
     */
    public static void threeVariablesCheckReferenceWithHashCode() {
        IceCream first = new IceCream(),
                second = new IceCream(),
                third = new IceCream();

        first = second;
        checkVariableReferenceWithHashCode("first", second, first, "second", second);

        third = first;
        checkVariableReferenceWithHashCode("third", first, third, "first", first);
        checkVariableReferenceWithHashCode("third", second, third, "second", second);

        second = new IceCream();
        checkVariableReferenceWithHashCode("first", second, first, "second", second);
        checkVariableReferenceWithHashCode("third", first, third, "first", first);
        checkVariableReferenceWithHashCode("third", second, third, "second", second);
    }

    /**
     * first is 1625635731 when second is 1625635731
     * third is 1625635731 when first is 1625635731
     * third is 1625635731 when second is 1625635731
     * second is 1580066828 when four is 1580066828
     * first is 1625635731 and hashcode of first is 1625635731 when second is 1580066828
     * first is 1625635731 and hashcode of first is 1625635731 when four is 1580066828
     * third is 1625635731 when first is 1625635731
     * third is 1625635731 and hashcode of third is 1625635731 when second is 1580066828
     * third is 1625635731 and hashcode of third is 1625635731 when four is 1580066828
     */
    public static void fourVariablesCheckReferenceWithHashCode() {
        IceCream first = new IceCream(),
                second = new IceCream(),
                third = new IceCream(),
                four = new IceCream();

        first = second;
        checkVariableReferenceWithHashCode("first", second, first, "second", second);

        third = first;
        checkVariableReferenceWithHashCode("third", first, third, "first", first);
        checkVariableReferenceWithHashCode("third", second, third, "second", second);

        second = four;
        checkVariableReferenceWithHashCode("second", four, second, "four", four);
        checkVariableReferenceWithHashCode("first", second, first, "second", second);
        checkVariableReferenceWithHashCode("first", four, first, "four", four);
        checkVariableReferenceWithHashCode("third", first, third, "first", first);
        checkVariableReferenceWithHashCode("third", second, third, "second", second);
        checkVariableReferenceWithHashCode("third", four, third, "four", four);
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

    public static void checkVariableReferenceWithHashCode(String variableOneName,
                                              Object variableOneSupposedValue,
                                              Object variableOneValue,
                                              String variableTwoName,
                                              Object variableTwoValue) {
        if (variableOneValue == variableOneSupposedValue) {
            System.out.println(variableOneName + " is " + variableOneSupposedValue.hashCode()
                    + " when " + variableTwoName + " is " + variableTwoValue.hashCode());
        } else {
            System.out.println(variableOneName + " is " + variableOneValue.hashCode()
                    + " and hashcode of " + variableOneName + " is " + variableOneValue.hashCode()
                    + " when " + variableTwoName + " is " + variableTwoValue.hashCode());
        }
    }
}
