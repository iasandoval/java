package gov.state.nextgen.common.application;

import org.junit.Test;

public class TestRules {

    private static final String YES = "Y";
    private static final String NO = "N";

    private static void evaluateTest(String expected, RuleEvaluator rule) {
        if (rule.isMatch()) {
            System.out.println(expected + "=" + rule.getCategory());
            System.out.println(expected.equals(rule.getCategory()));
        } else {
            System.out.println("NO MATCH - " + expected);
        }
    }

    @Test
    public void evaluateEXFS_QTRACK2() {
        ApplicationRule rule = new ApplicationRule(YES, NO, YES, null, YES, null, null, null, null);
        evaluateTest("EXFS_QTRACK", new ApplicationRuleEvaluator(rule).evaluate());
    }

    @Test
    public void evaluateEXFS_QTRACK() {
        ApplicationRule rule = new ApplicationRule(YES, NO, YES, null, YES, YES, null, null, null);
        evaluateTest("EXFS_QTRACK", new ApplicationRuleEvaluator(rule).evaluate());
    }

}

