package gov.state.nextgen.common.application;

/**
 * Interface for RuleEvaluator.
 * Interface created as part of CR 495143 (WI 97791/97794).
 *
 * @author isandovalhiguera AKA Nacho
 *
 */
public interface RuleEvaluator {

    RuleEvaluator evaluate();

    boolean isMatch();

    ApplicationRule getMatch();

    ApplicationRule getState();

    String getCategory();
}
